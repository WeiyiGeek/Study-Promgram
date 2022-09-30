package main

import (
	"fmt"
	"reflect"
)

type student struct {
	Name  string `json:"name" person:"weiyigeek"` // 可以有多个Tag
	Score int    `json:"score" person:"geek"`
}

// 给student添加两个方法 Study和Sleep(注意首字母大写)
func (s student) Study() string {
	msg := "[Study] 好好学习，天天向上。"
	fmt.Println(msg)
	return msg
}

func (s student) Sleep() string {
	msg := "[Sleep] 好好睡觉，快快长大。"
	fmt.Println(msg)
	return msg
}

// 结构体反射示例演示方法
func Reflectstruct(x interface{}) {
	// (2) 获取 stu1 对象反射类型信息,输出对象名称以及对象种类
	t := reflect.TypeOf(x)
	v := reflect.ValueOf(x)
	fmt.Println("reflect.TypeOf ->", t.Name(), t.Kind()) // student struct
	fmt.Println("reflect.ValueOf ->", v, v.Kind())       // {WeiyiGeek 90} struct
	fmt.Println()

	// (3) 通过for循环遍历结构体的所有字段信息(方式1)
	for i := 0; i < t.NumField(); i++ {
		field := t.Field(i)
		//fmt.Print(v.Field(i).Call([]reflect.Value{}))
		fmt.Printf("name:%s index:%d type:%v json tag: %v  person tag:%v , Field Anonymous: %v\n", field.Name, field.Index, field.Type, field.Tag.Get("json"), field.Tag.Get("person"), field.Anonymous)
	}

	// (4) 通过字段名获取指定结构体字段信息(方式2)
	if scoreField, ok := t.FieldByName("Score"); ok {
		fmt.Printf("\nname:%s index:%d type:%v json tag:%v , Field Anonymous: %v\n", scoreField.Name, scoreField.Index, scoreField.Type, scoreField.Tag.Get("json"), scoreField.Anonymous)
	}

	// (5) 通过for循环遍历结构体的所有方法信息
	fmt.Println("reflect.TypeOf NumMethod->", t.NumMethod())
	fmt.Println("reflect.ValueOf NumMethod->", v.NumMethod())
	for i := 0; i < v.NumMethod(); i++ {
		methodType := v.Method(i).Type()
		fmt.Printf("method name:% s，method: %s\n", t.Method(i).Name, methodType)
		// 通过反射调用方法传递的参数必须是 []reflect.Value 类型
		var args = []reflect.Value{}
		// 相当于依次调用结构体中的方法
		v.Method(i).Call(args)
	}

	// (6) 通过方法名获取指定的结构体方法并执行
	methodSleep := v.MethodByName("Sleep")
	methodSleepType := methodSleep.Type()
	fmt.Printf("Reflect Method ptr:%v，method Type: %v\n", methodSleep, methodSleepType)
	// 通过反射调用方法传递的参数必须是 []reflect.Value 类型
	var args = []reflect.Value{}
	// 相当调用 结构体的 Sleep() 方法
	methodSleep.Call(args)
}

func main() {
	// (1) 实例化 student 结构体
	stu := student{
		Name:  "WeiyiGeek",
		Score: 90,
	}
	Reflectstruct(stu)
}
