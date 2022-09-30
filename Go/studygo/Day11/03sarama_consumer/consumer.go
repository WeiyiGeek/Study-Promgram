package main

import (
	"fmt"
	"sync"

	"github.com/Shopify/sarama"
)

// Go语言中使用sarama第三方库连接kafka服务进行消费，消费者示例。
func main() {

	// 1.连接到 kafka 服务端
	consumer, err := sarama.NewConsumer([]string{"10.10.107.225:9092"}, nil)
	if err != nil {
		fmt.Printf("fail to start consumer, err:%v\n", err)
		return
	}

	// 2.根据topic取到所有的分区
	partitionList, err := consumer.Partitions("my_topic")
	if err != nil {
		fmt.Printf("fail to get list of partition:err%v\n", err)
		return
	}
	fmt.Println("分区信息:", partitionList)

	// 3.遍历所有的分区
	var wg sync.WaitGroup
	wg.Add(1)
	for partition := range partitionList {
		// 4.针对每个分区创建一个对应的分区消费者
		pc, err := consumer.ConsumePartition("my_topic", int32(partition), sarama.OffsetNewest)
		if err != nil {
			fmt.Printf("failed to start consumer for partition %d,err:%v\n", partition, err)
			return
		}
		defer pc.AsyncClose()

		// 5.异步从每个分区消费信息
		go func(sarama.PartitionConsumer) {
			defer wg.Done()
			for msg := range pc.Messages() {
				fmt.Printf("Topic: %v ,Partition:%d ,Offset:%d ,Key: %v ,Value: %v \n", msg.Topic, msg.Partition, msg.Offset, string(msg.Key), string(msg.Value))
			}
		}(pc)
	}
	wg.Wait()
}
