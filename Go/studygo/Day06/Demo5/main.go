package main

import (
	"fmt"
	"strconv"
)

// 采用strconv包进行字符串的强制转换示例演示

func strInteger() {
	// 字符串转整型
	str := "1024"
	ret1, err := strconv.ParseInt(str, 10, 64)
	if err != nil {
		fmt.Println("Parseint failed,err", err)
		return
	}
	fmt.Printf("Integer Ret1 = %#v %T \n", ret1, ret1) // 返回int64类型

	ret2, _ := strconv.Atoi(str)
	fmt.Printf("Integer Ret2 = %#v %T \n", ret2, ret2) // 返回int类型

	// 整形转字符串
	i := int32(1024)
	ret3 := fmt.Sprintf("%d", i)
	fmt.Printf("String Ret3 = %#v %T\n", ret3, ret3)

	ret4 := strconv.Itoa(int(i)) // int32 -> int 类型
	fmt.Printf("String Ret4 = %#v %T\n", ret4, ret4)
}

func strFloat() {
	floatStr := "3.1415926" // 圆周率 Pi
	floatValue, _ := strconv.ParseFloat(floatStr, 32)
	fmt.Printf("float floatValue = %#v %T\n", floatValue, floatValue)
}

func strBoolean() {
	boolStr := "True"
	boolValue, _ := strconv.ParseBool(boolStr)
	fmt.Printf("boolean boolValue = %#v %T\n", boolValue, boolValue)
}

func ext() {
	a := strconv.IsPrint('a')
	b := strconv.IsGraphic('佛')
	c := strconv.CanBackquote("THIS IS DEMO")
	fmt.Println(a, b, c) // true true true

}

func main() {
	// 字符串与整形互换
	strInteger()
	// 字符串与浮点型互换
	strFloat()
	// 字符串与布尔型互换
	strBoolean()
	// 扩展演示
	ext()
}
