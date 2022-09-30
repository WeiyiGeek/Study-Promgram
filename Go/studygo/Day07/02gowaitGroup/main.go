package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

// 实例化结构体得到对象
var wg sync.WaitGroup

// goroutine 将调用的函数
func f1() {
	defer wg.Done() // goroutine结束就登记-1
	fmt.Println("输出的随机数：", rand.Intn(10))
}

// 当main函数任务中所有的goroutine都结束了，才结束main函数
func main() {
	fmt.Println("Start Main")
	// goroutine 调用
	for i := 0; i < 10; i++ {
		rand.Seed(time.Now().Unix()) // 随机数种子传入的是一个int64类型
		wg.Add(1)                    // 启动一个goroutine就登记+1
		go f1()
	}
	wg.Wait()               // 监听并等待main中的goroutine是否都运行结束(等待wg组为0时)。
	fmt.Println("End Main") // 输出再也没有卡顿了
}
