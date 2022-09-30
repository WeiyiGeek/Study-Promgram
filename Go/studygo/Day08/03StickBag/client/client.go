package main

import (
	"fmt"
	"net"

	"weiyigeek.top/studygo/Day08/03StickBag/proto"
)

func main() {
	// 1.连接到server端.
	conn, err := net.Dial("tcp", "127.0.0.1:30000")
	if err != nil {
		fmt.Println("dial failed, err", err)
		return
	}

	// 2.程序结束时关闭conn网络连接资源.
	defer conn.Close()

	// 3.循环发送20次msg给server端
	for i := 0; i < 20; i++ {
		msg := `Hello, Hello. How are you?`
		// 4.将要发送的信息进行封包处理
		data, err := proto.Encode(msg)
		if err != nil {
			fmt.Println("encode msg failed, err:", err)
			return
		}
		// 5.将处理过的封包进行发送
		conn.Write(data)
	}
}
