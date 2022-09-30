package main

import "fmt"

type Person struct {
	name   string
	age    int8
	dreams []string
}

// 不推荐的方式
func (p *Person) SetDreams(dreams []string) {
	p.dreams = dreams
}

// 正确的做法是在方法中使用传入的slice的拷贝进行结构体赋值。
func (p *Person) NewSetDreams(dreams []string) {
	p.dreams = make([]string, len(dreams))
	copy(p.dreams, dreams)
}

func main() {
	// (1) 不安全的方式
	p1 := Person{name: "小王子", age: 18}
	data := []string{"吃饭", "睡觉", "打豆豆"}
	p1.SetDreams(data)
	// 你真的想要修改 p1.dreams 吗？
	data[1] = "不睡觉"        // 会覆盖更改切片中的值从而影响p1中的dreams字段中的值
	fmt.Println(p1.dreams) // [吃饭 不睡觉 打豆豆]

	// (2) 推荐方式
	p2 := Person{name: "WeiyiGeek", age: 18}
	data2 := []string{"计算机", "网络", "编程"}
	p2.NewSetDreams(data2)
	data2[1] = "NewMethod" // 由于NewSetDreams返回中是将拷贝的副本给p2的dreams字段，所以此处更改不会影响其值，
	fmt.Println(p2.dreams) // [计算机 网络 编程]
}
