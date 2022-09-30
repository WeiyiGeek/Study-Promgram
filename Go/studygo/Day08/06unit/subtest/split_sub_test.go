package subtest

import (
	"reflect"
	"testing"
)

// 子测试 示例
func TestChildSplit(t *testing.T) {
	// 1.同样定义一个subTestCase
	type subTestCase struct {
		str, sep string
		want     []string
	}

	// 2.声明定义一个Map类型的testGroup变量
	testGroup := map[string]subTestCase{
		"Subtest_1": {"abceafgh", "a", []string{"bce", "fgh"}},
		"Subtest_2": {"a:b:c", ":", []string{"a", "b", "c"}},
		"Subtest_3": {"abcdef", "cd", []string{"ab", "ef"}},
		"Subtest_4": {"WeiyiGeek切割唯一极客", "切割", []string{"WeiyiGeek", "唯一极客"}},
		"Subtest_5": {"http://www.weiyigeek.top", "//", []string{"http:", "www.weiyigeek.top"}},
	}

	// 遍历测试组,逐一执行测试用例
	for k, v := range testGroup {
		println("测试名称: ", k)
		// 然后使用t.Run()执行子测试
		t.Run(k, func(t *testing.T) {
			got := Split(v.str, v.sep)
			if !reflect.DeepEqual(got, v.want) {
				t.Fatalf("index %v,Want=%v not equal got=%v \n", k, v.want, got)
			}
		})
	}
}
