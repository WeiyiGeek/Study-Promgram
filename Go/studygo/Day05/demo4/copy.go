package main

import (
	"flag"
	"fmt"
	"io"
	"os"
)

// CopyFile 拷贝文件函数
func CopyFile(srcName, dstName string) (written int64, err error) {
	// 以读方式打开源文件
	src, err := os.Open(srcName)
	if err != nil {
		fmt.Printf("open %s failed, err:%v.\n", srcName, err)
		return
	}
	defer src.Close()
	// 以写|创建的方式打开目标文件
	dst, err := os.OpenFile(dstName, os.O_WRONLY|os.O_CREATE, 0644)
	if err != nil {
		fmt.Printf("open %s failed, err:%v.\n", dstName, err)
		return
	}
	defer dst.Close()
	return io.Copy(dst, src) //调用io.Copy()拷贝内容
}
func main() {
	// 解析命令行参数
	flag.Parse()
	// 如果没有传递两个参数则显示使用说明
	if flag.NArg() != 2 {
		fmt.Println("Usage: ./copy src.file dst.file")
		return
	}
	// 从命令行中获取要操作的文件
	fmt.Printf("正在复制从 %s 文件内容,到目标文件 %s 中.....", flag.Arg(0), flag.Arg(1))
	_, err := CopyFile(flag.Arg(0), flag.Arg(1))
	if err != nil {
		fmt.Println("copy file failed, err:", err)
		return
	}
	fmt.Println("copy done!")
}
