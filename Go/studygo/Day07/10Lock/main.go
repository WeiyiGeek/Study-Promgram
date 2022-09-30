package main

import (
	"fmt"
	"sync"
)

var x int64
var wg sync.WaitGroup
var lock sync.Mutex

func add() {
	for i := 0; i < 5000; i++ {
		lock.Lock() // 加锁
		x = x + 1
		lock.Unlock() // 解锁
	}
	wg.Done()
}
func main() {
	poolCount := 2
	wg.Add(poolCount)
	for i := 0; i < poolCount; i++ {
		go add()
	}
	wg.Wait()
	fmt.Println(x)
}
