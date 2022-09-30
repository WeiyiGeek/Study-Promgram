package main

import (
	"bufio"
	"flag"
	"fmt"
	"io"
	"os"
)

// cat命令实现函数
func cat(r *bufio.Reader) {
	for {
		// 注意是字符，按照每行进行读取
		buf, err := r.ReadBytes('\n')
		if err == io.EOF {
			// 退出之前将已读到的内容输出
			fmt.Fprintf(os.Stdout, "%s", buf)
			break
		}
		fmt.Fprintf(os.Stdout, "%s", buf)
	}
}

func main() {
	// 解析命令行参数
	flag.Parse()
	// 如果没有参数默认从标准输入读取内容
	if flag.NArg() == 0 {
		fmt.Printf("未指定文件将从标准输入读取内容:")
		stdin := bufio.NewReader(os.Stdin)
		buf, _ := stdin.ReadBytes('\n')
		fmt.Fprintf(os.Stdout, "\n%s", buf)
	}
	// 依次读取每个指定文件(可多个文件)的内容并打印到终端
	for i := 0; i < flag.NArg(); i++ {
		f, err := os.Open(flag.Arg(i))
		if err != nil {
			fmt.Fprintf(os.Stdout, "reading from %s failed, err:%v\n", flag.Arg(i), err)
			continue
		}
		cat(bufio.NewReader(f))
	}
}
