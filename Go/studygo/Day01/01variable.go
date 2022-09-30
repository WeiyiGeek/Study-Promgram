package main

import "fmt"

// 变量声明(单一-全局)
var singleName string
var notUseVar bool

// 变量声明(批量-全局)
var (
	multiName string
	multiAge  int8
)

func main() {
	// 对声明后的变量赋值
	singleName = "Weiyi_"
	multiName = "Geek"
	multiAge = 18

	// 变量初始化（局部）
	var name string = "WeiyiGeek"
	var sex, addr = "boy", "China"

	// 类型推导变量
	var flag = true
	var count = 1024

	// 简短变量声明（只能在函数中）
	briefCount := 65535

	fmt.Printf("My Name is %s, Sex is %s , Address: %s\n", name, sex, addr)
	fmt.Println("Alias Name :", singleName, multiName, " Age is :", multiAge)
	fmt.Print("类型推导 ：", flag, count)
	fmt.Println(", 简短变量 ：", briefCount)
}
