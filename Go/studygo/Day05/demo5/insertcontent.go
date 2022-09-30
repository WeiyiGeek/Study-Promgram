package main

import (
	"fmt"
	"io"
	"os"
)

func testInsert() {
	// 源文件
	file, err := os.OpenFile("./tmp.txt", os.O_RDONLY, 0644)
	if err != nil {
		fmt.Printf("Open tmp.txt file failed, err: %v", err)
		return
	}

	// 临时文件
	filetmp, err := os.OpenFile("./tmp.tmp", os.O_CREATE|os.O_TRUNC|os.O_APPEND|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Printf("Open tmp.tmp file failed, err: %v", err)
		return
	}

	// 光标的开始位置
	file.Seek(0, 0)
	// 读取光标后的五个字符
	var ret [5]byte
	n, err := file.Read(ret[:]) // weiyigeek
	if err != nil {
		fmt.Printf("file.Read failed, err: %v", err)
		return
	}
	fmt.Printf("# read %d character: %s", n, ret[:n])
	filetmp.Write(ret[:n])

	// 写入要插入的字符串。
	str := "Geek"
	filetmp.WriteString(str)

	// 将剩下的字符串读取并写入到临时文件中
	var tmp [128]byte
	for {
		n, err := file.Read(tmp[:]) //每次读128Byte存入tmp中并返回字节数
		if err == io.EOF {
			filetmp.Write(tmp[:n])
			break
		} else if err != nil {
			fmt.Println("read file failed, err:", err)
			return
		}
		filetmp.Write(tmp[:n])
	}

	// 将临时文件重命名
	os.Rename("./tmp.tmp", "./tmp.txt")

	// 关闭源文件
	defer file.Close()
	defer filetmp.Close()
}

func main() {
	fmt.Println("# 指定文件内容插入演示")
	testInsert()
}
