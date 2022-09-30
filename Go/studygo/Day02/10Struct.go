package main

import (
	"fmt"
	"math"
)

// (1) 结构体构造函数
type Person struct {
	name, city string
	age        uint8
}

// 方式1.值传递(拷贝副本) 返回的是结构体
func newPerson(name, city string, age uint8) Person {
	return Person{
		name: name,
		city: city,
		age:  age,
	}
}

// 方式2.地址(指针类型变量)传递返回的是结构体指针
func newPointerPerson(name, city string, age uint8) *Person {
	return &Person{
		name: name,
		city: city,
		age:  age,
	}
}

func demo1() {
	// (1) 通过定义的函数直接进行结构体的初始化(值拷贝的方式)
	var person = newPerson("WeiyiGeek", "重庆", 20)
	fmt.Printf("newPerson Type : %T, Value : %v\n", person, person)
	// (2) 通过定义的函数直接传入指针类型的结构体进行初始化(地址拷贝的方式)
	var pointerperson = newPointerPerson("Go", "world", 12)
	fmt.Printf("newPointerPerson Type : %T, Value : %v\n", pointerperson, pointerperson)
}

// 2.结构体方法和接收者,只能被Person结构体实例化的对象进行调用，不能像函数那样直接调用。此处还是采用上面声明的结构体
func (p Person) ChangePersonName(name string) {
	p.name = name
	fmt.Printf("#执行 -> ChangePersonName 方法 -> p Ptr : %p ,value : %v\n", &p, p.name)
}
func (p *Person) ChangePointerPersonName(name string, age uint8) {
	p.name = name
	p.age = age
	fmt.Printf("#执行 -> ChangePointerPersonName 方法 -> p Ptr : %p (关键点),value : %v\n", p, p.name)
}

func demo2() {
	// 利用构造函数进行初始化
	p1 := newPerson("小黄", "Beijing", 20)
	fmt.Printf("p1 Pointer : %p , Struct : %+v \n", &p1, p1)
	// 调用 ChangePersonName 方法
	p1.ChangePersonName("小黑") // 值类型的接收者
	fmt.Printf("	p1 Pointer : %p , Struct : %+v \n", &p1, p1)
	// 调用 ChangePointerPersonName 方法
	p1.ChangePointerPersonName("小白", p1.age) //指针类型的接收者
	fmt.Printf("	p1 Pointer : %p , Struct : %+v \n", &p1, p1)
}

// 3.任意类型的接收者都可以拥有自己的方法
// MyInt 将int定义为自定义MyInt类型
type MyInt int

// SayHello 为MyInt添加一个SayHello的方法
func (m MyInt) SayHello(s string) {
	fmt.Printf("Hello, 我是一个int, %s", s)
}
func (m *MyInt) ChangeM(newm MyInt) {
	fmt.Printf("# Start old m : %d -> new m : %d \n", *m, newm)
	*m = newm
	fmt.Printf("# End old m : %d -> new m : %d \n", *m, newm)
}
func demo3() {
	// 声明
	//var m1 MyInt
	// 赋值
	//m1 = 100
	m1 := MyInt(255)
	// 调用类型方法
	m1.SayHello("Let'Go")
	fmt.Printf("SayHello -> Type m1 : %T, value : %+v \n", m1, m1)
	// 调用类型方法修改m1其值
	m1.ChangeM(1024)
	fmt.Printf("ChangeM -> Type m1 : %T, value : %+v \n", m1, m1)
	fmt.Println(float64(106) / float64(4))
	fmt.Println(math.Sqrt(float64(106) / float64(4)))
}

// 4.结构体匿名字段
type Anonymous struct {
	string
	int
}

func demo4() {
	a1 := Anonymous{"WeiyiGeek", 18}
	fmt.Printf("Struct: %#v ，字段1: %v , 字段2: %v \n", a1, a1.string, a1.int)
}

func main() {
	// demo1()
	fmt.Println()
	// demo2()
	fmt.Println()
	//demo3()
	fmt.Println()
	demo4()

}
