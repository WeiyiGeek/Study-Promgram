package main

import (
	"fmt"
	"os"
	"os/signal"
	"syscall"
	"time"

	nsq "github.com/nsqio/go-nsq"
)

// NSQ Consumer(消费者) 示例演示
// NsqConsumer 是一个消费者类型结构体
type NsqConsumer struct {
	Title string
}

// HandleMessage 是需要实现的处理消息的方法
func (m *NsqConsumer) HandleMessage(msg *nsq.Message) (err error) {
	fmt.Printf("%s : recv from %v, msg:%v\n", m.Title, msg.NSQDAddress, string(msg.Body))
	return
}

// 初始化Consumer消费者
func (NC *NsqConsumer) InitConsumer(topic string, channel string, address string) (err error) {
	// 1.NewConfig返回一个新的默认nsq配置
	config := nsq.NewConfig()

	// 2.查找轮询间隔此处设置15s
	config.LookupdPollInterval = 15 * time.Second

	// 3.NewConsumer为指定的主题/频道创建新的Consumer实例
	c, err := nsq.NewConsumer(topic, channel, config)
	if err != nil {
		fmt.Printf("create consumer failed, err:%v\n", err)
		return
	}

	// 4.AddHandler为此使用者接收的消息设置处理程序，可以多次调用该函数以添加其他处理程序，注意其必须放在连接NSQD和NSQLOOKUP前。
	c.AddHandler(NC)

	// 5.两种方式连接到NSQD
	// if err := c.ConnectToNSQD(address); err != nil {   // 直接连NSQD
	if err := c.ConnectToNSQLookupd(address); err != nil { // 通过lookupd查询连NSQD
		return err
	}
	return nil
}

func main() {
	// 实例化消费者
	consumer := &NsqConsumer{
		Title: "NSQ_USE",
	}

	// 初始化连接NSQD进行获取消息队列中的值
	err := consumer.InitConsumer("Topic_Demo", "channel_first", "10.10.107.225:4161")
	if err != nil {
		fmt.Printf("init consumer failed, err:%v\n", err)
		return
	}

	// 定义一个信号的通道
	c := make(chan os.Signal)
	// 转发键盘中断信号到c
	signal.Notify(c, syscall.SIGINT)
	// 通道输出消息队列中的值阻塞
	<-c
}
