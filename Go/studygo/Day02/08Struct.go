package main

import (
	"fmt"
	"unsafe"
)

// 1.结构体初识还是老示例采用结构体描述人员信息并进行赋值使用
type Person struct {
	name  string
	age   uint8
	sex   bool
	hobby []string
}

func demo1() {
	// 方式1.声明一个Persin类型的变量x
	var x Person
	// 通过结构体中的属性进行赋值
	x.name = "WeiyiGeek"
	x.age = 20
	x.sex = true // {Boy,Girl)
	x.hobby = []string{"Basketball", "乒乓球", "羽毛球"}
	// 输出变量x的类型以及其字段的值
	fmt.Printf("Type of x : %T, Value : %v \n", x, x)
	x.name = "WeiyiGeeker"
	fmt.Printf("My Name is %v \n", x.name)

	// 方式2.在声明是进行赋值(key：value，或者 value)的值格式
	// 使用键值对初始化
	var y = Person{
		name:  "Go",
		age:   16,
		sex:   false,
		hobby: []string{"Computer", "ProgramDevelopment"},
	}
	fmt.Printf("Type of y : %T, Value : %v \n", y, y)
	// 非常注意此种方式是按照结构体中属性顺序进行赋值,同样未赋值的为该类型的零值
	// 使用值的列表初始化
	z := Person{
		"WeiyiGeek",
		10,
		true,
		[]string{},
	}
	fmt.Printf("Type of z : %T, Value : %v \n", z, z)
}

// 2.匿名结构体(只能使用一次，所以常常使用与临时场景)
func demo2() {
	var temp struct {
		title   string
		address []string
	}
	temp.title = "地址信息"
	temp.address = []string{"中国", "重庆", "江北区"}
	fmt.Printf("Type of temp : %T\nStruct define: %#v \nValue : %v\n", temp, temp, temp)
}

// 3.结构体指针
func demo3() {
	// 方式1.结构体利用new实例化在内存中申请一块空间
	var p1 = new(Person)
	(*p1).name = "WeiyiGeek" // 取得地址存放的值并将其进行覆盖
	p1.age = 20              // Go语言的语法糖自动根据指针找到对应地址的值并将其值覆盖。
	fmt.Printf("Type of p1 : %T, Struct 实例化结果: %#v\n", p1, p1)

	// 方式2.采用取地址&符号进行实例化结构体(效果与new差不多)
	p2 := &Person{}
	(*p2).name = "Golang" // 取得地址存放的值并将其进行覆盖
	p2.age = 12           // Go语言的语法糖自动根据指针找到对应地址的值并将其值覆盖。
	p2.sex = true
	fmt.Printf("Type of p2 : %T, Struct 实例化结果: %#v\n", p2, p2)

	// 5.使用键值对初始化(也可以对结构体指针进行键值对初始化)
	// 当某些字段没有初始值的时候，该字段可以不写。此时没有指定初始值的字段的值就是该字段类型的零值。
	p3 := &Person{
		name: "北京",
	}
	fmt.Printf("p3 Value = %#v \n", p3)

	// 6.使用值的列表初始化
	// 初始化结构体的时候可以简写，也就是初始化的时候不写键，直接写值：
	p4 := &Person{
		"WeiyiGeek",
		20,
		false,
		[]string{},
	}
	fmt.Printf("p4 Value = %#v \n", p4)

	// 4.探究Struct结构体开辟的是连续的内存空间
	/**
		name: 1 字节 {0xc00019a060}
		age: 1 Bit 由于类型是 uint8 {0xc00019a070}
		sex: 1 字节 {0xc00019a071}
		hobby: {0xc00019a078}
	**/
	fmt.Printf("*p2 size of = %d, p2 align of = %d \n", unsafe.Sizeof(*p2), unsafe.Alignof(p2))
	fmt.Printf("Pointer p2 = %p, \name = %p,p2.name size of = %d \nage = %p, p2.age size of = %d\nsex = %p, p2.sex size of = %d\nhobby = %p,p2.hobby size of = %d \n", p2, &p2.name, unsafe.Sizeof((*p2).name), &p2.age, unsafe.Sizeof(p2.age), &p2.sex, unsafe.Sizeof(p2.sex), &p2.hobby, unsafe.Sizeof(p2.hobby))
}

// 4.值传递
func personChange(p Person) {
	p.name = "Change"
}

func personPointerChange(p *Person) {
	p.name = "PointerChange"
}
func demo4() {

	p4 := &Person{
		name: "WeiyiGeek",
	}
	personChange(*p4)
	fmt.Printf("personChange(*p4) ->	name = %v \n", p4.name)

	personPointerChange(p4)
	fmt.Printf("personPointerChange(*p4) ->	name = %v", p4.name)
}

// 请问下面代码的执行结果是什么？
type student struct {
	name string
	age  int
}

func homework1() {
	m := make(map[string]*student)
	stus := []student{
		{name: "小王", age: 18},
		{name: "娜扎", age: 23},
		{name: "大王", age: 900},
	}
	fmt.Printf("stus ： %p \n", &stus)

	for _, stu := range stus {
		m[stu.name] = &stu
		fmt.Printf("for stu ：%p, value : %v, Size: %d\n", &stu, stu, unsafe.Sizeof(stu.age))
	}
	for k, v := range m {
		fmt.Println(k, "=>", v.name)
	}
}

func main() {
	//demo1()
	fmt.Println()
	//demo2()
	fmt.Println()
	//demo3()
	fmt.Println()
	//demo4()
	fmt.Println()
	homework1()

}
