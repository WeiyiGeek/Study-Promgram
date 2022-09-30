package main

import (
	"fmt"
	"sort"

	bitmove "weiyigeek.top/custom/pkg"
)

func textsort() {
	a := [...]int{3, 7, 8, 9, 1}
	fmt.Printf("a : %T , %v , ptr : %p \n", a, a, &a)            // 数组
	sort.Ints(a[:])                                              // 排序
	fmt.Printf("a[:] : %T , %v , ptr : %p \n", a[:], a[:], a[:]) // 切片
	fmt.Println("After sorted: ", a)
}

func main() {
	bitmove.Leftmove(4, 2)
	fmt.Println()
	bitmove.RightMove(10, 2)
	textsort()
}
