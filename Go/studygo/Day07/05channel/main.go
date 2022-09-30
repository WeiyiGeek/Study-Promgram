package main

import (
	"fmt"
	"sync"
)

// channel 遍历实践操作
var wg sync.WaitGroup

// 方式1
func method1() {
	ch1 := make(chan int)
	ch2 := make(chan int)
	// 开启goroutine将1~9的数发送到ch1中
	go func() {
		for i := 0; i < 10; i++ {
			ch1 <- i
		}
		close(ch1) // 关闭通道 ch2 （此时只能读不能写）
	}()
	// 开启goroutine从ch1中接收值，并将该值的平方发送到ch2中
	go func() {
		for {
			i, ok := <-ch1 // 通道关闭后再取值到末尾时，ok=false
			if !ok {
				break
			}
			ch2 <- i * i // 同样求取通道的平方
		}
		close(ch2) // 关闭通道 ch2 （此时只能读不能写）
	}()
	// 在主goroutine中从ch2中接收值打印
	fmt.Println("方式1:")
	for i := range ch2 { // 通道关闭后会退出for range循环
		fmt.Printf("%d ", i)
	}
}

// 负责将10～19发送到ch1中
func f1(ch1 chan int) {
	defer wg.Done()
	for i := 10; i < 20; i++ {
		ch1 <- i
	}
	close(ch1) // 关闭通道 ch1 （此时只能读不能写）
}

// 负责将接收ch1值的值进行平方运算
func f2(ch1, ch2 chan int) {
	defer wg.Done()
	for num := range ch1 {
		ch2 <- num * num
	}
	close(ch2) // 关闭通道 ch2 （此时只能读不能写）
}

// 方式2
func method2() {
	ch1 := make(chan int, 10)
	ch2 := make(chan int, 10)
	// goroutine 等待组数量设置
	wg.Add(2)
	// 开启 goroutine
	go f1(ch1)
	go f2(ch1, ch2)
	// 等待全部 goroutine 任务执行完毕
	wg.Wait()
	fmt.Println("方式2:")
	// 通道关闭后会退出for range循环
	for ret := range ch2 {
		fmt.Printf("%d ", ret)
	}
}

func main() {
	// 匿名函数
	method1()
	fmt.Println()
	// 常规函数
	method2()
}
