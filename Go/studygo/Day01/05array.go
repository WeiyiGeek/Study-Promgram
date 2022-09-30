package main

import "fmt"

func homework1() {
	// 求数组`[1, 3, 5, 7, 8]`所有元素的和
	arr := [...]int{1, 3, 5, 7, 8}
	sum := 0
	for _, v := range arr {
		sum += v
	}
	fmt.Printf("%v 元素集合之和 : %d \n", arr, sum)
}

func homework2() {
	// 比如从数组`[1, 3, 5, 7, 8]`中找出和为8的两个元素的下标分别为`(0,3)`和`(1,2)`。**
	arr := [...]int{1, 3, 5, 7, 8}
	for i, v := range arr {
		for j := i + 1; j < len(arr); j++ {
			if v+arr[j] == 8 {
				fmt.Printf("arr[%d] + arr[%d] = %d \n", i, j, 8)
			}
		}
	}
}

func main() {
	// 定义一个长度为3元素类型为int的数组a
	var a [2]int      // 默认为0
	var a1 [2]string  // 默认为空
	var a2 [2]bool    // 默认为false
	var a3 [2]float64 // 默认为0

	fmt.Printf("a 数组类型 %T , 元素: %v\n", a, a)
	fmt.Printf("a1 数组类型 %T , 元素: %v\n", a1, a1)
	fmt.Printf("a2 数组类型 %T , 元素: %v\n", a2, a2)
	fmt.Printf("a3 数组类型 %T , 元素: %v\n", a3, a3)

	// 数组初始化
	// 方式1.使用初始化列表来设置数组元素的值
	var b = [3]int{1, 2} // 三个元素，未指定下标元素的其值为 0
	var c = [3]string{"Let's", "Go", "语言"}
	// 方式2.根据初始值的个数自行推断数组的长度
	var d = [...]float32{1.0, 2.0}
	e := [...]bool{true, false, false}
	// 方式3.使用指定索引值的方式来初始化数组
	var f = [...]int{1: 1, 3: 8} // 只有 下标为1的其值为1，下标为3的其值为8，初开之外都为0
	g := [...]string{"Weiyi", "Geek"}

	fmt.Printf("b 数组类型 %T , 元素: %v\n", b, b)
	fmt.Printf("c 数组类型 %T , 元素: %v\n", c, c)
	fmt.Printf("d 数组类型 %T , 元素: %v\n", d, d)
	fmt.Printf("e 数组类型 %T , 元素: %v\n", e, e)
	fmt.Printf("f 数组类型 %T , 元素: %v\n", f, f)
	fmt.Printf("f 数组类型 %T , 元素: %v\n", g, g)

	// 数组指定元素获取
	fmt.Println("c[1] 元素获取 : ", c[1])
	// 数组遍历
	// 方式1
	alen := len(c)
	for i := 0; i < alen; i++ {
		fmt.Printf("c[%d]: %s ", i, c[i])
	}
	fmt.Println()
	// 方式2
	for i, v := range c {
		fmt.Printf("c[%d]: %s ", i, v) // 注意如果是切片类型需要强转为string
	}
	fmt.Println()

	// 多维数组
	// 方式1
	s1 := [3][2]string{
		{"北京", "上海"},
		{"广州", "深圳"},
		{"成都", "重庆"},
	}

	// 方式2
	s2 := [...][2]string{
		{"Go", "C"},
		{"PHP", "Python"},
		{"Shell", "Groovy"},
	}
	fmt.Println("s1[2][1] 元素获取 : ", s1[2][1]) //支持索引取值:重庆
	fmt.Println(len(s1), s1)                  //[[北京 上海] [广州 深圳] [成都 重庆]]
	fmt.Println(len(s2), s2)

	// 多维数组遍历
	// 方式1
	s1len := len(s1)
	for i := 0; i < s1len; i++ {
		s1length := len(s1[i])
		for j := 0; j < s1length; j++ {
			fmt.Printf("s1[%d][%d] = %v ", i, j, s1[i][j])
		}
	}
	fmt.Println()

	// 方式2 （推荐方式）
	for i, v1 := range s2 {
		for j, v2 := range v1 {
			fmt.Printf("s2[%d][%d] = %v ", i, j, v2)
		}
	}
	fmt.Println()

	// 多维数组元素更改
	s1[1][0] = "Test"
	s1[1][1] = "Change"
	fmt.Println(s1)

	homework1()
	homework2()
}
