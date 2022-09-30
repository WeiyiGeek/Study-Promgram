//自定义实现切割字符串
package grouptest

import (
	"strings"
)

// 1.Split 切割自定义实现函数
func Split(str string, sep string) []string {
	var ret []string
	index := strings.Index(str, sep)
	seplen := len(sep)
	// 2.sep 在字符串索引中大于等于0时证明有字符串
	for index >= 0 {
		splitstr := str[:index]
		// 3.过滤分割字符前空以及后空
		if splitstr != "" {
			ret = append(ret, splitstr)
		}
		str = str[index+seplen:]
		index = strings.Index(str, sep)
	}
	// 4.将最后的字符也放入ret数组中.
	ret = append(ret, str)
	return ret
}
