package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"time"
)

func main() {
	// 1.声明定义server监听端口地址
	serveraddr := "0.0.0.0:8080"

	// 2.HandleFunc在DefaultServeMux中注册给定模式的处理程序。
	http.HandleFunc("/hello", hello)
	http.HandleFunc("/blog", blog)
	http.HandleFunc("/htmlfile", htmlfile)

	// 3.启动httpServer监听并采用包变量DefaultServeMux作为处理器。
	err := http.ListenAndServe(serveraddr, nil)
	if err != nil {
		log.Fatal(err)
	} else {
		fmt.Printf("Http Server %v Started......", serveraddr)
	}
}

// (1) 方式1.此种方式不能直接写入HTML标签代码并返还给客户端.
func hello(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello World! Go <b>测试页面0</b> Time : %s", time.Now())
}

// (2) 方式2.可以直接写入HTML标签代码并返还给客户端.
func blog(w http.ResponseWriter, r *http.Request) {
	reply := fmt.Sprintf("<b>测试页面1</b><p> 标题.Demo1 Test(Go net/http) </p> <i>I'm WeiyiGeek</i><br/> Time : %s", time.Now().Format("2006-01-02 15:04:05"))
	w.Write([]byte(reply))
}

// (3) 读取本机上的网页为文件返还给客户端.
func htmlfile(w http.ResponseWriter, r *http.Request) {
	res, err := ioutil.ReadFile("./index.html")
	if err != nil {
		w.Write([]byte(fmt.Sprintf("Error: %v", err)))
		return
	}
	w.Write([]byte(res))
}

// 	http.HandleFunc("/client", client)

// func client(w http.ResponseWriter, r *http.Request) {
// 	// 对于客户端Request请求信息获取
// 	fmt.Printf(r.Method, " ", r.URL)
// 	fmt.Println(r.URL.Query()) // 自动识别请求URL中的参数,参数利用Map进行存储key-value
// 	queryParam := r.URL.Query()
// 	id := queryParam.Get("id")
// 	name := queryParam.Get("name")
// 	fmt.Printf("id = %v,name = %v\n", id, name)

// 	fmt.Println(ioutil.ReadAll(r.Body)) // 服务端打印客户端发来的请求Body
// 	w.Write([]byte("{status:'ok'}"))
// }
