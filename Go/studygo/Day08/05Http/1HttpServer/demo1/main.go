package main

import (
	"fmt"
	"log"
	"net/http"
)

// 自定义结构体
type httpServer struct{}

// httpServer 自定义实现http请求处理程序函数
func (server httpServer) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	path := r.URL.Path
	fmt.Println(path)
	switch path {
	case "/":
		w.Write([]byte("根路径 : " + r.URL.Path))
	case "/index":
		w.Write([]byte("首页路径 : " + r.URL.Path))
	case "/hello":
		w.Write([]byte("子网页路径 : " + r.URL.Path))
	default:
		w.Write([]byte("<b>未知路径</b> : https://weiyigeek.top" + r.URL.Path))
	}
}

func main() {
	// 1.声明serve变量的类型为我们自定义结构体
	var server httpServer
	serveraddr := "0.0.0.0:8080"

	// 2.Handle在DefaultServeMux中注册给定模式的处理程序。
	http.Handle("/", server)

	// 3.启动httpServer监听并采用包变量DefaultServeMux作为处理器。
	err := http.ListenAndServe(serveraddr, nil)
	if err != nil {
		log.Fatal(err)
	} else {
		fmt.Printf("Http Server %v Started......", serveraddr)
	}
}
