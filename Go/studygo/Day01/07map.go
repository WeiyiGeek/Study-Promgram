package main

import (
	"fmt"
	"math/rand"
	"sort"
	"strings"
	"time"
)

func demo1() {
	// 1.Map 定义
	var a1 map[string]int8
	fmt.Println("Map 类型 的 a1 变量 :", a1)
	if a1 == nil {
		fmt.Println("默认初始化的Map类型的a1变量值: nil")
	}

	// 2.基本使用利用Make进行分配内存空间存储Map。
	b1 := make(map[string]string, 8)
	b1["姓名"] = "WeiyiGeek"
	b1["性别"] = "男|man"
	b1["爱好"] = "计算机技术"
	b1["出生日期"] = "2021-08-08"
	// 指定输出
	fmt.Printf("b1['姓名'] = %v \n", b1["姓名"])
	// 整体输出
	fmt.Printf("Map b1 Type: %T , Map b1 Value: %v \n", b1, b1)

	// 3.在声明时填充元素。
	c1 := map[string]string{
		"username": "WeiyiGeek",
		"sex":      "Man",
		"hobby":    "Computer",
	}
	// 指定输出
	fmt.Printf("c1['username'] = %v \n", c1["username"])
	// 整体输出
	fmt.Printf("Map c1 Type: %T , Length : %d , Map c1 Value: %v \n", c1, len(c1), c1)

	// 4.判断c1中的键值时候是否存在 sex Key.
	value, ok := c1["sex"]
	if ok {
		fmt.Println("c1 Map 变量中存在 'sex' 键 = ", value)
	} else {
		fmt.Println("c1 Map 变量中不存在 sex 键")
	}

	// 5.遍历Map
	for k, v := range b1 {
		fmt.Println(k, "=", v)
	}

	// 6.删除指定键值对，例如删除c1中的hobby键值。
	delete(c1, "hobby")
	fmt.Printf("Map 现存在的键 : ")
	for k := range c1 {
		fmt.Print(k, " ")
	}
}

// 按照指定顺序遍历map
func demo2() {
	rand.Seed(time.Now().UnixNano()) //初始化随机数种子

	// 申请并初始化一个长度为 200 的 Map
	var scoreMap = make(map[string]int, 200)
	for i := 0; i < 20; i++ {
		key := fmt.Sprintf("stu%02d", i) //生成stu开头的字符串
		value := rand.Intn(100)          //生成0~99的随机整数
		scoreMap[key] = value
	}

	//取出map中的所有key存入切片keys
	var keys = make([]string, 0, 200)
	for key := range scoreMap {
		keys = append(keys, key)
	}

	//对切片进行排序
	sort.Strings(keys)

	//按照排序后的key遍历map
	for _, key := range keys {
		fmt.Println(key, scoreMap[key])
	}
}

// 7.元素为map类型的切片 (在切片中存放Map类型的键值)
func demo3() {
	var mapSlice = make([]map[string]string, 3)
	for index, value := range mapSlice {
		fmt.Printf("index:%d value:%v\n", index, value)
	}
	fmt.Println()
	// 对切片中的map元素进行初始化
	mapSlice[0] = make(map[string]string, 10)
	mapSlice[1] = make(map[string]string, 10)
	mapSlice[2] = make(map[string]string, 10)
	mapSlice[0]["name"] = "WeiyiGeek"
	mapSlice[0]["sex"] = "Man"
	mapSlice[1]["姓名"] = "极客"
	mapSlice[1]["性别"] = "男"
	mapSlice[2]["hobby"] = "Computer"
	mapSlice[2]["爱好"] = "电脑技术"
	for i, v := range mapSlice {
		//fmt.Printf("index:%d value:%v\n", i, v)
		for _, value := range v {
			fmt.Printf("index:%d value:%v\n", i, value)
		}
	}
}

// 8.值为切片类型的map
func demo4() {
	var sliceMap = make(map[string][]string, 3)
	var key = [2]string{"Country", "City"}
	fmt.Println("初始化 sliceMap 其值 : ", sliceMap)

	for _, v := range key {
		// 判断键值是否存在如果不存在则初始化一个容量为2的切片
		value, ok := sliceMap[v]
		if !ok {
			value = make([]string, 0, 2)
		}
		if v == "Country" {
			value = append(value, "中国")
		} else {
			value = append(value, "北京", "上海", "台湾")
		}
		// 将切片值赋值给Map类型的变量
		sliceMap[v] = value
	}

	fmt.Println(sliceMap)
}

func demo5() {
	// Array
	var Arr = [...]int{1, 2, 6, 4, 5}
	// Slice
	var Sli = []int{1, 2, 6, 4, 5}
	// Map
	var Map = map[string]int{
		"a1": 1,
		"b2": 2,
		"c3": 3,
		"d6": 6,
		"e5": 5,
	}

	fmt.Printf("Type : %T, Value : %v \n", Arr, Arr)
	for _, A := range Arr {
		fmt.Printf("%v ", A)
	}
	fmt.Println()
	fmt.Printf("Type : %T, Value : %v \n", Sli, Sli)
	for _, S := range Sli {
		fmt.Printf("%v ", S)
	}
	fmt.Println()
	fmt.Printf("Type : %T, Value : %v \n", Map, Map)
	for _, M := range Map {
		fmt.Printf("%v ", M)
	}
}

// 验证输出结果
func homework1() {
	type Map map[string][]int
	m := make(Map)
	s := []int{1, 2}
	s = append(s, 3)
	fmt.Printf("%+v\n", s) // [ 1,2,3 ]
	m["q1mi"] = s
	s = append(s[:1], s[2:]...)
	fmt.Printf("%+v\n", s)         // [ 1,3,3 ]
	fmt.Printf("%+v\n", m["q1mi"]) // [ 1,2,3 ]
}

// 统计一个字符串中每个单词出现的次数
func homework2() {
	var a = "how do you do"
	var splitA = strings.Split(a, " ")
	var count = make(map[string]int, len(splitA))
	for _, v := range splitA {
		value, ok := count[v]
		if !ok {
			value = 1
		} else {
			value++
		}
		count[v] = value
	}
	fmt.Printf("统计 %v 字符串每个单词出现的结果: %+v \n", a, count)
}

func main() {
	//demo1()
	//demo2()
	//demo3()
	demo4()
	//demo5()
	//homework1()
	//homework2()
	fmt.Println()
}
