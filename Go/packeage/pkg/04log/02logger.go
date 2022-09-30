package main

import (
	"fmt"
	"log"
	"os"
	"time"
)

func delay() {
	time.Sleep(time.Duration(1) * time.Second)
}

func main() {
	v := "信息警告提示"

	// 常规信息
	log.Printf("[-] 此处是这一条的日志信息 ：%s 。\n", v)
	delay()
	log.Println("[-] 这是一条换行的日志信息。")

	// Flag 选项
	log.SetFlags(log.Llongfile | log.Lmicroseconds | log.Ltime | log.Ldate)
	log.Println("[-] 这是换行的日志信息(Flag 选项)。")

	// 配置日志前缀
	log.SetPrefix("[WeiyiGeek] ")
	log.Println("这是换行的日志信息(配置日志前缀)。")

	// 创建 logger 使用示例
	logger := log.New(os.Stdout, "[New-WeiGeek] ", log.Lshortfile|log.Ldate|log.Ltime)
	logger.Println("这是自定义的logger记录的日志。")

	// 配置日志输出
	logFile, err := os.OpenFile("./Logger.log", os.O_CREATE|os.O_WRONLY|os.O_APPEND, 0644)
	if err != nil {
		fmt.Println("open log file failed, err:", err)
		return
	}
	log.SetOutput(logFile)               // 每次执行不会覆盖其内容，而会向其追加内容。
	log.Println("[-] 这是要配置日志输出到文件之中（1）") // 会输出到 /Logger.log
	log.Println("[-] 这是要配置日志输出到文件之中（2）") // 会输出到 /Logger.log

	// 执行 Panicln 则会exit
	delay()
	log.Fatalln("[-] 这是一条会触发fatal的日志。") // 会输出到 /Logger.log
	delay()
	log.Panicln("[-] 这是一条会触发panic的日志。")
}
