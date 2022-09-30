package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)

func demo0() {
	// 1.标准输入
	fmt.Fprint(os.Stdin, "向标准输入写入内容")
	// 2.标准输出
	fmt.Fprint(os.Stdout, "向标准输出写入内容")
	// 3.写入文件打开
	file, err := os.OpenFile("./Fprint.txt", os.O_CREATE|os.O_TRUNC|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("open file erro", err)
		return
	}
	// 4.带换行写入
	fmt.Fprintln(file, "2.我是写入的字符串: 我喜爱网络安全技术")
	// 5.不带换行写入
	fmt.Fprintf(file, "1.我是写入的字符串:%v", "我喜爱网络安全技术")
}

func demo1() {
	// 1.打开需要写的文件，如果文件不存在就创建并晴空内容，对于该文件只写，其权限为0644.
	file, err := os.OpenFile("write.txt", os.O_CREATE|os.O_TRUNC|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("Open write file error:", err)
		return
	}
	defer file.Close()

	// 2.方式1以字节切片数据写入。
	var str0 = []byte{'a', 'b', 'c', ' '}
	str0 = append(str0, 'o', 'p', 'f', '\n')
	file.Write(str0)

	// 3.方式2以字符串数据写入。
	var str1 string = "Hello , Go - 我是要写入的字符串。"
	file.WriteString(str1)
}

func demo2() {
	// 1.打开需要写的文件，如果文件不存在就创建并晴空内容，对于该文件只写，其权限为0644.
	file, err := os.OpenFile("write.txt", os.O_CREATE|os.O_TRUNC|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("Open write file error:", err)
		return
	}
	defer file.Close()

	// 2.实例化得到一个文件句柄的缓冲区
	writer := bufio.NewWriter(file)
	for i := 0; i < 10; i++ {
		// 3.将数据先写入缓存
		line := fmt.Sprintf("第%d行，hello go，bufio.NewWriter 写入!\n", i+1)
		writer.WriteString(line)
	}
	// 4.将缓存中的内容写入文件
	writer.Flush()
}

func demo3() {
	var msg0, msg1, msg string
	fmt.Println("# 请输入你要向文件写入的字符串：")
	// 方式1.终端获取字符串
	fmt.Scanln(&msg0)
	// 方式2.采用NewReader获取终端
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("# 请输入你要向文件写入的字符串：")
	msg1, _ = reader.ReadString('\n')

	// 字符串拼接
	var build strings.Builder
	build.WriteString(msg0)
	build.WriteString(msg1)
	msg = build.String()
	err := ioutil.WriteFile("./WriteFile.txt", []byte(msg), 0644)
	if err != nil {
		fmt.Println("open file faild:", err)
		return
	}
}

func main() {
	// demo0()
	// demo1()
	fmt.Println()
	// demo2()
	demo3()
}
