package main

import (
	"fmt"
)

// 转入int类型的参数
func normal(x int) {
	x = 65535
	fmt.Printf("Func Param &x ptr : %p \n", &x)
}

// 传入的参数为指针类型
func pointer(x *int) {
	*x = 65535
	fmt.Printf("Func Param x ptr : %p \n", x)
}

func demo1() {
	// 1.2获得变量a的内存地址
	a := 1024
	b := &a
	fmt.Printf("a : %d , a ptr: %p, b ptr : %v , *b = %d \n", a, &a, b, *b)
	fmt.Printf("b type: %T, &b ptr : %p \n", b, &b)
	fmt.Println()
	// 2.针对变量a的内存地址进行重赋值（此时会覆盖变量a的原值）
	*b = 2048
	fmt.Printf("Change -> a : %d , a ptr: %p, b ptr : %v , *b = %d \n", a, &a, b, *b)
	fmt.Printf("b type: %T, &b ptr : %p \n\n", b, &b)

	// 3.指针传值
	c := 4096
	normal(c)
	fmt.Println("After Normal Function c : ", c)
	pointer(&c)
	fmt.Printf("After Pointer Function c : %v, c ptr: %p \n\n", c, &c)

	// 4.new 内存地址申请
	var a4 *int
	//*a4 = 100 // 此行会报 _panic 错误，因为未分配内存空间
	fmt.Println("a4 ptr : ", a4) // 空指针 （<nil>）还没有内存地址

	d := new(int)                         // 申请一块内存空间 （内存地址）
	fmt.Printf("%T ，%p, %v \n", d, d, *d) // 其指针类型默认值为 0 与其类型相关联。
	*d = 8192                             // 对该内存地址赋值
	fmt.Printf("%T ，%p, %v \n\n", d, d, *d)

	// 5.make 内存地址申请
	var b5 map[string]string
	//b5["Name"] = "WeiyGeek" //此行会报 _panic 错误，因为未分配内存空间
	fmt.Printf("%T , %p , %v\n", b5, &b5, *&b5)

	b5 = make(map[string]string, 10) // 申请一块内存空间 （内存地址）
	b5["Name"] = "WeiyGeek"          // 此时便可对该Map类型进行赋值了
	b5["Address"] = "ChongQIng China"
	fmt.Printf("%T , %p , %v\n\n", b5, &b5, b5)
}

func main() {
	demo1()
	fmt.Println()
}
