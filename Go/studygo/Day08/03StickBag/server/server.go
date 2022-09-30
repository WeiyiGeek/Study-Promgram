package main

import (
	"bufio"
	"fmt"
	"io"
	"net"

	"weiyigeek.top/studygo/Day08/03StickBag/proto"
)

func process(conn net.Conn) {
	// 4.退出时关闭conn资源
	defer conn.Close()
	// 5.NewReader返回其缓冲区具有默认大小的新读取器。
	reader := bufio.NewReader(conn)
	for {
		// 6.解包: 将通过conn对象中获取的缓冲区数据进行解包.
		msg, err := proto.Decode(reader)
		if err == io.EOF {
			return
		}
		if err != nil {
			fmt.Println("decode msg failed, err:", err)
			return
		}
		// 7.打印解包后的数据
		fmt.Println("收到client发来的数据：", msg)
	}
}
func main() {
	// 1.设置TCP Server端监听地址和端口
	listen, err := net.Listen("tcp", "127.0.0.1:30000")
	if err != nil {
		fmt.Println("listen failed, err:", err)
		return
	}
	// 2.函数结束后关闭监听资源
	defer listen.Close()

	// 3.循环接收客户端发送过来的数据,利用gorontine执行process任务
	for {
		conn, err := listen.Accept()
		if err != nil {
			fmt.Println("accept failed, err:", err)
			continue
		}
		go process(conn)
	}
}
