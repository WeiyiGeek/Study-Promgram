package main

import (
	"fmt"
	"sort"
)

func text() {
	var a = make([]string, 5, 10)
	for i := 0; i < 10; i++ {
		a = append(a, fmt.Sprintf("%v", i))
	}
	fmt.Println(len(a), cap(a), a)
}

func textsort() {
	a := [...]int{3, 7, 8, 9, 1}
	fmt.Printf("a : %T , %v , ptr : %p \n", a, a, &a)            // 数组
	sort.Ints(a[:])                                              // 排序
	fmt.Printf("a[:] : %T , %v , ptr : %p \n", a[:], a[:], a[:]) // 切片
	fmt.Println("After sorted: ", a)
}

func homework1() {
	s := "a一行白鹭与鹭白行一a"
	srune := []rune(s)
	fmt.Printf("%T, Len : %d , Cap : %d \n", srune, len(srune)/2, cap(srune))
	for i := range srune {
		if srune[i] != srune[len(srune)-1-i] {
			fmt.Printf("`%v`不是回文字符串", s)
			return
		} else if i >= len(srune)/2 {
			fmt.Printf("`%v`是回文字符串", s)
			return
		}
	}
}

func main() {
	// 切片声明与定义
	var a []string              //声明一个字符串切片
	var b = []int{}             //声明一个整型切片并初始化
	var c = []bool{false, true} //声明一个布尔切片并初始化

	// - 切片 a 变量值为空/零值。
	if a == nil {
		fmt.Println("a 切片元素:", a)
	}
	fmt.Println("b 切片元素:", b)
	fmt.Println("c 切片元素:", c)

	// 切片长度与容量
	var lth = []int{}
	var lth64 = []float64{1, 2, 3}
	fmt.Println("切片长度", len(lth), ",切片容量", cap(lth))
	fmt.Println("切片长度", len(lth64), ",切片容量", cap(lth64))

	// 切片表达式
	d := [5]int{1, 2, 3, 4, 5}
	s := [5]string{"Let", "'s", "Go", "语言", "学习"}
	s1 := d[1:3]   // s := d[low(包含):high(不包含)] == d[1] d[2]
	s2 := d[2:]    // 等同于 a[2:5]  == d[2] d[3] d[4]
	s3 := d[:3]    // 等同于 a[0:3]  == d[0] d[1] d[2]
	s4 := d[:]     // 等同于 a[0:5]  == d[0] d[1] d[2] d[3] d[4]
	s5 := s[1:4:5] // 等同于 s[1:4] == s[1] s[2] s[3]

	fmt.Printf("s1:%v len(s1):%v cap(s1):%v\n", s1, len(s1), cap(s1)) // 注意此种情况 { 2 .. 5 容量为 4 }
	fmt.Printf("s2:%v len(s2):%v cap(s2):%v\n", s2, len(s2), cap(s2)) // { 3 .. 5 容量为 3 }
	fmt.Printf("s3:%v len(s3):%v cap(s3):%v\n", s3, len(s3), cap(s3)) // 注意此种情况 { 1 .. 5 容量为 5 }
	fmt.Printf("s4:%v len(s4):%v cap(s4):%v\n", s4, len(s4), cap(s4)) // { 1 .. 5 容量为 5}
	fmt.Printf("s5:%v len(s5):%v cap(s5):%v\n", s5, len(s5), cap(s5)) // s5:['s Go 语言] len(s5):3 cap(s5):4

	// 判断切片是否为空
	if len(d) != 0 {
		fmt.Println("变量 d 切片不为空: ", d)
	}

	// 切片遍历
	for i, v := range s {
		fmt.Printf("i: %d, v: %v , 切片指针地址: %p \n", i, v, &v)
	}
	fmt.Println()

	// make() 构造切片
	e := make([]int, 2, 10)
	fmt.Printf("e:%v len(e):%d cap(e):%d \n", e, len(e), cap(e)) // 长度 2，容量为 10

	// append() 添加元素 {7,8,9}
	f := append(e, 7, 8, 9)                                      // f:[0 0 7 8 9] len(f):5 cap(f):10
	f = append(f, e...)                                          // 追加切片
	fmt.Printf("f:%v len(f):%d cap(f):%d \n", f, len(f), cap(f)) // 长度 7，容量为 10

	// copy() 复制切片
	slice1 := []int{1, 2, 3, 4, 5}
	slice2 := make([]int, 7, 7)
	copy(slice2, slice1)
	slice2[6] = 2048
	fmt.Println("slice1 : ", slice1, "\t slice2 :", slice2)

	// 切片赋值拷贝
	slice3 := make([]int, 3)
	slice4 := slice3
	slice4[0] = 1024
	slice4[2] = 4096
	fmt.Printf("slice3 : %v, ptr : %p \n", slice3, slice3)
	fmt.Printf("slice4 : %v, ptr : %p \n", slice4, slice4)

	textsort()
	homework1()
}
