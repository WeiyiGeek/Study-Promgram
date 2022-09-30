package splitstring

import (
	"reflect"
	"testing"
)

// 注意测试的函数格式采用驼峰命名法,且首字母必须大写
func Test1Split(t *testing.T) {
	ret := Split("abcadeafg", "a")
	want := []string{"bc", "de", "fg"}
	// fmt.Printf("%#v", want)
	if !reflect.DeepEqual(ret, want) {
		// 测试用例失败提醒
		t.Errorf("Want: %v But Got:%v \n", want, ret)
	}
}

func Test2Split(t *testing.T) {
	ret := Split("abcadeafg", "ad")
	want := []string{"abc", "eafg"}
	// 利用反射进行比较不能直接比较的变量
	if !reflect.DeepEqual(ret, want) {
		// 测试用例失败提醒
		t.Errorf("Want: %v But Got:%v \n", want, ret)
	}
}
