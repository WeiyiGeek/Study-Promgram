package main

// Unidirectional channel

import (
	"fmt"
	"math"
	"sync"
)

var wg sync.WaitGroup
var once sync.Once

// 通道只写操作
func f1(ch1 chan<- float64) {
	defer wg.Done()
	for i := 0; i < 10; i++ {
		ch1 <- float64(i)
	}
	close(ch1)
}

// 通道只写与只读操作
func f2(ch2 chan<- float64, ch1 <-chan float64) {
	defer wg.Done()
	for i := range ch1 {
		ch2 <- math.Pow(i, 3)
	}
	// 确保某个操作只执行一次，防止因为通道关闭而其他并发(进程)不能读取
	once.Do((func() {
		close(ch2)
	}))
}

func main() {
	ch1 := make(chan float64, 10) // 带缓冲区的通道
	ch2 := make(chan float64, 10) // 带缓冲区的通道
	wg.Add(3)
	go f1(ch1)
	go f2(ch2, ch1) // 多次 goroutine 同一个函数
	go f2(ch2, ch1)
	wg.Wait()
	for {
		x, ok := <-ch2 // 循环遍历，直到读取到末尾
		if !ok {
			break
		}
		fmt.Printf("%.0f ", x)
	}
	fmt.Println()
}
