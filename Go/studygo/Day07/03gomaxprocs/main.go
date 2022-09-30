package main

import (
	"fmt"
	"runtime"
	"sync"
)

var wg sync.WaitGroup

func a() {
	defer wg.Done()
	for i := 0; i < 6; i++ {
		println("Func A() :", i)
	}
}

func b() {
	defer wg.Done()
	for i := 0; i < 6; i++ {
		println("Func B() :", i)
	}
}

func main() {
	fmt.Println("[*] Main Start")
	fmt.Println("当前机器的 CPU 核心数:", runtime.NumCPU()) // NumCPU返回当前进程可用的逻辑CPU数量。
	runtime.GOMAXPROCS(2)
	wg.Add(1)
	go a() // 并发调用a函数（后输出）
	wg.Add(1)
	go b()                                                    // 并发调用a函数（先输出）
	fmt.Println("当前机器的 goroutine 数:", runtime.NumGoroutine()) // NumGoroutine返回当前存在的goroutine数。
	wg.Wait()
	fmt.Println("[*] Main End")
}
