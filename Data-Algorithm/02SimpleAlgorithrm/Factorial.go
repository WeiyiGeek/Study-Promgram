package main

import "fmt"

// 使用迭代方式计算阶乘
func factotial_iteration(n int) int {
	result,i := 1,1
	for {
		if (i > n){
			break
		}
		result *= i
		i++
	}
	return result
}

// 使用递归方式计算阶乘
func factotial_recursion(n int) int {
	if ( n == 0) {
		return 1
	} else {
		return n * factotial_recursion(n-1)
	}
}

func main() {
  number := 6
  result := factotial_iteration(number)
  fmt.Printf("使用迭代计算 %d! 阶乘的结果为 %d \n", number, result)

	result = factotial_recursion(number)
  fmt.Printf("使用递归计算 %d! 阶乘的结果为 %d", number, result)
}
