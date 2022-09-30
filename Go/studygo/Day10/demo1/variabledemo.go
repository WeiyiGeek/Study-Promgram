package main

import (
	"fmt"
	"sync"
	"time"
)

// 示例1.采用自定义变量控制子goroutine退出
var wg sync.WaitGroup
var notify bool

// 并发调用work函数
func work() {
	defer wg.Done()
	for {
		fmt.Printf("%v : %v\n", time.Now().Format("2006-01-02 15:04:05"), "WeiyiGeek")
		time.Sleep(time.Millisecond * 500)
		if notify {
			break
		}
	}
}

func main() {
	wg.Add(1)
	go work()
	time.Sleep(time.Second * 5)
	notify = true
	wg.Wait()
}
