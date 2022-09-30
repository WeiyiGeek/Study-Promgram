package main

import (
	"fmt"
	"sync"
	"time"
)

// 示例2.采用通道Channel方式控制子goroutine退出
var wg sync.WaitGroup
var notifyChan = make(chan bool, 1) // 定义&声明内存申请一气呵成

// 并发调用work函数
func work() {
	defer wg.Done()
LOOPEXIT:
	for {
		fmt.Printf("%v : %v\n", time.Now().Format("2006-01-02 15:04:05"), "WeiyiGeek")
		time.Sleep(time.Millisecond * 500)
		select {
		case <-notifyChan:
			break LOOPEXIT // 退出跳转，如果直接break则无法跳出
		default:
			fmt.Println("# Default")
		}
	}
}

func main() {
	wg.Add(1)
	go work()
	time.Sleep(time.Second * 5)
	notifyChan <- true
	wg.Wait()
}
