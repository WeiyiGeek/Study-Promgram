package main

import (
	"fmt"
	"math"
)

// 1.假设这是个第三方包
func f1(f func()) {
	fmt.Printf("# This is f1 func , Param is f func() : %T \n", f)
	f() // 调用传入的函数
}

// 2.自己实现的函数
func f2(x, y int) {
	fmt.Printf("# This is f2 func , Param is x,y: %v %v\n", x, y)
	fmt.Printf("x ^ y = %v \n", math.Pow(float64(x), float64(y)))
}

// 要求 f1(f2) 可以执行，此时由于f1 中的传递的函数参数并无参数，所以默认一定会报错。
// 此时我们需要一个中间商利用闭包和匿名函数来实现,返回一个不带参数的函数。

func f3(f func(int, int), x, y int) func() {
	tmp := func() {
		f(x, y) // 此处实际为了执行f2函数
	}
	return tmp // 返回一个不带参数的函数，为返回给f1函数
}

// 3.家庭作业
/*
你有50枚金币，需要分配给以下几个人：Matthew,Sarah,Augustus,Heidi,Emilie,Peter,Giana,Adriano,Aaron,Elizabeth。
分配规则如下：
a. 名字中每包含1个'e'或'E'分1枚金币
b. 名字中每包含1个'i'或'I'分2枚金币
c. 名字中每包含1个'o'或'O'分3枚金币
d: 名字中每包含1个'u'或'U'分4枚金币
写一个程序，计算每个用户分到多少金币，以及最后剩余多少金币？
程序结构如下，请实现 ‘dispatchCoin’ 函数
*/

var (
	coins = 50
	users = []string{
		"Matthew", "Sarah", "Augustus", "Heidi", "Emilie", "Peter", "Giana", "Adriano", "Aaron", "Elizabeth",
	}
	distribution = make(map[string]int, len(users))
)

func dispatchCoin() int {
	// 1.遍历用户
	for _, name := range users {
		// 2.判断用户时候是否在 map 中
		_, ok := distribution[name]
		if ok {
			continue
		}
		// 3.利用匿名函数求出每个人的获得金币数
		temp := func() int {
			count := 0
			for _, crune := range name {

				// 方式1
				// c := string(crune)
				// if c == "e" || c == "E" {
				// 	count += 1
				// } else if c == "i" || c == "I" {
				// 	count += 2
				// } else if c == "o" || c == "O" {
				// 	count += 3
				// } else if c == "u" || c == "U" {
				// 	count += 4
				// }
				// 方式2（推荐）
				switch crune {
				case 'e', 'E':
					count += 1
					coins -= 1
				case 'i', 'I':
					count += 2
					coins -= 2
				case 'o', 'O':
					count += 3
					coins -= 3
				case 'u', 'U':
					count += 4
					coins -= 4
				}
			}
			return count
		}()

		// 4.将人员和金币数进行绑定
		distribution[name] = temp
	}
	// 5.输出所有人员占有的金币数
	fmt.Println(distribution)

	// 6.返回剩余金币数量
	return coins
}

func homework() {
	left := dispatchCoin()
	fmt.Println("剩下：", left)
}

func main() {
	//ret := f3(f2, 2, 10) // 此时函数并为执行只是将匿名函数进行返回。先执行 f3(fun,x,y int)
	//f1(ret)              // 当传入f1中时ret()函数便会进行执行。再执行 f1() ,最后执行 f2(x,y int)
	homework()
}
