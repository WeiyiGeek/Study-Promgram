package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"strconv"
	"time"
)

// 4.自定义Handler结构体
type myHandler struct {
	Id   int    `json:"id"`
	Name string `json:"name"`
}

// 5.自定义myHandler结构体的方法注册到Handler处理程序,【非常注意】、【非常注意】方法名必须为 ServeHTTP
func (handler myHandler) ServeHTTP(w http.ResponseWriter, req *http.Request) {
	// 6.现在handler基于URL的路径部分（req.URL.Path）来决定执行什么逻辑。
	switch req.URL.Path {
	case "/get":
		// 7.对于客户端Get请求参数获取
		fmt.Printf("Method : %v, URL : %v \n", req.Method, req.URL)

		// 8.自动识别请求URL中的参数,参数利用Map类型变量进行存储key-value
		fmt.Println("QueryParam : ", req.URL.Query())
		queryParam := req.URL.Query()
		id := queryParam.Get("id")
		name := queryParam.Get("name")

		// 9.打印输出queryParam存储的value
		fmt.Printf("id = %v,name = %v\n", id, name)

		// 10.服务端响应头header自定义
		w.Header().Add("RequestMethod", "Get")                            // 此处将响应的RequestMethod header字段设置为Get
		w.Header().Add("Content-Type", "application/json;charset=UTF-8")  // 此处将响应的类型设置为JSON
		w.Header().Add("Cookies", fmt.Sprintf("id=%v;name=%v", id, name)) // 此处将响应的cookies设置为请求传入的参数

		// 11.返回给客户端的JSON数据组装
		uid, err := strconv.Atoi(id) // 将get到的id字段的值转换为整型
		if err != nil {
			errMsg := fmt.Sprintf("uid convert err! %v\n", err)
			fmt.Println(errMsg)
			w.Write([]byte(errMsg))
			return
		}
		reply := fmt.Sprintf("{\"method\":\"%v\",\"status\":\"ok\",\"data\":{\"id\":%v,\"name\":\"%v\"}}", "GET", uid, handler.Name)
		fmt.Printf("reply => %v\n\n", reply)

		// 12.返回响应数据给客户端
		w.Write([]byte(reply))

	case "/post":
		// 7.对于客户端Request请求信息获取
		fmt.Printf("Method : %v, URL : %v \n", req.Method, req.URL)

		// 8.服务端打印客户端发来的请求,当请求类型是application/json时才能从req.Body读取数据
		body, err := ioutil.ReadAll(req.Body)
		if err != nil {
			fmt.Println("req Body Read Error,", err)
			return
		}
		fmt.Println("req.Body => ", string(body))

		//9.JSON反序列化
		json.Unmarshal(body, &handler)

		// 10.打印输出queryParam存储的value
		fmt.Printf("id = %v,name = %v\n", handler.Id, handler.Name)

		// 11.服务端响应头header自定义
		w.Header().Add("RequestMethod", "Post")                                           // 此处将响应的RequestMethod header字段设置为POST
		w.Header().Add("Content-Type", "application/json;charset=UTF-8")                  // 此处将响应的类型设置为JSON
		w.Header().Add("Cookies", fmt.Sprintf("id=%v;name=%v", handler.Id, handler.Name)) // 此处将响应的cookies设置为请求传入的参数

		// 12.返回给客户端的JSON数据组装
		reply := fmt.Sprintf("{\"method\":\"%v\",\"status\":\"ok\",\"data\":{\"id\":%v,\"name\":\"%v\"}}", "POST", handler.Id, handler.Name)
		fmt.Printf("reply =>  %v\n\n", reply)

		// 13.返回响应数据给客户端
		w.Write([]byte(reply))

	case "/postform":

		// 7.对于客户端Request请求信息获取
		fmt.Printf("Method : %v, URL : %v \n", req.Method, req.URL)

		// 8. 请求类型是application/x-www-form-urlencoded时解析form数据并打印
		req.ParseForm()
		fmt.Println(req.PostForm)

		// 9.获取postform表单中指定的字段值.
		id := req.PostForm.Get("id")
		name := req.PostForm.Get("name")
		fmt.Printf("id = %v, name = %v\n", id, name)

		// 10.服务端打印客户端发来的请求Body此处为[],因为但客户端请求类型是application/json时才能从req.Body读取数据
		body, err := ioutil.ReadAll(req.Body)
		if err != nil {
			fmt.Println("req Body Read Error,", err)
			return
		}
		fmt.Println("req.Body => ", string(body))

		// 11.服务端响应头header自定义
		w.Header().Add("RequestMethod", "PostForm")                                   // 此处将响应的RequestMethod header字段设置为PostForm
		w.Header().Add("Content-Type", "application/json;charset=UTF-8")              // 此处将响应的类型设置为JSON
		w.Header().Add("Cookies", fmt.Sprintf("method=form;id=%v;name=%v", id, name)) // 此处将响应的cookies设置为请求传入的参数

		// 12.返回给客户端的JSON数据组装
		uid, err := strconv.Atoi(id) // 将get到的id字段的值转换为整型
		if err != nil {
			errMsg := fmt.Sprintf("uid convert err! %v\n", err)
			fmt.Println(errMsg)
			w.Write([]byte(errMsg))
			return
		}
		reply := fmt.Sprintf("{\"method\":\"%v\",\"status\":\"ok\",\"data\":{\"id\":%v,\"name\":\"%v\"}}", "POSTFORM", uid, handler.Name)
		fmt.Println("reply => ", reply)
		w.Write([]byte(reply))
	default:
		// 如果这个handler不能识别这个路径，它会通过调用返回客户端一个HTTP404错误,并响应给客户端表明请求的路径不存在.
		w.WriteHeader(http.StatusNotFound) // 404
		fmt.Fprintf(w, "no such page: %s\n", req.URL)
	}
}

func main() {
	// 1.实例化一个处理所有请求的Handler接口
	handler := myHandler{Name: "WeiyiGeek"}

	// 2.创建一个自定义的Server,注意如果Handler为nil则采用http.DefaultServeMux进行处理响应,否则需要我们自己实现结构体的ServeHTTP方法.
	server := &http.Server{
		Addr:           ":8080",
		Handler:        handler,
		ReadTimeout:    10 * time.Second,
		WriteTimeout:   10 * time.Second,
		IdleTimeout:    15 * time.Second,
		MaxHeaderBytes: 1 << 20,
	}

	// 3.启动并监听HTTP服务端
	fmt.Printf("[%v] Http Server Start.....\n", time.Now().Format("2006-01-02 15:04:05"))
	log.Fatal(server.ListenAndServe())
	defer fmt.Printf("[%v] Http Server Close.....\n", time.Now().Format("2006-01-02 15:04:05"))
}
