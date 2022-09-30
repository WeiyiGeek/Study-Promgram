package main

import (
	"errors"
	"fmt"
	"math"
)

// 错误处理
// 1.Error
func demo1() {
	// 1.声明并初始化为error类型
	var errNew error = errors.New("# 错误信息来自 errors.New 方法。")
	fmt.Println(errNew)

	// 2.调用标准库中Errorf方法
	errorfFun := fmt.Errorf("- %s", "错误信息来自 fmt.Errorf 方法。")
	fmt.Println(errorfFun)

	// 3.实际案例
	result, err := func(a, b float64) (ret float64, err error) {
		err = nil
		if b == 0 {
			err = errors.New("此处幂指数不能为0值,其结果都为1")
			ret = 1
		} else {
			ret = math.Pow(a, b)
		}
		return
	}(5, 0)

	if err != nil {
		fmt.Println("# 输出错误信息:", err)
		fmt.Printf("5 ^ 0 = %v", result)
	} else {
		fmt.Printf("5 ^ 2 = %v", result)
	}
}

// 2.panic 函数使用
func A() {
	fmt.Println("我是A函数 - 正常执行")
}

// panic
func B() {
	fmt.Println("我是B函数 - 正在执行")
	panic("func B():panic")
	fmt.Println("我是B函数 - 结束执行")
}

func C() {
	fmt.Println("我是c函数 - 正在执行")
}

func demo2() {
	A()
	B() //发生异常,中断程序
	C()
}

// 3. recover 函数使用
func recoverB() (err error) {
	fmt.Println("我是recoverB 函数 - 正在执行")
	// 必须是 defer 语句中以及在panic函数前
	defer func() {
		x := recover()
		if x != nil {
			err = fmt.Errorf("# 1.进行 recover（恢复） Panic 导致的程序异常,从此之后将会继续执行后续代码：\n%v", x)
		}
	}() // 此处利用匿名函数
	//panic("# 2.recoverB 函数中捕获 Panic")
	panic(errors.New("# 2.recoverB 函数中出现 Panic"))
	fmt.Println("我是recoverB 函数 - 结束执行") // 无法访问的代码
	return
}

func demo3() {
	A()
	err := recoverB()
	if err != nil {
		fmt.Println("# recoverB 输出的信息：", err)
	}
	C()
}

// 4.recover捕获异常后的异常，不能再次被recover捕获。
func demo4() {
	// 采用匿名函数进行立即执行该函数
	defer func() { //   声明defer，
		fmt.Println("----调用 defer func1 start----")
		err := recover() // 此处输出为 nil ，因为panic只能被 recover 捕获一次
		fmt.Printf("# 第二次 捕获 : %#v \n", err)
		if err != nil {
			fmt.Println(err)
		}
		fmt.Println("----调用 defer func1 end----")
	}()

	defer func() { //   声明defer，压栈操作后进先出。
		fmt.Println("----调用 defer func2 start----")
		if err := recover(); err != nil {
			fmt.Println("# 第一次 捕获:", err) // 这里的err其实就是panic传入的内容
		}
		fmt.Println("----调用 defer func2 end----")
	}()

	panic("panic 异常 抛出 测试！")
}

func main() {
	// demo1()
	// demo2()
	// demo3()
	demo4()
}
