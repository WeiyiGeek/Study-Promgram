package main

import "fmt"

// 单一常量声明
const pi = 3.1415926535898

// 批量常量声明
const (
	e    = 2.7182
	flag = false
)

// 特殊批量常量声明
const (
	a = 1
	b
	_
	c
)

// iota 常量计数器
const (
	_     = iota               // 0
	d, e1 = iota + 1, iota + 2 // 2,3 常量名称不能重复
	f, g  = iota + 1, iota + 2 // 3,4
)

const (
	_  = iota             // 0
	KB = 1 << (10 * iota) // 1024
	MB = 1 << (10 * iota)
	GB = 1 << (10 * iota)
	TB = 1 << (10 * iota)
	PB = 1 << (10 * iota)
)

func main() {
	fmt.Println("pi :", pi)
	fmt.Println("e :", e, " , flag:", false)
	fmt.Println("特殊批量常量声明:", a, b, c)
	fmt.Println("iota 常量计数器 :", d, e1, f, g)
	fmt.Println("文件体积大小 :", KB, MB, GB, TB, PB)
}
