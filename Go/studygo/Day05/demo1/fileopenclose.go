package main

import (
	"bufio"
	"fmt"
	"io"
	"io/ioutil"
	"os"
	"unsafe"
)

func demo1() {
	//1.以默认的方式打开demo.txt文件
	file, err := os.Open("./demo.txt")
	if err != nil {
		fmt.Println("open file failed!, err:", err)
		return
	}
	fmt.Printf("Type : %T, Pointer address: %p, Size of %d\n", file, file, unsafe.Sizeof(file))

	//2.关闭打开的文件(非常重要)
	//方式1
	// file.Close()
	//方式2
	defer file.Close()
}

func demo2() {
	// 1.文件打开与在函数退出时关闭打开的文件句柄。
	file, err := os.Open("./demo.txt")
	if err != nil {
		fmt.Println("open file failed!, err:", err)
		return
	}
	defer file.Close()

	// 2.使用Read方法进行读取数据。
	tmp := make([]byte, 128)     // 临时存放读取的数据空间
	count, err := file.Read(tmp) //每次读128Byte存入tmp中并返回字节数
	if err == io.EOF {
		fmt.Println("END-文件已读完")
		return
	}

	if err != nil {
		fmt.Println("read file failed, err:", err)
		return
	}
	// 3.输出读取的文件内容
	fmt.Printf("读取类型 %T，共读取了 %d 字节数据，读取的内容: %v \n", tmp, count, string(tmp[:count])) // 如不转换则返回字节编码
}

func demo3() {
	// 1.文件打开与在函数退出时关闭打开的文件句柄。
	file, err := os.Open("./demo.txt")
	if err != nil {
		fmt.Println("open file failed!, err:", err)
		return
	}
	defer file.Close()

	// 2.使用Read方法进行读取数据。
	var content []byte
	tmp := make([]byte, 128) // 临时存放读取的数据空间
	// 循环读取文件
	for {
		count, err := file.Read(tmp) // 每次读128Byte存入tmp中并返回字节数
		if err == io.EOF {
			fmt.Println("#END-文件已读完---")
			break
		}
		if err != nil {
			fmt.Println("read file failed, err:", err)
			return
		}
		content = append(content, tmp[:count]...)
	}

	// 3.输出读取的文件内容
	fmt.Printf("读取的内容: %v \n", string(content)) // 如不转换则返回字节编码
}

func demo4() {
	// 1.文件打开与在函数退出时关闭打开的文件句柄。
	file, err := os.Open("./demo.txt")
	if err != nil {
		fmt.Println("open file failed!, err:", err)
		return
	}
	defer file.Close()

	// 2.使用bufio按行读取示例
	reader := bufio.NewReader(file)
	count := 0
	// 循环读取文件
	for {
		count++
		line, err := reader.ReadString('\n') // 按行执行
		if err == io.EOF {
			if len(line) != 0 {
				fmt.Printf("最后%d行 - %s", count, line)
			}
			fmt.Println("# 文件读取完成!")
			break
		}
		if err != nil {
			fmt.Println("read file failed, err:", err)
			return
		}
		fmt.Printf("第%d行 - %s", count, line)
	}
}

func demo5() {
	content, err := ioutil.ReadFile("./demo.txt")
	if err != nil {
		fmt.Println("read file failed, err:", err)
		return
	}
	fmt.Println("整文读取:")
	fmt.Println(string(content))
}

func main() {
	// demo1()
	// demo2()
	// demo3()
	// demo4()
	demo5()
}
