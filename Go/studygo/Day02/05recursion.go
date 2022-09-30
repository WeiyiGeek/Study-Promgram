package main

import "fmt"

// 1.通过 Go 语言的递归函数实例阶乘
func factorial(n uint64) (ret uint64) {
	if n <= 1 {
		return 1
	}
	return n * factorial(n-1)
}
func demo1() {
	fmt.Println("5 的阶乘 : ", factorial(5))
}

// 2.有n个台阶，一次可以走一步或者两步，问一共有多少种走法。
func ladder(step uint64) (ret uint64) {
	// 如果只有一步阶梯则只有一种走法。
	if step == 1 {
		return 1
	}
	// 如果有两步阶梯则有两种走法。
	if step == 2 {
		return 2
	}
	// 如有三步则有3种走法，所以 n 步 = (n - 1) + （n -2）
	return ladder(step-1) + ladder(step-2)
}

func demo2() {
	ret := ladder(6)
	fmt.Println("当有六步阶梯时,有", ret, "种走法!")
}

// 3.利用递归求斐波那契数列
func Fibonacci(count uint64) (ret uint64) {
	if count == 0 {
		return 0
	}
	if count == 1 || count == 2 {
		return 1
	}
	ret = Fibonacci(count-1) + Fibonacci(count-2)
	return
}

func demo3() {
	count := 10
	fmt.Printf("%v 求斐波那契数列:", count)
	for i := 0; i < count; i++ {
		fmt.Printf("%v ", Fibonacci(uint64(i)))
	}
}

func main() {
	demo1()
	fmt.Println()
	demo2()
	fmt.Println()
	demo3()
}
