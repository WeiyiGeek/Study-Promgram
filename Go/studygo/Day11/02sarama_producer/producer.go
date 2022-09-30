package main

import (
	"fmt"
	"log"
	"os"
	"os/signal"
	"sync"
	"time"

	"github.com/Shopify/sarama"
)

// Go语言中使用第三方库sarama连接kafka服务进行生产，生产者示例。
var (
	wg                          sync.WaitGroup
	enqueued, successes, errors int // 统计参数
)

// 基于sarama第三方库开发的kafka client示例
func main() {
	// 1.NewConfig 返回一个具有正常默认值的新配置实例。
	config := sarama.NewConfig()
	config.Producer.Partitioner = sarama.NewRandomPartitioner // 随机新选出一个partition
	config.Producer.RequiredAcks = sarama.WaitForAll          // 发送完数据需要leader和follow都确认
	config.Producer.Return.Successes = true                   // 成功交付的消息将在success channel返回
	config.Producer.Partitioner = sarama.NewHashPartitioner   // 对Key进行Hash，同样的Key每次都落到一个分区，这样消息是有序的

	// 2.连接到 kafka 服务端
	// client, err := sarama.NewSyncProducer([]string{"10.10.107.225:9092"}, config)
	client, err := sarama.NewClient([]string{"10.10.107.225:9092"}, config)
	if err != nil {
		fmt.Println("producer closed, err:", err)
		return
	}
	defer client.Close()

	// 4.使用给定的客户端创建新的生产者，关闭此生产者时仍然需要在基础客户端上调用Close（）。
	producer, err := sarama.NewAsyncProducerFromClient(client)
	if err != nil {
		panic(err)
	}

	// 5.监听 SIGINT 信号触发程序停止
	signals := make(chan os.Signal, 1)
	signal.Notify(signals, os.Interrupt)

	wg.Add(1)
	// 6.启动一个 groutines 来计算成功次数
	go func() {
		defer wg.Done()
		for range producer.Successes() {
			successes++
		}
	}()

	wg.Add(1)
	// 7.启动一个 groutines 来计算失败次数
	go func() {
		defer wg.Done()
		for err := range producer.Errors() {
			log.Println(err)
			errors++
		}
	}()

ProducerLoop:
	for {
		// 8.构造一个消息生产者
		// msg := &sarama.ProducerMessage{Topic: "my_topic", Value: sarama.StringEncoder("This is a sarama test log！By WeiyiGeek!")}
		msg := &sarama.ProducerMessage{}
		msg.Topic = "my_topic"
		msg.Key = sarama.StringEncoder("sarama")
		message := fmt.Sprintf("This is a sarama test log！By WeiyiGeek! UnixTime:%v", time.Now().Unix())
		msg.Value = sarama.StringEncoder(message)

		fmt.Println(message)
		// 9.利用通道的形式将信息异步发送给kafka
		select {
		case producer.Input() <- msg:
			enqueued++
			time.Sleep(time.Second * 2)
			if enqueued >= 5 {
				producer.AsyncClose() // Trigger a shutdown of the producer.
				break ProducerLoop
			}
		case <-signals:
			producer.AsyncClose() // Trigger a shutdown of the producer.
			break ProducerLoop    // 按Ctrl+c则退出循环
		}
	}
	// 11.等待goroutine任务结束。
	wg.Wait()
	// 10.输出表示发生成功
	log.Printf("Successfully, enqueued: %v ,produced: %d; errors: %d\n", enqueued, successes, errors)
}
