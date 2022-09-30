// server 端是一个接收客户端发送的信息并将信息进行广播.
package main

import (
	"bufio"
	"fmt"
	"log"
	"net"
	"time"
)

// (1) 声明对外发送消息的全局通道字符串类型.
type client chan<- string

// (2) 声明客户端状态以及发送的信息
var (
	entering = make(chan client)
	leaving  = make(chan client)
	messages = make(chan string) // 所有连接的客户端
)

// (4) 并发broadcaster广播器,循环监听通道中是否有内容
func broadcaster() {
	// 它使用局部变量 clients 来记录当前连接的客户集合，每个客户唯一被记录的信息是其对外发送消息通道的 ID.
	// 初始化声明,使用一个字典来保存用户 clients，字典的 key 是各连接申明的单向并发队列。
	clients := make(map[client]bool)

	// 循环执行&开启一个多路复用
	for {
		select {
		// 每当有广播消息从 messages 发送进来，都会循环 cliens 对里面的每个 channel 发消息。
		case msg := <-messages:
			// 把所有接收到的消息广播给所有客户端
			for cli := range clients {
				cli <- msg // 发送消息通道
			}
		// 每当有消息从 entering 里面发送过来，就生成一个新的 key - value，相当于给 clients 里面增加一个新的 client。
		case cli := <-entering:
			clients[cli] = true // 表面客户端上线
		// 每当有消息从 leaving 里面发送过来，就删掉这个 key - value 对，并关闭对应的 channel。
		case cli := <-leaving:
			delete(clients, cli) // 表面客户端离线,并删除对应的连接的 clients,cli
			close(cli)
		}
	}
}

// (5) 并发 handleConn 函数创建一个对外发送消息的新通道,
func handleConn(conn net.Conn) {
	// 对外发送客户消息的通道
	ch := make(chan string)
	go clientWriter(conn, ch)

	// 获取客户端;连接过来的网络地址和端口信息
	who := conn.RemoteAddr().String()

	// 向通道传入客户端信息
	ch <- "欢迎 " + who
	messages <- who + " 上线"
	entering <- ch

	// 读取客户端传入的信息并传入messages通道(利用其进行广播给其他客户端)
	input := bufio.NewScanner(conn)
	for input.Scan() {
		messages <- who + ": " + input.Text()
	}

	// 一旦从客户端读取完毕消息，handleConn 通过 leaving 通道通知客户离开，然后关闭连接。
	// 注意：忽略 input.Err() 中可能的错误
	leaving <- ch
	messages <- who + " 下线"
	conn.Close()
}

// (6) clientWriter 实现向客户端发生通道中的信息.
func clientWriter(conn net.Conn, ch <-chan string) {
	for msg := range ch {
		fmt.Fprintln(conn, msg) // 注意：忽略网络层面的错误
		fmt.Printf("[info] %v - Send -> Client %v\n", time.Now().Format("2006-01-02 15:04:06"), msg)
	}
}

// (3) 入口函数,主要获得 listener 对象，然后不停的获取链接上来的 conn 对象，最后把这些对象丢给处理链接函数去进行处理。
func main() {
	// 3.1 TCP server 端监控
	listener, err := net.Listen("tcp", "127.0.0.1:30000")
	if err != nil {
		log.Fatal(err) // 输出严重的错误并日志退出程序
	} else {
		fmt.Printf("Server %v Listen Start....\n", listener.Addr().String())
	}

	// 3.2 broadcaster函数.负责广播所有用户发送的消息。
	go broadcaster()

	// 3.3 循环接收客户端接入请求
	for {
		conn, err := listener.Accept()
		if err != nil {
			log.Print(err)
			continue
		}
		// 3.4 每个客户自己的 goroutine
		go handleConn(conn)
	}
}
