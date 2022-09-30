// client 是一个简单的TCP服务器读/写客户端
package main

import (
	"fmt"
	"io"
	"log"
	"net"
	"os"
)

func main() {
	// 1.连接到服务端
	conn, err := net.Dial("tcp", "127.0.0.1:30000")
	if err != nil {
		log.Fatal(err)
	}

	// 2.声明初始化一个匿名结构体通道(值得学习)
	done := make(chan struct{})

	// 3.利用goroutine执行任务
	go func() {
		var wcount int64
		// 注意：忽略错误,io.Copy 非常值的学习.
		if wcount, err = io.Copy(os.Stdout, conn); err != nil {
			log.Fatal(err)
		}
		if err != nil {
			fmt.Println("CONN OUT os.Stdout Error!")
		}
		fmt.Println("写入的长度: ", wcount)
		log.Println("Done")
		done <- struct{}{} // 向主Goroutine发出信号 (值的学习,如果不发main函数便不会停止,此时终端亦不会被阻塞)
	}()

	// 4.将终端输入传递给conn资源对象给服务器
	fmt.Println("请输入信息:")
	mustCopy(conn, os.Stdin)

	// 5.关闭conn资源
	defer conn.Close()

	<-done // 等待后台goroutine完成
}

func mustCopy(dst io.Writer, src io.Reader) {
	if _, err := io.Copy(dst, src); err != nil {
		log.Fatal(err)
	}
}
