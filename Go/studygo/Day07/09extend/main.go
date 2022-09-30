// 优化并发流程,通知goroutine任务结束关闭通道.
package main

import (
	"fmt"
	"time"
)

func worker(id int, jobs <-chan int, results chan<- int, notify chan<- struct{}) {
	for j := range jobs {
		time.Sleep(time.Millisecond * 500)          // 延时500s查看效果比较明显
		fmt.Printf("worker:%d end job:%d\n", id, j) // end
		results <- j * 2
		notify <- struct{}{} // 任务执行信号标识,实例化匿名结构体,如此使用非常节省空间.
	}

}

func main() {
	// 1.初始化通道
	jobs := make(chan int, 100)
	results := make(chan int, 100)
	notify := make(chan struct{}, 5) // 作为信号使用,通道类型采用匿名结构体,占用的系统资源较少(常用值得学习),此处作为并发任务执行完毕通知.

	// 2.生成五个任务
	go func() {
		for i := 1; i <= 5; i++ {
			jobs <- i
		}
		close(jobs) // 给通道传递完值后
	}()

	// 3.开启三个Goroutine (并发池)
	for w := 1; w <= 3; w++ {
		go worker(w, jobs, results, notify)
	}

	// 4.通过信号变量,验证五个任务是否执行完毕,如果晚报则关闭results通道
	go func() {
		// 循环五次
		for i := 0; i < 5; i++ {
			<-notify
		}
		// 关闭通道
		close(results)
	}()

	// 5.遍历已关闭的通道值
	for res := range results {
		fmt.Println(res)
	}
}
