package main

import (
	"fmt"
	"strings"
)

// 九九乘法表
func MultiTable() {
	for i := 1; i <= 9; i++ {
		for j := 1; j <= i; j++ {
			fmt.Printf("%d * %d = %d, ", i, j, i*j)
		}
		fmt.Println()
	}
}

// 查看出现一次的数字
func showsinglenumber() {
	numbers := 1234945579785321
	snumbers := fmt.Sprintf("%d", numbers)
	slength := len(snumbers)
	for i := 0; i < slength; i++ {
		// 判断其索引位置
		if strings.Index(snumbers, string(snumbers[i])) == strings.LastIndex(snumbers, string(snumbers[i])) {
			fmt.Println("只出现一次的数字 : ", string(snumbers[i])) // 注意输出时需要强制转换否则为byte类型输出Ascii值
		}
	}
}

// if 语句
func ifDemo() {
	score := 88 // 注意变量作用域的影响
	if score := 65; score >= 90 {
		fmt.Println("A", score)
	} else if score > 75 {
		fmt.Println("B", score)
	} else {
		fmt.Println("C", score) // 输出结果
	}
	fmt.Println("score : ", score)
}

// swicth case 语句案例（简化大量判断）
func switchdemo() {
	s := "a"
	switch {
	case s == "a":
		fmt.Println("a")
		fallthrough // 满足条件则执行下面一个case
	case s == "b":
		fmt.Println("b")
	case s == "c":
		fmt.Println("c")
	default:
		fmt.Println("...")
	}
}

// for range 语句示例
func forrangedemo() {
	s1 := "Hello,Go 输出的是中文"
	for i, v := range s1 {
		fmt.Printf("Index : %d ,Value : %s , Number : %v \n", i, string(v), v)
	}
}

// goto 语言
func gotodemo() {
	for i := 0; i < 10; i++ {
		for j := 0; j < 10; j++ {
			if j == 2 {
				// 设置退出标签
				goto breakTag
			}
			fmt.Printf("%v-%v\n", i, j)
		}
	}
	return
	// 标签
breakTag:
	fmt.Println("正结束for循环")
	fmt.Println("已结束for循环")

}

func whiledemo() {
	//golang 里面没有while关键字，可以用for+break实现
	i:=0
	for {
		do something
		i++
		if i <= 10 {
			break;
		}
	}
}


func main() {
	//MultiTable()
	//showsinglenumber()
	//ifDemo()
	//switchdemo()
	//forrangedemo()
	//gotodemo()
}
