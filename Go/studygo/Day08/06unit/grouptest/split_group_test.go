package grouptest

import (
	"reflect"
	"testing"
)

// 组测试 示例
func TestGroupSplit(t *testing.T) {
	// 定义一个测试用例类型
	type testCase struct {
		str  string
		sep  string
		want []string
	}

	// 定义一个存储测试用例的切片
	testGroup := []testCase{
		// 不推荐此种写法,会提示 redundant type from array, slice, or map composite literalsimplifycompositelit
		testCase{"abceafgh", "a", []string{"bce", "fgh"}},
		testCase{"a:b:c", ":", []string{"a", "b", "c"}},
		// 推荐写法
		{str: "abcdef", sep: "cd", want: []string{"ab", "ef"}},
		{str: "WeiyiGeek切割唯一极客", sep: "切割", want: []string{"WeiyiGeek", "唯一极客"}},
	}

	// 遍历切片，逐一执行测试用例
	for index, tc := range testGroup {
		got := Split(tc.str, tc.sep)
		if !reflect.DeepEqual(got, tc.want) {
			t.Fatalf("index %v,Want=%v not equal got=%v \n", index+1, tc.want, got)
		}
	}
}
