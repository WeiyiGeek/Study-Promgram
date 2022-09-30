package main

import "fmt"

// 接口声明定义以及约定必须实现的方法
type speaker interface {
	speak()
	eat(string)
}
type person struct{ name, language string }

func (p person) speak() {
	fmt.Printf("我是人类，我说的是%v, 我叫%v\n", p.language, p.name)
}
func (p person) eat(food string) { fmt.Printf("喜欢的食物: %v\n", food) }

type cat struct{ name, language string }

func (c cat) speak() {
	fmt.Printf("动物猫，说的是%v, 叫%v\n", c.language, c.name)
}
func (c cat) eat(food string) { fmt.Printf("喜欢的食物: %v\n", food) }

type dog struct{ name, language string }

func (d dog) speak() {
	fmt.Printf("动物狗，说的是%v, 叫%v\n", d.language, d.name)
}
func (d dog) eat(food string) { fmt.Printf("喜欢的食物: %v\n", food) }

func talk(s speaker) {
	s.speak()
}

// (1) 接口基础使用演示
func demo1() {
	p := person{"WeiyiGeek", "汉语"}
	c := cat{"小白", "喵喵 喵喵..."}
	d := dog{"阿黄", "汪汪 汪汪...."}
	talk(p)
	talk(c)
	talk(d)
}

// (2) 接口类型的使用(可看作一种合约)方法不带参数以及方法带有参数
func demo2() {
	// 定义一个接口类型writer的变量w。
	var s speaker
	fmt.Printf("\nType %T\n", s) // 动态类型

	s = person{"接口类型-唯一", "汉语"}
	fmt.Printf("\nType %T\n", s) // 动态类型
	s.speak()
	s.eat("瓜果蔬菜")

	s = cat{"接口类型-小白", "喵喵..."}
	fmt.Printf("\nType %T\n", s) // 动态类型
	s.speak()
	s.eat("fish")

	s = dog{"接口类型-阿黄", "汪汪..."}
	fmt.Printf("\nType %T\n", s) // 动态类型
	s.speak()
	s.eat("bone")
}

func main() {
	demo1()
	fmt.Println()
	demo2()
}
