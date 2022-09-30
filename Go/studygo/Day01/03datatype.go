package main

import (
	"fmt"
	"math"
	"strings"
)

// 整型
func intdemo() {
	// 十进制以不同的进制展示
	var a int = 10
	fmt.Printf("%b \n", a)   // 1010  占位符%b表示二进制
	fmt.Printf("%o \n", a)   // 12    占位符%o表示八进制
	fmt.Printf("%d \n", a)   // 10    占位符%d表示十进制
	fmt.Printf("0x%x \n", a) // 0xa  占位符%x表示十六进制

	// 八进制(以0开头)
	var b int = 077
	fmt.Printf("%b \n", b)   // 111111
	fmt.Printf("%o \n", b)   // 77
	fmt.Printf("%d \n", b)   // 63
	fmt.Printf("0x%x \n", b) // 0x3f

	// 十六进制(以0x开头)
	var c int = 0xff
	fmt.Printf("0x%x \n", c) // 0xff
	fmt.Printf("0X%X \n", c) // 0xFF

	// 数字字面量语法（Number literals syntax）
	binary := 0b1111
	octal := 0o17
	digital := 15
	hexadecimal := 0xf
	specialhexa := 0x8p-2 // 8 / 2^2 = 2
	underline := 10_24

	fmt.Printf("binary : %b , digital ： %d\n", binary, binary)
	fmt.Printf("octal : %o , digital ： %d\n", octal, octal)
	fmt.Printf("digital type (变量类型): %T,digital ： %d\n", digital, digital)
	fmt.Printf("hexadecimal : %x, digital ： %d, specialhexa : %f\n", hexadecimal, hexadecimal, specialhexa)
	fmt.Printf("underline : %d \n", underline)
}

// 浮点型
func floatdemo() {
	var floatnumber float64 = 1024.00
	fmt.Printf("数据类型: %T , floatnumber: %.1f\n", floatnumber, floatnumber)
	fmt.Printf("%f,%.2f\n", math.Pi, math.Pi) // 保留小数点后两位
	fmt.Printf("float32的浮点数的最大范围 :%d ~ %f\n", 0, math.MaxFloat32)
	fmt.Printf("float64的浮点数的最大范围 :%d ~ %f\n", 0, math.MaxFloat64)
}

// 复数类型
func complexdemo() {
	var c1 complex64
	c1 = 1 + 2i
	var c2 complex128
	c2 = 2 + 3i
	fmt.Println(c1)
	fmt.Println(c2)
}

// 字符串型示例
func stringdemo() {
	// 字符
	c1 := 'a'
	c2 := 'A'

	// 字符串 (单行与多行以及转义)
	s1 := "Name"
	s2 := "姓名"
	s3 := `
	这是一个 
	      多行字符串案例！
	This is mutlilineString Example！
	Let's Go   // 特点：原样输出
	`
	// 转义演示
	s4 := "'c:\\weiyigeek\\go\\hello'"
	s5 := `c:\weiyigeek\go\hello`

	fmt.Printf("c1 char : %c,\t c2 char %c -> digital : %d\n", c1, c2, c2)
	fmt.Println(s1, s2)
	fmt.Println(s3)
	fmt.Println(s4, s5)

	// 字符串常用函数
	fmt.Println("s1 String length:", len(s1), "s2 string length:", len(s2))

	info := fmt.Sprintf("%s (%s): %s", s1, s2, "WeiyiGeek")
	fmt.Println("Infomation : "+"个人信息", info)

	fmt.Println("字符串分割 :", strings.Split(s5, "\\"))

	fmt.Println("判断字符串是否包含go", strings.Contains(s3, "go"))

	fmt.Println(strings.HasPrefix(s1, "N"), strings.HasSuffix(s1, "e"))

	fmt.Println(strings.Index(s4, "weiyigeek"), strings.LastIndex(s4, "weiyigeek"))

	s6 := strings.Split(s5, "\\")
	fmt.Println("字符串间隔符 : ", strings.Join(s6, "-"))
}

// Byte与Rune类型示例
func brdemo() {
	var c1 = 'a' // int32 类型
	var c2 = 'A' // int32 类型
	z1 := '中'    // int32 类型
	z2 := '文'    // int32 类型
	z3 := "中"    // string 类型 (双引号)

	// 字符不同格式输出
	fmt.Printf("字符 ：%d (%c) , %d (%c) \n", c1, c1, c2, c2)
	fmt.Printf("中文字符 ：%d (%v) = %c , %d (%v) = %c \n", z1, z1, z1, z2, z2, z2)
	fmt.Printf("单双引号不同类型 : c1 = %c (%T) , z2 = %c (%T) ,  z3 = %s (%T) \n", c1, c1, z2, z2, z3, z3)

	// 中英文字符串修改
	s1 := "a和我都爱中国"
	s2 := "为 Hello 中国 World,Go 语言 学习"

	// 将字符类型转化为byte类型
	c3 := byte(c2)
	fmt.Printf("强制转化类型 : c2 = %c (%T) , byte(c2) = %c (%T) \n", c2, c2, c3, c3)

	// 将字符串类型转化为string类型
	r1 := []rune(s1) // 强制转化字符串为一个rune切片
	r1[0] = '您'      // 注意此处需传入为字符
	fmt.Println("修改后中文字符串输出(未类型转换)：", r1)
	fmt.Println("修改后中文字符串输出(已类型转换)：", s1, string(r1)) // 强制转化rune切片为字符串

	// 将整型转化成为浮点数类型
	// 计算直角三角形的斜边长
	var a, b = 3, 4
	var c int = int(math.Sqrt(float64(a*a + b*b)))
	fmt.Println("计算直角三角形的斜边长 (a=3,b=4) c =", c)

	// 统计字符串中中文个数
	res := []rune(s2)
	reslen := len(res)
	count := 0
	for i := 0; i < reslen; i++ {
		if res[i] > 255 {
			count++
		}
	}
	fmt.Printf("字符串:%s (Length = %d),一共有 %d 个中文字符", s2, reslen, count)
}

func main() {
	fmt.Println("# 1.整型示例:")
	// intdemo()
	fmt.Println("# 2.浮点型示例:")
	// floatdemo()
	fmt.Println("# 3.复数型示例:")
	// complexdemo()
	fmt.Println("# 4.布尔型示例:")
	// var flag bool = true
	// fmt.Printf("数据类型: %T ,任意类型输出: %v", flag, flag)
	fmt.Println("# 5.字符串型示例:")
	//stringdemo()
	fmt.Println("# 6.Byte与Rune型示例:")
	brdemo()
}
