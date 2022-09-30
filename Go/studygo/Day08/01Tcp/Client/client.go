package main

import (
	"fmt"
	"net"
)

func main() {
	// 1.与Server端建立TCP通信链接
	address := "10.20.172.108:22022"
	conn, err := net.Dial("tcp", address)
	if err != nil {
		fmt.Printf("Connect Server failed!\nerr:%v\n", err)
		return
	}

	// 2.发送字符串数据到Server端
	sendMsg := "Hello World! Server, I'm client"
	conn.Write([]byte(sendMsg))

	// 3.关闭建立的TCP通信链接
	defer conn.Close()
}
