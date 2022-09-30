package demo

import "fmt"

// 静态变量
const FLAG = true

// 基础变量
var Flag = 1

// 包初始化函数
func init() {
	fmt.Println("This is a package demo ")
	Flag = 1024 // 注意点
}

// 包函数
func Show() {
	var msg = " 我是函数内部的变量 "
	fmt.Printf("FLAG => %v, Flag => %v\nmsg:%v\n", FLAG, Flag, msg)
}

// 结构体
type Person struct{ Name string }

func (p Person) paly() {
	fmt.Printf("%v 正在打游戏....", p.Name)
}

// 接口
type IPerson interface{ paly() }

func Exec(i IPerson) {
	i.paly()
}
