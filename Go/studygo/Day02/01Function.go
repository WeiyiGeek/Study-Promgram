package main

import (
	"errors"
	"fmt"
	"strings"
	"time"
)

// 函数：将一段代码封装到代码块之中
// 1.无参函数
func f1() {
	fmt.Println("Hello World, Let's Go")
}

// 2.有参函数
func f2(name string) {
	fmt.Println("Hello", name)
}

// 3.函数返回值
func f3(i int, j int) int {
	sum := i + j
	return sum
}

// 4.函数多命名返回值与参数类型简写
func f4(x, y int) (sum, sub int) {
	sum = x + y
	sub = x - y
	return
}

// 5.可变参数
func f5(title string, value ...int) string {
	return fmt.Sprintf("Title : %v , Value : %v \n", title, value)
}

// 6.变量作用域之全局变量

const PATH = "/home/weiyigeek"

var author = "WeiyiGeek"

func f6() {
	fmt.Println("author:", author, ",Home PATH:", PATH)
}

// 7.变量作用域之局部变量
func f7(x, y int) {
	localAuthor := "WeiyiGeek" // 局部变量外部无法引用
	fmt.Println("localAuthor = ", localAuthor, ",x = ", x, ",y = ", y)
	// 语句块定义的变量
	if x > 0 {
		z := 1024
		fmt.Println(z)
	}
	for i := 0; i < 10; i++ {
		fmt.Print(i, " ")
	}
	// fmt.Println(z,i)  //此处无法使用变量z 和 i
	fmt.Println()
}

// 8.函数类型与变量
type calc func(int, int) int

func sum(x, y int) int {
	return x + y
}
func sub(x, y int) int {
	return x - y
}
func f8() {
	// 方式1
	var c calc
	c = sum
	fmt.Printf("type of c:%T , c(1,2) ： %v \n", c, c(1, 2)) // type of c:main.calculation  (区别点)

	// 方式2
	d := sub
	fmt.Printf("type of d:%T , d(1,2) ： %v \n", d, d(1, 2)) // type of d:func(int, int) int (区别点)

}

// 9.函数作为参数值或者作为返回值
func mul(x, y int) int {
	return x * y
}
func div(x, y int) int {
	return x / y
}

// 函数作为参数值
func calculation(x, y int, op func(int, int) int) int {
	return op(x, y)
}

// 函数作为返回值
func ops(s string) (func(int, int) int, error) {
	switch s {
	case "+":
		return sum, nil
	case "-":
		return sub, nil
	case "*":
		return mul, nil
	case "/":
		return div, nil
	default:
		err := errors.New("无法识别的操作符")
		return nil, err
	}
}

func f9() {
	// 演示1
	fmt.Printf("Type : %T , calculation (10 , 20, mul) = %v \n", calculation(10, 20, mul), calculation(10, 20, mul))

	// 演示2
	value, _ := ops("/")
	fmt.Printf("Type : %T , ops('/') ->  div(100,10) = %v \n\n", value(100, 10), value(100, 10))
}

// 10.匿名函数
func f10() {
	// 方式1
	muls := func(x, y int) int {
		fmt.Println("匿名函数1 之 x , y =", x, y)
		return x * y
	}
	ret := muls(3, 2)
	fmt.Println("匿名函数1 返回结果: ", ret)

	// 方式2
	func(x, y int) {
		fmt.Println("匿名函数2 之 x , y =", x*y)
	}(3, 2)

}

// 11.闭包
func adder1() func(int) int {
	var x int
	return func(y int) int {
		x += y
		return x
	}
}

func adder2(x int) func(int) int {
	return func(y int) int {
		x += y
		return x
	}
}

func makeSuffixFunc(suffix string) func(string) string {
	return func(name string) string {
		if !strings.HasSuffix(name, suffix) {
			return name + suffix
		}
		return name
	}
}

func f11() {
	// 方式1
	var f = adder1()
	fmt.Printf("\n闭包 adder1: %v\n", f(10)) //x=0,y=10  -> x = 10
	fmt.Println("闭包 adder1:", f(20))       //x=10,y=20 -> x = 30
	fmt.Println("闭包 adder1:", f(30))       //x=30,y=30 -> x = 60

	// 方式2
	g := adder2(10)
	fmt.Printf("闭包 adder2: %v\n", g(10)) //x=10,y=10 -> x = 20
	fmt.Println("闭包 adder2:", g(20))     //x=20,y=20 -> x = 40
	fmt.Println("闭包 adder2:", g(30))     //x=40,y=30 -> x = 70

	// 示例3
	testJPG := makeSuffixFunc("jpg")
	fmt.Printf("闭包 makeSuffixFunc : file test = %v , file test.jpg = %v \n\n", testJPG("test"), testJPG("test.jpg"))
}

// 12.defer 语句使用演示
func funcTime() int {
	fmt.Println("函数开始时间: ", time.Now().Local())
	var x = 0
	defer fmt.Println("init x = ", x) // 注意点: 此处已经将x=0值赋值了，只是没有被输出。 // 最终输出
	for i := 0; i <= 100; i++ {
		x += i
	}
	defer fmt.Println("函数返回前时间: ", time.Now().Local()) // 再输出
	defer fmt.Println("ret x = ", x)                   // 后进先出 -> 先输出
	return x
}

func f12() {
	ret := funcTime()
	fmt.Println("defer 示例1： 1+2+3+....+99+100 =", ret)
}

func main() {
	f1()

	f2("WeiyiGeek")

	fmt.Println(f3(1, 1))

	x, y := f4(1, 3)
	fmt.Printf("x = %d ,y = %d \n", x, y)

	fmt.Println(f5("我是一串数字:", 1, 2, 3, 4))

	f6()

	f7(1, 2)

	f8()

	f9()

	f10()

	f11()

	f12()
}
