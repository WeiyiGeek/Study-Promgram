package main

import (
	"fmt"
	"sync"
)

// Goroutine Select 多路复用
var wg sync.WaitGroup

func main() {
	// 示例1
	ch1 := make(chan int, 1)
	fmt.Println("// 示例 1	")
	for i := 0; i < 10; i++ {
		select {
		case x := <-ch1:
			fmt.Printf("index : %d , x = %d\n", i, x) // 通道缓冲区为1时,结果时可以预测的.
		case ch1 <- i: // 将会把(变量i)偶数值传给ch1通道
		default:
			fmt.Printf("index : %d , default\n", i)
		}
	}

	// 示例2
	ch2 := make(chan int, 2)
	fmt.Println("// 示例 2")
	wg.Add(1)
	go func() {
		wg.Done()
		for i := 1; i <= 5; i++ {
			ch2 <- i + i
		}
		close(ch2)
	}()
	wg.Wait()
	for i := 1; i <= 5; i++ {
		select {
		case j := <-ch2:
			fmt.Println("case 1: ", i, j) // 通道缓冲区为大于1时,结果是不可以预测的.
		case ch2 <- i:
			fmt.Println("case 2: ch2 <- i", i)
		default:
			fmt.Println("默认执行", i)
		}
	}
}
