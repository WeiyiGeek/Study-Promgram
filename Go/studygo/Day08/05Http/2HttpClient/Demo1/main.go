package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
)

func getMethod(url string) {
	// 1.Get请求指定地址
	resp, err := http.Get(url)
	if err != nil {
		fmt.Printf("get failed, err:%v\n", err)
		return
	}
	// 2.程序完毕时关闭回复的主体.
	defer resp.Body.Close()

	// 3.读取响应的网页源代码
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Printf("read from resp.Body failed, err:%v\n", err)
		return
	}
	html := string(body)

	// 4.网站请求响应数据
	fmt.Printf("resp.StatusCode : %v,\nresp.Status: %v,\nresp.Request: %#v,\nresp.Header: %#v\nresp.Cookies: %#v,\nresp.TLS: %#v\n",
		resp.StatusCode,
		resp.Status,
		resp.Request,
		resp.Header,
		resp.Cookies(),
		resp.TLS)

	fmt.Println("网站响应长度: ", len(html))
}

func postMethos() {
	// resp, err := http.Post("http://example.com/upload", "image/jpeg", &buf)

}

func postFormMethod() {
	// resp, err := http.PostForm("http://example.com/form", url.Values{"key": {"Value"}, "id": {"123"}})

}

func main() {
	getMethod("https://www.weiyigeek.top")
}
