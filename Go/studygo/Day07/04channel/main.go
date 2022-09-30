package main

import (
	"fmt"
	"sync"
)

// make 函数申请内存空间的传入对象（实例化三种类型）
var s []int          // slice 切片
var m map[string]int // map 字典映射
var c chan int       // 指定通道中元素的类型

// 定义全局的waitGroup
var wg sync.WaitGroup

// 无缓冲的通道示例
func noBuffer() {
	fmt.Println(c)      // 未初始化的通道返回 nil （未向内存中申请空间）
	c := make(chan int) // 不带缓冲区通道的初始化 （但必须有对应的接收）
	fmt.Println("将 10 发生到 channel c 之中")
	wg.Add(1)
	go func() { // 并行任务的顺序非常重要，此处不能放在 c <- 10 后否则终端将会一直处于阻塞状态
		defer wg.Done()
		x := <-c
		fmt.Printf("Backgroup Goroutine 从 channel c 中取得 %v \n\n", x)
	}()
	c <- 10 // 将 10 发生到 channel c 之中（注意此行放的顺序）
	wg.Wait()
	defer close(c) // 关闭通道
}

// 有缓冲的通道示例
func useBuffer() {
	fmt.Println(c)        // 未初始化的通道返回 nil （未向内存中申请空间）
	c = make(chan int, 2) // 带缓冲区通道的初始化
	fmt.Println("通道缓冲数量（发送前）:", len(c))
	c <- 10                                // 将 10 发生到 channel c 之中
	fmt.Println("同样将 10 发生到 channel c 之中") // 此处将不会阻塞
	c <- 20                                // 将 10 发生到 channel c 之中
	fmt.Println("然后将 20 发生到 channel c 之中") // 如何缓冲区通道初始化为1，则此处将阻塞,如果初始化通道缓冲区大于等于2将会不阻塞
	fmt.Println("通道缓冲数量（发送后）:", len(c))
	x := <-c
	fmt.Printf("第一次，从channel c中取到了 %v\n", x)
	x = <-c
	fmt.Printf("第二次，从channel c中取到了 %v\n", x)
	fmt.Printf("channel c ptr = %p \n", c)
	defer close(c) // 关闭通道
}

func main() {
	noBuffer()
	useBuffer()
}
