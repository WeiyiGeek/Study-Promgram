package main

import "fmt"

// Sayer 接口
type Sayer interface{ say() }

// Mover 接口
type Mover interface{ move() }

// dog既可以实现Sayer接口，也可以实现Mover接口。
type dog struct{ name string }

// 实现Sayer接口
func (d dog) say() { fmt.Printf("%s会叫 汪汪汪\n", d.name) }

// 实现Mover接口
func (d dog) move() { fmt.Printf("%s会动 \n", d.name) }

func main() {
	var a = dog{name: "旺财"}
	var x Sayer = a // 将dog类型赋予给Sayer接口类型的变量x，此时它可以调用say方法
	var y Mover = a // 将dog类型赋予给Mover接口类型的变量y，此时它可以调用move方法
	x.say()         // 旺财会叫 汪汪汪
	y.move()        // 旺财会动
}
