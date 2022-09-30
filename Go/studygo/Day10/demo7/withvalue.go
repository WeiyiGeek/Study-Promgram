package main

import (
	"context"
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

// 使用withValue时定义自己的类型
type TraceCode string

func worker(ctx context.Context) {
	key := TraceCode("TRACE_CODE")           // TraceCode 类型的字符串实际上就是string类型，只是采用了别名方式
	traceCode, ok := ctx.Value(key).(string) // 在子goroutine中获取ctx上下文绑定TRACE_CODE键值。
	if !ok {
		fmt.Println("invalid trace code")
	}
LOOP:
	for {
		fmt.Printf("worker, trace code:%s\n", traceCode)
		time.Sleep(time.Millisecond * 10) // 假设正常连接数据库耗时10毫秒
		select {
		case <-ctx.Done(): // 50毫秒后自动调用
			break LOOP // 退出当前for循环
		default:
		}
	}
	fmt.Println("worker done!")
	wg.Done()
}

func main() {
	// 设置一个50毫秒的超时并返回一个parent上下文。
	ctx, cancel := context.WithTimeout(context.Background(), time.Millisecond*50)
	// 在系统的入口中设置trace code传递给后续启动的goroutine实现日志数据聚合。
	ctx = context.WithValue(ctx, TraceCode("TRACE_CODE"), "12512312234")
	wg.Add(1)
	go worker(ctx)
	time.Sleep(time.Second * 5)
	cancel() // 关闭上下文并通知子goroutine结束
	wg.Wait()
	fmt.Println("over")
}
