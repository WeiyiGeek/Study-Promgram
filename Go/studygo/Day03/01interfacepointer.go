package main

import (
	"fmt"
)

// 接口类型声明
type Mover interface {
	move()
}
type dog struct{}

// 值接收者实现接口
func (d dog) move() {
	fmt.Println("值接收者实现接口 -> 狗...移动....")
}

// 使用值接收者实现接口之后，不管是dog结构体还是结构体指针*dog类型的变量都可以赋值给该接口变量.
func demo1() {
	var m1 Mover
	var d1 = dog{} // 值类型
	m1 = d1        // m1可以接收dog类型的变量
	fmt.Printf("Type : %#v \n", m1)
	m1.move()

	var d2 = &dog{} // 指针类型
	m1 = d2         // x可以接收指针类型的(*dog)类型的变量
	fmt.Printf("Type : %#v \n", m1)
	m1.move()
}

// 指针接收者实现接口
type Runer interface{ run() }
type cat struct{}

func (c *cat) run() { fmt.Println("指针接收者实现接口 -> 猫...跑....") }

// 此时实现run接口的是*cat类型，所以不能给m1传入cat类型的c1，此时x只能存储*dog类型的值。
func demo2() {
	var m1 Runer
	var c1 = cat{}
	//m1不可以接收dog类型的变量
	// m1 = c1 // 报错信息: cannot use c1 (variable of type cat) as Runer value in assignment: missing method run (run has pointer receiver)compilerInvalidIfaceAssign
	fmt.Printf("Type : %#v \n", c1)

	//m1只能接收*dog类型的变量
	var c2 = &cat{}
	m1 = c2
	fmt.Printf("Type : %#v \n", c2)
	m1.run()

}

func main() {
	demo1()
	fmt.Println()
	demo2()
}
