package main

import (
	"fmt"
	"reflect"
)

type myInt int

func reflectType(x interface{}) {
	v := reflect.TypeOf(x)
	fmt.Printf("Reflect Type = %v, Name Type : %v,Kind : %s (%d)\n", v, v.Name(), v.Kind(), v.Kind())
}

func demo1() {
	var a int64 = 100    // 整形
	var b float32 = 3.14 // 浮点型
	var c rune           // 类型别名
	var d myInt = 1024   // 自定义类型
	type person struct { // 结构体
		name string
		age  int
	}
	type book struct{ title string }
	var e = person{
		name: "WeiyiGeek",
		age:  18,
	}
	var f = book{title: "《跟WeiyiGeek学Go语言》"}

	// 调用查看反射类型
	reflectType(a)
	reflectType(b)
	reflectType(c)
	reflectType(d)
	reflectType(e)
	reflectType(f)
}

// 通过反射获取变量的值
func reflectTypeValue(x interface{}) {
	t := reflect.TypeOf(x)
	v := reflect.ValueOf(x)
	k := v.Kind()
	switch k {
	case reflect.Int64:
		// v.Int()从反射中获取整型的原始值，然后通过int64()强制类型转换
		fmt.Printf("type is int64, value is %d\n", int64(v.Int()))
	case reflect.Float32:
		// v.Float()从反射中获取浮点型的原始值，然后通过float32()强制类型转换
		fmt.Printf("type is float32, value is %f\n", float32(v.Float()))
	case reflect.Float64:
		// v.Float()从反射中获取浮点型的原始值，然后通过float64()强制类型转换
		fmt.Printf("type is float64, value is %f\n", float64(v.Float()))
	case reflect.Bool:
		// v.Bool()从反射中获取布尔型的原始值，然后通过Bool()强制类型转换
		fmt.Printf("type is bool, value is %v\n", bool(v.Bool()))
	}
	fmt.Printf("Reflect Type = %v, Reflect Value = %v, Name : %v, Kind : %s (%d)\n\n", t, v, t.Name(), v.Kind(), v.Kind())
}

// 通过反射设置变量的值
func reflectSetValue1(x interface{}) {
	t := reflect.TypeOf(x)
	v := reflect.ValueOf(x)
	// 使用默认方式修改的是副本，reflect包会引发panic
	if v.Kind() == reflect.Int64 {
		v.SetInt(200)
	}
	fmt.Printf("Type %v, Value %v\n", t, v)
}
func reflectSetValue2(x interface{}) {
	t := reflect.TypeOf(x)
	v := reflect.ValueOf(x)
	// 反射中使用 Elem()方法获取指针对应的值
	if v.Elem().Kind() == reflect.Int64 {
		v.Elem().SetInt(200)
	}
	fmt.Printf("Type %v, Value %v\n", t, v)
}

func demo2() {
	// 将常规类型初始化并设置值，然后通过反射获取值
	var a int = 1024
	var f float32 = 3.14
	var b bool = true
	reflectTypeValue(a)
	reflectTypeValue(f)
	reflectTypeValue(b)

	// 将int类型的原始值转换为reflect.Value类型
	c := reflect.ValueOf(10)
	fmt.Printf("Type c : %T, Value c : %v\n", c, c)
	reflectTypeValue(c)

	// 通过反射设置变量的值（两种方法）
	var d int64 = 65535
	// reflectSetValue1(d) //panic: reflect: reflect.Value.SetInt using unaddressable value
	reflectSetValue2(&d) // 修改是的指针指向的值
	fmt.Println("通过反射设置变量(d)的值: ", d)
}

func main() {
	// demo2()
	demo2()
}
