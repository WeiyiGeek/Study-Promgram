//自定义实现切割字符串
package myself

import (
	"strings"
)

// 1.Split 切割自定义实现函数。
func Split(str string, sep string) (result []string) {
	// 2.提前使用make函数将result初始化为一个容量足够大的切片。
	result = make([]string, 0, strings.Count(str, sep)+1)
	index := strings.Index(str, sep)
	// 3.sep 在字符串索引中大于-1时证明有字符串。
	for index > -1 {
		splitstr := str[:index]
		// 4.过滤分割字符前空以及后空。
		if splitstr != "" {
			result = append(result, str[:index])
		}
		// 5.再次获取分割后的字符串。
		str = str[index+len(sep):]
		index = strings.Index(str, sep)
	}
	// 6.将最后的字符也放入ret数组中。
	result = append(result, str)
	return
}
