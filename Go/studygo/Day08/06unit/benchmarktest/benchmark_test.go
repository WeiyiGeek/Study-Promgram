package benchmarktest

import (
	"testing"

	custom "weiyigeek.top/packeage/myself"
)

// func BenchmarkFibonacci(b *testing.B) {
// 	// fmt.Printf("Fibonacci(%d) = %d\n", 10, custom.Fibonacci(10))
// 	for i := 0; i < b.N; i++ {
// 		custom.Fibonacci(10)
// 	}
// }

func BenchmarkSplit(b *testing.B) {
	for i := 0; i < b.N; i++ {
		custom.Split("http://www.weiyigeek.top", ".")
	}
}

// func BenchmarkFibonacci(b *testing.B) {
// 	for i := 0; i < b.N; i++ {
// 		ret := custom.Fibonacci(i)
// 		fmt.Printf("Fibonacci(%d) = %d", i, ret)
// 		if ret == 165580141 {
// 			break
// 		}
// 	}
// }
