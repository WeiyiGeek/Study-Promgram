package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

// 结构体声明
type job struct {
	value int64
}

type result struct {
	job *job // 结构体嵌套
	sum int64
}

// 并发等待组声明
var wg sync.WaitGroup

// 初始化goroutine
var jobChan = make(chan *job, 100)
var resultChan = make(chan *result, 100)

// 参数g通道只写
func generate(g chan<- *job) {
	defer wg.Done()
	// 循环生成int64随机数
	for {
		i := rand.Int63()
		// 实例化
		newJob := &job{
			value: i,
		}
		// 将实例化的对象存入通道中
		g <- newJob
		time.Sleep(time.Millisecond * 500)
	}
}

// 参数r通道i只写，参数g通道只读
func numberSum(r chan<- *result, g <-chan *job) {
	defer wg.Done()
	// 循环取得number的每个数字并累积其和,将结果发送到通道r中
	for {
		// 注意点,此处将g通道值赋予给job
		job := <-g
		sum := int64(0)
		number := job.value
		// 注意点
		for number > 0 {
			sum += number % 10 // 取余
			number /= 10       // 取商（整）
		}
		// 注意点,参数 g 传入的job类型的通道
		newResult := &result{
			job: job,
			sum: sum,
		}
		r <- newResult
	}
}

// 此goroutine将会持续不断的生产随机数，以及取出随机数计算各位数的和。(将会一直执行，因为一直在取而另外一边一直在取)
func main() {
	// 1.开启一个goroutine循环生成int64类型的随机数，发送到jobChan
	wg.Add(1)
	go generate(jobChan)
	// 2.开启24个goroutine从jobChan中取出随机数计算各位数的和，将结果发送到resultChan
	wg.Add(24)
	for i := 0; i < 24; i++ {
		go numberSum(resultChan, jobChan)
	}
	// 3.主goroutine从resultChan取出结果并打印到终端输出
	for res := range resultChan {
		fmt.Printf("number = %d, sum = %d\n", res.job.value, res.sum)
	}
	wg.Wait()
}
