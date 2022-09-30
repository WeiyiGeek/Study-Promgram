// 进行Go语言性能测试的用例代码。
package main

import (
	"flag"
	"fmt"
	"os"
	"runtime/pprof"
	"time"
)

// logicCode 函数中包含一段有问题的代码
func logicCode() {
	var c chan int // 未对通道c进行初始化 make(chan int)
	for {
		select {
		case v := <-c: // 此时处于阻塞的状态
			fmt.Printf("recv from chan, value:%v\n", v)
		default:
			// time.Sleep(time.Second) // 问题解决办法
		}
	}
}

// main 性能测试入口函数
func main() {
	// 开发规范一致性
	var (
		isCPUPprof, isMemPprof bool
	)
	// flag包主要接收命令行参数以及解析，此时我们可以在命令行控制是否开启CPU和Mem的性能分析
	flag.BoolVar(&isCPUPprof, "cpu", false, "turn cpu pprof on")
	flag.BoolVar(&isMemPprof, "mem", false, "turn mem pprof on")
	flag.Parse()

	// 是否进行CPU心理测试
	if isCPUPprof {
		// 在当前可执行程序下创建一个cpu.pprof文件
		f1, err := os.Create("./cpu.pprof")
		if err != nil {
			fmt.Printf("create cpu pprof failed, err:%v\n", err)
			return
		}
		// 往文件中记录CPU Profile信息
		pprof.StartCPUProfile(f1)
		defer func() {
			pprof.StopCPUProfile()
			f1.Close()
		}()
	}

	// 进行性能测试的函数调用，此处时并发
	for i := 0; i < 8; i++ {
		go logicCode()
	}
	time.Sleep(20 * time.Second)

	// 是否进行内存分析?
	if isMemPprof {
		f2, err := os.Create("./mem.pprof")
		if err != nil {
			fmt.Printf("create mem pprof failed, err:%v\n", err)
			return
		}
		pprof.WriteHeapProfile(f2)
		f2.Close()
	}
}
