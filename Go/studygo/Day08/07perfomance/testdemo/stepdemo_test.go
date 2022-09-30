package main

import (
	"fmt"
	"os"
	"testing"
)

// 分别记录 calcStep(n-1)，calcStep(n-2)，以及程序执行次数
var (
	x, y, c uint
)

// # stepladder 常规方法
func calcStep(step uint) uint {
	c += 1
	if step <= 0 {
		fmt.Printf("[ERR] - Input Step (%d) Must Greater than 0 ", step)
		os.Exit(-1)
	}
	switch step {
	case 1:
		return 1
	case 2:
		return 2
	case 3:
		return 3
	default:
		return calcStep(step-1) + calcStep(step-2)
	}
}

// stepladder 优化后方法，减少递归次数
// 关系: f(4) = 2(f2) + f(1)
func optimizationcalcStep(step uint) uint {
	if step <= 3 {
		return calcStep(step)
	} else {
		x = calcStep(step - 2)
		y = calcStep(step - 3)
		return 2*x + y
	}
}

// # 单元测试
func TestStepladder(t *testing.T) {
	// 常规方法
	got := calcStep(16)
	want := uint(1597)
	if !(got == want) {
		// 测试用例失败提醒
		t.Errorf("Want: %v But Got:%v \n", want, got)
	}
}

func TestStepladderOpti(t *testing.T) {
	// 优化后
	got := optimizationcalcStep(16)
	want := uint(1597)
	if !(got == want) {
		// 测试用例失败提醒
		t.Errorf("Want: %v But Got:%v \n", want, got)
	}
}

// # 基准测试
func benchmarkstepladder(b *testing.B, step uint) {
	for i := 0; i < b.N; i++ {
		calcStep(step)
	}
}
func benchmarkstepladderOpti(b *testing.B, step uint) {
	for i := 0; i < b.N; i++ {
		optimizationcalcStep(step)
	}
}

func BenchmarkFib1(b *testing.B)    { benchmarkstepladder(b, 16) }     // 常规 16 步阶梯有多数种走法
func BenchmarkFibOpt1(b *testing.B) { benchmarkstepladderOpti(b, 16) } // 优化后
func BenchmarkFib2(b *testing.B)    { benchmarkstepladder(b, 25) }     // 常规 25 步阶梯有多数种走法
func BenchmarkFibOpt2(b *testing.B) { benchmarkstepladderOpti(b, 25) } // 优化后

// # 示例函数
// Example_stepladder 常规方法的示例函数
func Example_stepladder() {
	got := calcStep(16)
	fmt.Println(got)
	// output:
	// 1597
}

// Example_stepladderOpti 优化后方法的示例函数
func Example_stepladderOpti() {
	got := optimizationcalcStep(16)
	fmt.Println(got)
	// output:
	// 1597
}

func main() {
	// 走梯子计算优化函数
	ret := func(num uint) uint {
		if num <= 3 {
			return calcStep(num)
		} else {
			x = calcStep(num - 2) // 减少递归次数
			y = calcStep(num - 3)
			return 2*x + y
		}
	}(16)
	fmt.Printf("优化走梯子方法. 16步阶梯的走法 = %d，执行次数: %d\n", ret, c)
	c = 0
	fmt.Printf("常规走梯子方法. 16步阶梯的走法 = %d, 执行次数: %d\n", calcStep(16), c)
}
