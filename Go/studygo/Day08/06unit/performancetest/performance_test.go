package performmancetest

import (
	"testing"
	custom "weiyigeek.top/packeage/myself"
)

// 注意此处调用的函数名称是小写
func benchmarkFibonacci(b *testing.B, num int) {
	for i := 0; i < b.N; i++ {
		custom.Fibonacci(num)
	}
}

// 基准测试的函数名仍然是以Benchmark_开头
func BenchmarkFib1(b *testing.B)  { benchmarkFibonacci(b, 1) }
func BenchmarkFib2(b *testing.B)  { benchmarkFibonacci(b, 2) }
func BenchmarkFib3(b *testing.B)  { benchmarkFibonacci(b, 3) }
func BenchmarkFib10(b *testing.B) { benchmarkFibonacci(b, 10) }
func BenchmarkFib20(b *testing.B) { benchmarkFibonacci(b, 20) }
func BenchmarkFib40(b *testing.B) { benchmarkFibonacci(b, 40) }
