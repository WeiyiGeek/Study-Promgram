package main

import (
	"fmt"
	"time"
)

func demo1() {
	// 获取当前时间
	fmt.Println("当前时间: ", time.Now().Format("2006/01/02 15:04:05"))
}

func demo2() {
	// 开始时间
	startTime := time.Now()

	// 从1+...+1000之和
	sum := 0
	for i := 0; i <= 1000; i++ {
		sum += i
	}
	fmt.Println("从1+...+1000之和为", sum)

	// 结束时间
	endTime := time.Now()

	fmt.Println("该段代码耗时时间为:", endTime.Sub(startTime))
}

func main() {
	//demo1()
	fmt.Println()
	//demo2()

}
