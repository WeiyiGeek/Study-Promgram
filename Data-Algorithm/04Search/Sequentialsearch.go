package main
import "fmt"

func sequentialsearch(n int,  numbers []int) int {
	fmt.Printf("原始数组: %v \n", numbers)
	for i, v := range numbers {
		if ( n == v ) {
			return i
		}
	}
	return -1
}

func main(){
	searchNumber := 196
	arr := [...]int{21, 9, -18, 196 , 88, 68, 1}
	index := sequentialsearch(searchNumber, arr[:])
  fmt.Printf("元素 %d 在 arrNumber [ %v ] 中的下标为 %v",searchNumber,arr,index)
}