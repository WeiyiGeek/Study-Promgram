package childsetupteardown

import (
	"reflect"
	"testing"

	custom "weiyigeek.top/packeage/myself"
)

// 1.测试集的Setup与Teardown
func setupTestCase(t *testing.T) func(t *testing.T) {
	t.Log("[测试集] 之前的 setup.....")
	return func(t *testing.T) {
		t.Log("[测试集] 之后的 teardown.....")
	}
}

// 2.子测试的Setup与Teardown
func setupSubTest(t *testing.T) func(t *testing.T) {
	t.Log("#[子测试集] 之前的 setup-------")
	return func(t *testing.T) {
		t.Log("#[子测试集] 之后的 teardown--------")
	}
}

// 3.单元测试函数
func TestSplit(t *testing.T) {
	type test struct { // 3.1 定义test结构体
		input string
		sep   string
		want  []string
	}
	tests := map[string]test{ // 3.2 测试用例使用map存储实例化
		"simple":      {input: "a:b:c", sep: ":", want: []string{"a", "b", "c"}},
		"wrong sep":   {input: "a:b:c", sep: ",", want: []string{"a:b:c"}},
		"more sep":    {input: "abcd", sep: "bc", want: []string{"a", "d"}},
		"leading sep": {input: "博客.blog.weiyigeek.top", sep: ".", want: []string{"博客", "blog", "weiyigeek", "top"}},
	}

	teardownTestCase := setupTestCase(t) // 3.3 测试之前执行setup操作  【关键点】
	defer teardownTestCase(t)            // 3.4 测试之后执行testdoen操作 【关键点】

	// 3.5 循环遍历子测试
	for name, tc := range tests {
		t.Run(name, func(t *testing.T) { // 3.6 使用t.Run()执行子测试
			teardownSubTest := setupSubTest(t)    // 3.7 子测试之前执行setup操作 【关键点】
			defer teardownSubTest(t)              // 3.8 测试之后执行testdoen操作【关键点】
			got := custom.Split(tc.input, tc.sep) // 3.9 字符串分割返回结果
			if !reflect.DeepEqual(got, tc.want) { // 3.10 利用反射函数判断两个数组
				t.Errorf("expected:%#v, got:%#v", tc.want, got)
			}
		})
	}
}
