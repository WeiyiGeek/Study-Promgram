package main

import (
	"encoding/json"
	"fmt"
)

// 结构体转json字符串的三种示例
// 结构体中的字段首字母大小写影响的可见性，表示不能对外使用
type Person1 struct{ name, sex string }

// 结构体对象字段可以对外使用
type Person2 struct{ Name, Sex string }

// 但json字符串中键只要小写时可以采用此种方式
type Person3 struct {
	Name string `json:"name"`
	Sex  string `json:"age"`
}

// # 结构体实例化对象转JSON字符串
func serialize() {
	// 示例1.字段首字母大小写影响的可见性
	person1 := &Person1{"weiyigeek", "男孩"}
	person2 := &Person2{"WeiyiGeek", "男生"}
	person3 := &Person3{"WeiyiGeek", "男人"}

	//序列化
	p1, err := json.Marshal(person1)
	p2, err := json.Marshal(person2)
	p3, err := json.Marshal(person3)
	if err != nil {
		fmt.Printf("Marshal Failed ：%v", err)
		return
	}

	// 由于返回是一个字节切片，所以需要强转为字符串
	fmt.Printf("person1 -> %v\nperson2 -> %v\nperson3 -> %v\n", string(p1), string(p2), string(p3))
}

// # JSON字符串转结构体实例化对象

type Person4 struct {
	Name string    `json:"name"`
	Sex  string    `json:"sex"`
	Addr [3]string `json:"addr"`
}

func unserialize() {
	jsonStr := `{"name": "WeiyiGeek","sex": "man","addr": ["中国","重庆","渝北"]}`
	p4 := Person4{}

	// 在其内部修改p4的值
	err := json.Unmarshal([]byte(jsonStr), &p4)
	if err != nil {
		fmt.Printf("Unmarhal Failed: %v", err)
		return
	}
	fmt.Printf("jsonStr -> Person4 : %#v\nPerson4.name : %v\n", p4, p4.Name)
}

func main() {
	serialize()
	unserialize()
}
