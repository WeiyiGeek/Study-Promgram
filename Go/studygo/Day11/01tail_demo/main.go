package main

import (
	"fmt"
	"time"

	"github.com/hpcloud/tail"
)

// tailf的用法示例

func main() {
	// 1.日志文件路径及其tail包Config设置
	fileName := "./access.log"
	config := tail.Config{
		ReOpen:    true,                                 // 是否重新打开
		Follow:    true,                                 // 是否进行跟随
		Location:  &tail.SeekInfo{Offset: 0, Whence: 2}, // 是否从文件的首行开始读取
		MustExist: false,                                // 文件是否必须存在
		Poll:      true,                                 // 是否轮询文件更改而不是使用inotify通知

	}

	// 2.持续跟随文件读取
	tailObj, err := tail.TailFile(fileName, config)
	if err != nil {
		fmt.Printf("Tail file failed, Err:%v", err)
		return
	}

	// 3.读取局部变量定义
	var (
		msg    *tail.Line // 拿取到的每一行
		status bool       // 拿取状态记录
	)

	// 4.跟踪读取文件内容
	for {
		msg, status = <-tailObj.Lines // 日志读取
		if !status {
			fmt.Printf("Tail file Close Reopen filename: %s\n", tailObj.Filename)
			time.Sleep(time.Second)
			continue
		}

		// 带中文输出的两种方式。
		// # 方式1.利用Ascii码转，中文在Go中是UTF8编码占用三个字节。
		// for _, ch := range msg.Text {
		// 	fmt.Printf("%s", string(ch))
		// }

		// # 方式2.利用string函数
		fmt.Println(string(msg.Text))
	}

}
