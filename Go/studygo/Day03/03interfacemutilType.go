package main

import "fmt"

// 接口类型
type android interface {
	telephone(int64)
	music()
}

// 结构体声明 实现music方法
type mp3 struct{}

// 实现接口中的方法
func (m *mp3) music() { fmt.Println("播放音乐.....") }

// 结构体声明
type mobilephone struct {
	production string
	mp3        // 嵌入mp3结构体并拥有它的方法
}

// 实现接口中的方法
func (mb *mobilephone) telephone(number int64) {
	fmt.Printf("%v 手机, 正在拨打 %v 电话....\n", mb.production, number)
}

func main() {
	// android 接口类型
	var a android
	// 指针类型结构体变量mb
	var mp = &mobilephone{production: "小米"}
	a = mp
	fmt.Printf("Type : %#v\n", a) // android 接口类型变量输出
	a.telephone(10086)
	a.music()
}
