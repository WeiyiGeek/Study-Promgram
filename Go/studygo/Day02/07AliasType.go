package main

import "fmt"

//1.类型定义
type NewInt int

//2.类型别名
type MyInt = int

// 类型定义 与 类型别名 区别演示
func demo1() {
	// 类型定义的使用
	var i NewInt
	i = 1024
	fmt.Printf("Type of i: %T, Value:%v \n", i, i)

	// 类型别名的使用
	var j MyInt
	j = 2048
	fmt.Printf("Type of j: %T, Value:%v \n", j, j)

	// rune 也是类型别名底层还是int32类型
	var k rune
	k = '中'
	fmt.Printf("Type of j: %T, Value:%c \n", k, k)
}

func main() {
	demo1()
	fmt.Println()
}
