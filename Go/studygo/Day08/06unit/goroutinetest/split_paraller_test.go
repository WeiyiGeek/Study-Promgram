package goroutinetest

import (
	"testing"

	custom "weiyigeek.top/packeage/myself"
)

func BenchmarkSplitParaller(b *testing.B) {
	// 假设需要做一些耗时的无关操作
	// time.Sleep(5 * time.Second)

	// 增加非CPU受限（non-CPU-bound）基准测试的并行性，即设置使用的CPU数
	//b.SetParallelism(2)

	// 重置计时器
	// b.ResetTimer()

	//以并行的方式，执行给定的基准测试。
	b.RunParallel(func(pb *testing.PB) {
		for pb.Next() {
			custom.Split("http://blog.weiyigeek.top", ".")
		}
	})
}
