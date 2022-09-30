package main

import (
	"fmt"
	"sync"
	"time"
)

// goroutine 同步等待组
var wg sync.WaitGroup
var one sync.Once

func worker(id int, jobs <-chan int, results chan<- int) {
	defer wg.Done()
	for j := range jobs {
		fmt.Printf("worker:%d start job:%d\n", id, j)
		time.Sleep(time.Millisecond * 500)
		fmt.Printf("worker:%d end job:%d\n", id, j)
		results <- j * 2
	}
	// 保证调用的函数只执行一次 (关键点)
	one.Do(func() {
		close(results)
	})

}

// 五个任务给3给goroutine池执行
func main() {
	jobs := make(chan int, 100)
	results := make(chan int, 100)
	// goroutine 池(此处3个goroutine组成)
	wg.Add(3)
	for w := 1; w <= 3; w++ {
		go worker(w, jobs, results) // 当执行到第五的一个任务后将阻塞
	}
	// 设置5个任务
	for j := 1; j <= 5; j++ {
		jobs <- j
	}
	// 保证调用的函数只执行一次 (关键点)
	one.Do(func() {
		close(jobs)
	})
	wg.Wait()
	// 输出结果
	fmt.Println("results channle length: ", len(results)) // 长度为 5
	// 方式1,打印后阻塞
	// for {
	// 	x, ok := <-results
	// 	if !ok {
	// 		fmt.Println(ok)
	// 		break
	// 	}
	// 	fmt.Println(ok, x)
	// }

	// 方式2,打印后阻塞
	// for i := range results {
	// 	fmt.Println(i)
	// }

	// 此种方式不会阻塞
	for a := 1; a <= 5; a++ {
		<-results
	}
}
