package main

import "fmt"

func halfsearch(number int, numbers []int) int {
	// 初始化 数组、长度、中值变量
	var i,length,mid int
	// 在arr[i...arr_len]之中查找target
	i = 0
	arr_len = len(numbers)

    // go 语言没有While关键字所有使用for作为替代
	for {
		// 取数组长度中值
		mid = i + (arr_len - i) / 2
		// 刚好等于则直接返回mid，如果大于number则将其中值减一后赋予arr_len，否则将中值赋予 i + 1。
		if numbers[mid] == number {
		  return mid
		} else if  numbers[mid] > number  {
			arr_len = mid - 1
		} else {
			i = mid + 1
		}
		
		if i > arr_len {
		    break
		}
	}
	
	return -1
}


func main() {
	searchNumber := 88
	arr := [...]int{-18 1 9 21 68 88 196}
	index := halfsearch(searchNumber, arr[:])
	fmt.Printf("[折半查询]\n元素 %d 在 arrNumber [ %v ] 中的下标为 %v",searchNumber,arr,index)
}