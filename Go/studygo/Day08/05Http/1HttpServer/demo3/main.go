package main

import (
	"fmt"
	"log"
	"net/http"
	"time"
)

// 自定义Handler结构体
type myHandler struct {
	name string
}

// 自定义注册到Handler接口体,注意方法名必须为ServeHTTP
func (handeler myHandler) ServeHTTP(w http.ResponseWriter, req *http.Request) {
	// 现在handler基于URL的路径部分（req.URL.Path）来决定执行什么逻辑。
	switch req.URL.Path {
	case "/index":
		fmt.Fprintf(w, "%s\n", "This is Index path")
	case "/weiyigeek":
		fmt.Fprintf(w, "%s -> %s\n", handeler.name, "https://weiyigeek.top") // WeiyiGeek -> https://weiyigeek.top
	default:
		// 如果这个handler不能识别这个路径，它会通过调用返回客户端一个HTTP404错误,并响应给客户端表明请求的路径不存在.
		w.WriteHeader(http.StatusNotFound) // 404
		fmt.Fprintf(w, "no such page: %s\n", req.URL)
	}
}

func main() {
	// 1.实例化一个处理所有请求的Handler接口
	handler := myHandler{name: "WeiyiGeek"}

	// 2.创建一个自定义的Server,注意如果Handler为nil则采用http.DefaultServeMux进行处理响应,否则需要我们自己实现结构体的ServeHTTP方法.
	server := &http.Server{
		Addr:           ":8080",
		Handler:        handler,
		ReadTimeout:    10 * time.Second,
		WriteTimeout:   10 * time.Second,
		IdleTimeout:    60 * time.Second,
		MaxHeaderBytes: 1 << 20,
	}

	// 3.启动并监听HTTP服务端
	log.Fatal(server.ListenAndServe())
}
