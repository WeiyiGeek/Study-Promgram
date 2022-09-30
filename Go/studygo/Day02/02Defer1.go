package main

import "fmt"

// 函数返回值无命名
func f1() int {
	x := 5 // 局部变量
	defer func() {
		x++
	}()
	return x // 1.返回值 x = 5, 2.defer 语句执行后修改的是 x = 6，3.RET指令最后返回的值是 5 (由于无返回值命令则就是return已赋予的值5)
}

// 函数返回值命名 y 进行返回
func f2() (x int) {
	defer func() {
		x++
	}()
	return 5 // 1.返回值 x = 5, 2.defer 语句执行后修改的是 x = 6，3.RET指令最后返回的x值是 6 (由于存在返回值命名x则就是return x 值6)
}

// 函数返回值命名 y 进行返回
func f3() (y int) {
	x := 5 // 局部变量
	defer func() {
		x++ // 修改 x 变量的值 x + 1
	}()
	return x // 1.返回值 x = y = 5, 2.defer 语句执行后修改的是 x ，3.RET指令最后返回的y值还是 5
}

// 匿名函数无返回值
func f4() (x int) {
	defer func(x int) {
		x++ // 改变得是函数中局部变量x，非外部x变量。
	}(x)
	return 5 // 1.返回值 x = 5, 2.defer 语句执行后 x 副本 = 6 , 3.RET指令最后返回的值还是 5
}

// 匿名函数中返回值
func f5() (x int) {
	defer func(x int) int {
		x++ // 改变得是函数中局部变量x，非外部x变量。
		return x
	}(x)
	return 5 // 1.返回值 x = 5, 2.defer 语句执行后 x 副本 = 6 , 3.RET指令最后返回的值还是 5
}

// 传入一个指针到匿名函数中(方式1)
func f6() (x int) {
	defer func(x *int) {
		*x++
	}(&x)
	return 5 // 1.返回值 x = 5, 2.由于defer语句，传入x指针地址到匿名函数中 x = 6, 3.RET指令最后返回的值 6
}

// 传入一个指针到匿名函数中(方式2)
func f7() (x int) {
	defer func(x *int) int {
		(*x)++
		return *x
	}(&x)
	return 5 // 1.返回值x = 5, 2.由于defer语句，传入x指针地址到匿名函数中 x = 6, 3.RET指令最后返回值 6
}

func main() {
	fmt.Println("f1() = ", f1())
	fmt.Println("f2() = ", f2())
	fmt.Println("f3() = ", f3())
	fmt.Println("f4() = ", f4())
	fmt.Println("f5() = ", f5())
	fmt.Println("f6() = ", f6())
	fmt.Println("f7() = ", f7())
}
