package main

import (
	"fmt"
	"reflect"
)

type b struct{}

func (t *b) Demo() int {
	fmt.Print("我是通过Call调用的Demo方法，")
	return 1024
}

func main() {
	// (1) *int类型空指针 : 必须是通道、函数、接口、映射、指针、切片之一
	var a *int
	fmt.Println("var a *int IsNil:", reflect.ValueOf(a).IsNil())
	// (2) nil值 : 除了IsValid、String、Kind之外的方法都会导致panic。
	fmt.Println("nil IsValid:", reflect.ValueOf(nil).IsValid())

	// (3) 实例化一个匿名结构体
	b1 := struct{}{}
	b2 := struct {
		abc string
	}{}

	// (4) 实例化一个结构体
	b3 := new(b)

	// 尝试从结构体中查找"abc"字段
	fmt.Println("b1是否存在的结构体成员 abc ? :", reflect.ValueOf(b1).FieldByName("abc").IsValid()) // 不存在
	fmt.Println("b2是否存在的结构体成员 abc ? :", reflect.ValueOf(b2).FieldByName("abc").IsValid()) // 存在

	// 尝试从结构体中查找"demo"方法
	fmt.Println("b1是否存在的结构体方法 Demo ? :", reflect.ValueOf(b1).MethodByName("Demo").IsValid())            //不存在
	fmt.Println("b3是否存在的结构体方法 Demo ? :", reflect.ValueOf(b3).MethodByName("Demo").IsValid())            //存在
	fmt.Println("b3结构体Demo方法返回值类型: ", reflect.ValueOf(b3).MethodByName("Demo").Call([]reflect.Value{})) //输出执行其方法以及返回值的类型 （特别注意，调用先执行后返回）

	// (4) map 	尝试从map中查找一个不存在的键
	c := map[string]int{}
	c["WeiyiGeek"] = 1024
	fmt.Println("map中是否存在WeiyiGeek的键：", reflect.ValueOf(c).MapIndex(reflect.ValueOf("WeiyiGeek")).IsValid())
	fmt.Println("map中是否存在Geek的键：", reflect.ValueOf(c).MapIndex(reflect.ValueOf("Geek")).IsValid())
}
