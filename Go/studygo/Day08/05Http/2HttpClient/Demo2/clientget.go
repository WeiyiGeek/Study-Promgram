package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"net/url"
	"strings"
)

func getMethod(urlstr string) {
	// 1.URL格式校验解析
	urlParse, err := url.Parse(urlstr)
	if err != nil {
		fmt.Printf("Url %v Format Error!\nerr: %v\n", urlParse, err)
		return
	}
	// 2.URL参数设置与编码
	data := url.Values{}
	data.Set("id", "1024")
	data.Set("name", "唯一极客")
	// 处理URL中包含的中文参数,此处采用encode进行编码.
	queryStr := data.Encode()
	// URL参数设置并输出处理过后的请求字符串
	urlParse.RawQuery = queryStr // encoded query values, without '?'
	fmt.Println("QueryStr => ", queryStr)

	// 3.NewRequest使用后台上下文包装NewRequestWithContext,返回请求对象
	req, err := http.NewRequest("Get", urlParse.String(), nil)
	if err != nil {
		fmt.Printf("NewRequest %v faile!\n[error]: %v\n", urlstr, err)
		return
	}

	// 5.DefaultClient是默认客户端，由Get、Head和Post请求使用,此时传入上面处过的req请求对象
	resp, err := http.DefaultClient.Do(req)
	if err != nil {
		fmt.Printf("Request %v faile!\n[error]: %v\n", urlstr, err)
		return
	}

	// 6.程序完毕时关闭回复的主体(非常重要).
	defer resp.Body.Close()

	// 7.从resp中把服务端返回的数据读出来
	// 方式1
	// var data []byte
	// response.Body.Read(data)
	// 方式2
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Printf("read from resp.Body failed, err:%v\n", err)
		return
	}

	// 8.网站请求响应数据集合
	fmt.Printf("resp.StatusCode : %v,\nresp.Status: %v,\nresp.Request: %#v,\nresp.Header: %#v\nresp.Cookies: %#v,\nresp.TLS: %#v\n",
		resp.StatusCode,
		resp.Status,
		resp.Request,
		resp.Header,
		resp.Cookies(),
		resp.TLS)
	fmt.Println("网站响应长度: ", len(body))
}

// POST 示例
func postMethos(urlstr string) {
	// (1) 定义Post请求上传的参数( 表单数据/json数据)
	//contentType := "application/x-www-form-urlencoded"
	//data := "name=小王子&age=18"
	contentType := "application/json"
	data := `{"id":128,"name":"Weiyi"}`

	// (2) 进行 Post 请求传入请求url,contentType以及Post上传的data数据
	// resp, err := http.Post("http://example.com/upload", "image/jpeg", &buf)
	resp, err := http.Post(urlstr, contentType, strings.NewReader(data))
	if err != nil {
		fmt.Printf("post failed, err:%v\n", err)
		return
	}

	// (3) 程序结束则关闭resp资源
	defer resp.Body.Close()

	// (4) 读取POST请求返回的数据包
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Printf("get resp failed, err:%v\n", err)
		return
	}
	fmt.Println("Body : ", string(body))

	// (5) 响应头输出
	fmt.Println("resp.Header : ", resp.Header)
}

func postFormMethod(urlstr string) {
	// (1) 方式1定义Post请求上传的参数( 表单数据)
	//contentType := "application/x-www-form-urlencoded"
	//data := "id=256&name=唯一极客"

	// (2) 方式2定义Post请求上传的参数( 表单数据)
	data := url.Values{}
	data.Set("id", "256")
	data.Set("name", "WeiyiGeek-唯一极客")

	// (3) 进行表单上传请求
	// resp, err := http.PostForm("http://example.com/form", url.Values{"key": {"Value"}, "id": {"123"}})
	resp, err := http.PostForm(urlstr, data)
	if err != nil {
		fmt.Printf("postForm failed, err:%v\n", err)
		return
	}

	// (4) 程序结束则关闭resp资源
	defer resp.Body.Close()

	// (5) 读取POST请求返回的数据包
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Printf("get resp failed, err:%v\n", err)
		return
	}
	fmt.Println("Body : ", string(body))

	// (6) 响应头输出
	fmt.Println("resp.Header : ", resp.Header)

}

func main() {
	getMethod("http://10.20.172.108:8080/get")
	fmt.Println("#########################################")
	postMethos("http://10.20.172.108:8080/post")
	fmt.Println("#########################################")
	postFormMethod("http://10.20.172.108:8080/postform")
}
