package main

import "fmt"

// 示例1.采用if进行判断断言
func assert(x interface{}) {
	v, ok := x.(string) // v 接受是string类型
	if ok {
		fmt.Printf("assert successful : %v, typeof %T\n", v, v)
	} else {
		fmt.Printf("assert failed 非 string 类型! : %v, typeof %T\n", x, x)
	}
}
func demo1() {
	var x interface{}
	x = "WeiyiGeek"
	assert(x) // assert successful : WeiyiGeek, typeof string
	x = 1024
	assert(x) // assert failed 非 string 类型! : 1024, typeof int
}

// 示例2.如果要断言多次就需要写多个if判断，这个时候我们可以使用switch语句来实现：
func justifyType(x interface{}) {
	switch v := x.(type) {
	case string:
		fmt.Printf("x is a string，value is %v\n", v)
	case int:
		fmt.Printf("x is a int is %v\n", v)
	case bool:
		fmt.Printf("x is a bool is %v\n", v)
	default:
		fmt.Println("unsupport type！")
	}
}
func demo2() {
	var x interface{}
	x = "i'm string"
	justifyType(x)
	x = 225
	justifyType(x)
	x = true
	justifyType(x)
}

func main() {
	demo1()
	fmt.Println()
	demo2()
}
