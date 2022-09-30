//* 冒泡排序 */
//* 1. 从当前元素起，向后依次比较每一对相邻元素，若逆序则交换 */
//* 2. 对所有元素均重复以上步骤，直至最后一个元素 */
package main
import "fmt"
func bubblesort() {
    var temp int
	arr := [...]int{21, 9, -18, 196, 88, 68, 1}
	length := len(arr)
	fmt.Printf("原始数组: %v \n",arr)
	for i := 0 ; i < length - 1; i++ {
	    // 每次循环将最大值放在最右边, if 条件中 > 则为升序，< 则为降序
		for j := 0; j < length - 1 - i; j++ {
		    // 注意其与选择排序的不同之处，冒泡是直接相邻下标值两两对比、交换
			if (arr[j] > arr[j+1]) {
				temp = arr[j]
				arr[j] = arr[j+1]
				arr[j+1] = temp 
			}
		}
		fmt.Printf("第 %d 次循环: %v\n",i+1,arr)
	}
	fmt.Printf("冒泡排序: %v",arr)
}

func main(){
  bubblesort()
}


// 原始数组: [21 9 -18 196 88 68 1] 
// 第 1 次循环: [9 -18 21 88 68 1 196]
// 第 2 次循环: [-18 9 21 68 1 88 196]
// 第 3 次循环: [-18 9 21 1 68 88 196]
// 第 4 次循环: [-18 9 1 21 68 88 196]
// 第 5 次循环: [-18 1 9 21 68 88 196]
// 第 6 次循环: [-18 1 9 21 68 88 196]
// 冒泡排序: [-18 1 9 21 68 88 196]