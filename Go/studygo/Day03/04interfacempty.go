package main

import "fmt"

// (1) 空接口作为函数参数
func showType(a interface{}) { fmt.Printf("参数类型:%T, 参数值:%v\n", a, a) }
func main() {
	// (2) 空接口作为map的值
	var m1 map[string]interface{}     // 类似于Java中的 Map<String,Object> m1
	m1 = make(map[string]interface{}) // 为Map申请一块内存空间
	// 可以存储任意类型的值
	m1["name"] = "WeiyiGeek"
	m1["age"] = 20
	m1["sex"] = true
	m1["hobby"] = [...]string{"Computer", "NetSecurity", "Go语言编程学习"}

	fmt.Printf("#空接口作为map的值 -> %#v\n", m1)
	fmt.Println(m1)

	fmt.Printf("\n#空接口作为函数参数\n")
	showType(nil)
	showType([]byte{'a'})
	showType(true)
	showType(1024)
	showType("我是一串字符串")
}
