package main

import (
	"encoding/json"
	"fmt"
)

func demo1() {
	type person struct {
		Id   int    `json:"id"`
		Name string `json:"name"`
	}
	var p person
	strJson := `{"id": 1024,"name": "WeiyiGeek"}`

	// 1.反序列化将JSON字符串绑定到对象对应属性之中.(他为何可以根据JSON字符串对应的key解析到对象属性之中)
	json.Unmarshal([]byte(strJson), &p)
	// 2.输出对象属性值进行验证
	fmt.Println("Id = ", p.Id, ",Name = ", p.Name)
}

func main() {
	demo1()
	fmt.Println("----------------------------###------------------------")
}
