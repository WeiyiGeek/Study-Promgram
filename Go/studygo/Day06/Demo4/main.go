package main

import (
	"errors"
	"fmt"
	"io/ioutil"
	"os"
	"reflect"
	"strconv"
	"strings"
)

// mysql 数据库配置结构体
type mysqlConfig struct {
	Address  string `ini:"address"`
	Port     int    `ini:"port"`
	Username string `ini:"username"`
	Password string `ini:"password"`
}

// redis 数据库配置结构体
type redisConfig struct {
	Host     string `ini:"host"`
	Port     int    `ini:"port"`
	Password string `ini:"password"`
	Database string `ini:"database"`
	Test     bool   `ini:"test"`
}

// 结构体嵌套
type Config struct {
	mysqlConfig `ini:"mysql"`
	redisConfig `ini:"redis"`
}

func loadFileConfig(data interface{}, configfile string) (err error) {
	// (1) 参数校验
	t := reflect.TypeOf(data)
	fmt.Println("参数校验:", t, t.Kind(), t.Elem().Kind())

	// 传递的data参数必须是指针类型(因为需要在函数中对其赋值)
	if t.Kind() != reflect.Ptr {
		// err = fmt.Errorf("[Error] 传递的data参数必须是指针类型") //  不能以标点符号结尾以及输入大写字符开头
		err = errors.New("data Param should be a [pointer] type") //  不能以标点符号结尾以及输入大写字符开头
		return
	}
	// 传递来data参数还必须是结构体类型的指针(因为配置文件中各种键值对需要赋予给结构体字段)
	if t.Elem().Kind() != reflect.Struct {
		err = errors.New("data Param should be a [struct pointer] type") //  不能以标点符号结尾以及输入大写字符开头
		return
	}

	// (2) 读文件得到字节类型的数据
	ini, err := ioutil.ReadFile(configfile)
	if err != nil {

		return
	}
	// 将文件内容转换为字符串,并按照每行指定字符串进行切割(Linux: '\n', WIN: '\r\n')
	lineSlice := strings.Split(string(ini), "\n")

	// 读取每行数据并且提取对于数据到传递的对象之中
	var structName string
	for index, line := range lineSlice {
		// 取消配置中的空格
		line = strings.TrimSpace(line)

		// 注释判断
		if strings.HasPrefix(line, ";") || strings.HasPrefix(line, "#") {
			continue
		}

		// 空行判断
		if len(line) == 0 {
			continue
		}

		// 节[section]判断
		if strings.HasPrefix(line, "[") {
			// 判断尾
			if !strings.HasSuffix(line, "]") {
				err = fmt.Errorf("configini Line:%d Syntax Error", index+1) // 不能以标点符号结尾以及输入大写字符开头
				return
			}
			// 过滤[]中包含的空格，如果长度为0则表示格式错误，否则拿到节内容
			sectionName := strings.TrimSpace(line[1 : len(line)-1])
			if len(sectionName) == 0 {
				err = fmt.Errorf("configini Line:%d Syntax Error", index+1) // 不能以标点符号结尾以及输入大写字符开头
				return
			}

			// 根据[]中包含的字符串其data参数根据反射找对应结构体
			for i := 0; i < t.Elem().NumField(); i++ { // t.Elem() 拿取指针中的元素
				field := t.Elem().Field(i)
				if sectionName == field.Tag.Get("ini") {
					// 记录对应的嵌套结构体的字段名称
					structName = field.Name
					fmt.Printf("[+] 找到%s对应的嵌套结构体: %s\n", sectionName, structName)
					continue
				}
			}

		} else {
			// 如果不是以 [  开头的行意味是将值对，配置文件 Key=value 判断与赋值给我们定义的结构体
			// 格式判断
			if !strings.Contains(line, "=") || strings.HasPrefix(line, "=") {
				err = fmt.Errorf("configini Line:%d Syntax Error", index+1) // 不能以标点符号结尾以及输入大写字符开头
				return
			}

			// 取出ini中每一行的数据key=value
			equalIndex := strings.Index(line, "=")
			key := strings.TrimSpace(line[:equalIndex])
			value := strings.TrimSpace(line[equalIndex+1:])

			// 根据 structName 名称去data匿名把对应嵌套的结构体信息取出
			v := reflect.ValueOf(data)                 // 反射取值
			sValue := v.Elem().FieldByName(structName) // 嵌套结构体值信息
			sType := sValue.Type()                     // 嵌套结构体类型信息

			if sValue.Kind() != reflect.Struct {
				err = fmt.Errorf("[-] data 中 %s 字段应该是一个结构体", structName) // 不能以标点符号结尾以及输入大写字符开头
				return
			}

			// 遍历嵌套结构体中每一个字段，判断Tag是否等于Key。
			var fieldName string
			var fieldType reflect.StructField
			for i := 0; i < sValue.NumField(); i++ {
				field := sType.Field(i) // 反射类型信息中存储了嵌套结构体中的Tag信息
				fieldType = field       // 反射类型信息中存储了嵌套结构体中的filed信息以供后续值类型判断使用
				if field.Tag.Get("ini") == key {
					// 找到结构体中对应的字段
					fieldName = field.Name
					break
				}
			}

			// 如果字段名称不存在嵌套结构体中则跳过
			if len(fieldName) == 0 {
				continue
			}

			// 如果key等于tag就给该字段赋值
			fieldObj := sValue.FieldByName(fieldName)
			fmt.Println(fieldName, fieldType.Type.Kind())
			// 将读取对应的字符串转为结构体字段中对应的值的类型，并将其赋予。
			switch fieldType.Type.Kind() {
			case reflect.String:
				fieldObj.SetString(value) // 注意点
			case reflect.Int, reflect.Int8, reflect.Int16, reflect.Int32, reflect.Int64:
				var valueInt int64                              // 注意点
				valueInt, err = strconv.ParseInt(value, 10, 64) // 类型转换
				if err != nil {
					fmt.Printf("configini Line:%d value type error,msg: %s", index+1, err)
					return
				}
				fieldObj.SetInt(valueInt)
			case reflect.Float32, reflect.Float64:
				var valueFloat float64                          // 注意点
				valueFloat, err = strconv.ParseFloat(value, 64) // 类型转换
				if err != nil {
					fmt.Printf("configini Line:%d value type error,msg: %s", index+1, err)
					return
				}
				fieldObj.SetFloat(valueFloat)

			case reflect.Bool:
				var valueBool bool                        // 注意点
				valueBool, err = strconv.ParseBool(value) // 类型转换
				if err != nil {
					fmt.Printf("configini Line:%d value type error,msg: %s", index+1, err)
					return
				}
				fieldObj.SetBool(valueBool)
			}
		}
	}
	return
}

func main() {
	var cfg Config
	err := loadFileConfig(&cfg, "./config.ini")
	if err != nil {
		fmt.Println("[Error] Load File Config Failed")
		os.Exit(1)
	}
	fmt.Printf("嵌套结构体对象值: %v \n", cfg)
	fmt.Printf("嵌套结构体对象类型与值: %#v \n", cfg)

}
