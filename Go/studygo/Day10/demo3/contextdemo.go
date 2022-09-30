package main

import (
	"context"
	"fmt"
	"sync"
	"time"
)

// 示例3.利用context实现子goroutine退出
var wg sync.WaitGroup

// 并发调用childwork函数
func childwork(ctx context.Context) {
	defer wg.Done()
LOOPEXIT:
	for {
		fmt.Printf("%v : %v\n", time.Now().Format("2006-01-02 15:04:05"), "childwork -> WeiyiGeek")
		time.Sleep(time.Millisecond * 500)
		select {
		case <-ctx.Done():
			break LOOPEXIT // 退出跳转，如果直接break则无法跳出
		default:
			fmt.Println("# childwork")
		}
	}
}

// 并发调用work函数
func work(ctx context.Context) {
	defer wg.Done()
	go childwork(ctx)
LOOPEXIT:
	for {
		fmt.Printf("%v : %v\n", time.Now().Format("2006-01-02 15:04:05"), "work->WeiyiGeek")
		time.Sleep(time.Millisecond * 500)
		select {
		case <-ctx.Done():
			break LOOPEXIT // 退出跳转，如果直接break则无法跳出
		default:
			fmt.Println("# work")
		}
	}
}

func main() {
	// WithCancel返回具有新完成通道的父级副本。调用返回的cancel函数或关闭父上下文的Done通道时，返回上下文的Done通道关闭，以先发生的为准。
	ctx, cancle := context.WithCancel(context.Background())
	wg.Add(1)
	go work(ctx)
	time.Sleep(time.Second * 5)
	cancle()
	wg.Wait()
}
