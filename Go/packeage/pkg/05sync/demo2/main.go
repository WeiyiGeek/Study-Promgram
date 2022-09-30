package main

import (
	"fmt"
	"sync"
	"time"
)

func main() {
	var a = 0
	// 启动足够多个协程
	var lock sync.Mutex
	for i := 0; i < 1000000; i++ {
		go func(idx int) {
			lock.Lock()
			defer lock.Unlock()
			a += 1
			fmt.Printf("goroutine %d, a=%d\n", idx, a)
		}(i)
	}
	// 主程序等待1s 确保所有协程执行完
	time.Sleep(time.Second)
}
