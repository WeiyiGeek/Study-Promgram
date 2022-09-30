package setupteardown

import (
	"flag"
	"fmt"
	"os"
	"testing"
	"time"
)

// M是传递给TestMain函数以运行实际测试的类型。
// 执行第一步
func TestMain(m *testing.M) {
	var name string
	flag.StringVar(&name, "name", "张三", "姓名")
	flag.Parse()                                             // 如果 TestMain 使用了 flags 此处应该加上解析
	fmt.Println("## Step1.write setup code here...TestMain") // 测试之前的做一些设置工作
	ret := m.Run()
	fmt.Println("## Step4.write teardown code here...", ret) // 测试之后做一些拆卸工作
	os.Exit(ret)
}

// 执行第二步
func TestUser(t *testing.T) {
	fmt.Println("# Step2.write setup code here...【TestUser】") // 测试TestUser函数定义执行
	fmt.Println("正在测试执行第二步: 开始测试子测试函数")
	t.Run("调用 testFunc 中", testFunc) // 调用测试TestEnd函数，注意第一个字符串参数如有空格将会被下划线替代。
}

func testFunc(t *testing.T) {
	fmt.Println("这时测试的testFunc的函数，名称为testFunc")
	time.Sleep(5 * time.Second) // 延迟五秒钟
}

// 执行第三步
func TestEnd(t *testing.T) {
	fmt.Println("# Step3.write setup code here...【TestEnd】") // 测试TestEnd函数定义执行
}
