package main

import (
	"fmt"
	"time"
)

// 方式1，常规函数方式
func hello(count int) {
	fmt.Printf("欢迎你第 %d 次\n", count)
}
func demo1() {
	for i := 0; i < 5; i++ {
		go hello(i) // 开启一个单独的goroutine去执行hello函数(任务)
	}
}

// 方式2.匿名函数方式
func demo2() {
	for i := 0; i < 5; i++ {
		go func(count int) {
			fmt.Printf("第 %d 次欢迎你\n", count)
		}(i)
	}
}

// 程序启动之后会创建一个主Goroutine去执行。
func main() {
	fmt.Println("[*] main start")
	demo1()
	demo2()
	time.Sleep(time.Second)
	fmt.Println("[-] main end")
}

// 如果main函数结束了，则由main启动的goroutine也结束了。
