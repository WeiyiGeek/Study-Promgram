package main

import (
	"fmt"
	"net"
)

func main() {
	// 1.设置服务端监听端口
	address := "10.20.172.108:22022"
	listener, err := net.Listen("tcp", address)
	if err != nil {
		fmt.Printf("Start Tcp Server on %v Failed!\nerr：%v\n", address, err)
		return
	} else {
		fmt.Printf("Server Listen : %v\n", address)
	}

	// 2.等待客户端建立连接
	conn, err := listener.Accept()
	if err != nil {
		fmt.Printf("Accept failed,err: %v\n", err)
		return
	}
	defer conn.Close() // 程序结束时,关闭与客户端打开的TCP连接通道

	// 3.与客户端进行消息通信(读取客户端法过来的信息)
	var msg [1024]byte
	n, err := conn.Read(msg[:]) // 注意读取的类型是byte的slice
	if err != nil {
		fmt.Printf("Read from Client conn failed, err:%v\n", err)
		return
	}

	// 4.打印客户端发送的信息,注意此需要将[]byte类型的切片,转为字符串类型进行输出.
	fmt.Println(string(msg[:n]))
}
