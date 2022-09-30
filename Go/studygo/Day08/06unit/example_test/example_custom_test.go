// Package exampletest 包文档生成示例
//----- example_test.go -----
package example_test

import (
	"fmt"

	custom "weiyigeek.top/packeage/myself"
)

// 此注释将会被展示在页面上
// 此函数将被展示在OverView区域
func Example() {
	fmt.Println("Hello OverView")

	// Output:
	// Hello OverView
}

// 此函数将被展示在OverView区域, 并展示noOutput标签
func Example_noOutput() {
	fmt.Println("Hello OverView")
	// (Output: ) 非必须, 存在时将会展示输出结果, 此处不存在则不会在go test -v 结果集中输出
}

// 此函数将被展示在Function区域
// ExampleSplit 字符串分割函数使用说明
func Example_funSplit() {
	res1 := custom.Split("www.weiyigeek.top", ".")
	res2 := custom.Split("blog.weiyigeek.top", ".")
	fmt.Println(res1)
	fmt.Println(res2)
	// Output:
	// [www weiyigeek top]
	// [blog weiyigeek top]
}

// 此函数将被展示在Function区域
// ExampleFibonacci 斐波那契数列生成说明
func Example_funFibonacci() {
	fib := custom.Fibonacci(3)
	fmt.Println(fib)
	// Output:
	// 2
}
