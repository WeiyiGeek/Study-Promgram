package main

import (
	"sync"
	"time"
)

var m *sync.RWMutex
var val = 0

// read 方法应用了读锁RLock;
func read(i int) {
	m.RLock()
	println("读: ", i, val)
	time.Sleep(3 * time.Second) // 为了验证协程抢夺资源, 读写方法中我们让程序休眠一定的时间;
	println("读结束")
	defer m.RUnlock()
}

//  write 方法应用了写锁 Lock;
func write(i int) {
	m.Lock()
	val = val + 10
	println("写: ", i, val)
	time.Sleep(3 * time.Second) // 为了验证协程抢夺资源, 读写方法中我们让程序休眠一定的时间;
	println("写结束")
	defer m.Unlock()
}

func main() {
	m = new(sync.RWMutex)
	for i := 0; i < 5; i++ {
		go read(1)
	}
	for j := 0; j < 5; j++ {
		go write(2)
	}
	for m := 0; m < 5; m++ {
		go read(3)
	}
	// 此处防止主程序提前退出,goroutine 协程函数还未执行完.
	time.Sleep(20 * time.Second)
}
