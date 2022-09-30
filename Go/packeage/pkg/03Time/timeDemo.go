package main

import (
	"fmt"
	"time"
)

func demo1() {
	// 获取当前时间
	now := time.Now()

	// 输出当前时间
	fmt.Printf("Current Time is ：%v, \nUTC Time is: %v\n", now.Local(), now.UTC())

	// 分别获取当前时间的年月日/时分秒
	year := now.Year()     //年
	month := now.Month()   //月
	day := now.Day()       //日
	hour := now.Hour()     //小时
	minute := now.Minute() //分钟
	second := now.Second() //秒
	y, m, d := now.Date()  //年月日
	week := now.Weekday()  //周
	fmt.Printf("Current Time Format: %d-%02d-%02d %02d:%02d:%02d\n", year, month, day, hour, minute, second)
	fmt.Printf("Year : %d ,Month : %v ,Day : %d ,WeekDay : %v\n", y, m, d, week)
}

func demo2() {
	//获取当前时间
	now := time.Now()
	timestamp1 := now.Unix()     //时间戳
	timestamp2 := now.UnixNano() //纳秒时间戳
	fmt.Printf("current timestamp : %v\n", timestamp1)
	fmt.Printf("current timestamp nanosecond: %v\n", timestamp2)

	//将时间戳转为时间格式(秒数，纳秒数)
	timeObj := time.Unix(timestamp1, 0)
	fmt.Println("时间戳转换后的时间 :", timeObj)
	year := timeObj.Year()     //年
	month := timeObj.Month()   //月
	day := timeObj.Day()       //日
	hour := timeObj.Hour()     //小时
	minute := timeObj.Minute() //分钟
	second := timeObj.Second() //秒
	fmt.Printf("格式化后 ：%d-%02d-%02d %02d:%02d:%02d\n", year, month, day, hour, minute, second)
}

func demo3() {
	fmt.Println(time.Nanosecond)
	fmt.Println(time.Microsecond)
	fmt.Println(time.Millisecond)
	fmt.Println(time.Second)
	fmt.Println(time.Minute)
	fmt.Println(time.Hour)
}

func demo4() {
	// UTC & CST & 本地时间 并返回与t关联的时区信息。
	now := time.Now()
	fmt.Printf("UTC 世界协调时间 : %v,时区信息: %v\n", now.UTC(), now.UTC().Location())

	var cst = time.FixedZone("CST", 0)
	cstnow := time.Now().In(cst)
	fmt.Printf("CST 中部标准时间 : %v,时区信息: %v\n", cstnow, cstnow.Location())

	fmt.Printf("将UTC时间转化为当地时间 : %v,时区信息: %v\n\n", now.Local(), now.Location())

	// 中国北京时间东八区
	// 方式1.FixedZone
	var utcZone = time.FixedZone("UTC", 8*3600)
	fmt.Printf("北京时间 : %v\n", now.In(utcZone))
	// 方式2.LoadLocation 设置地区
	var cstZone, _ = time.LoadLocation("Asia/Shanghai") //上海
	fmt.Printf("北京时间 : %v\n", now.In(cstZone))

	// 输出当前格林威治时间和该时区相对于UTC的时间偏移量（单位秒）
	name, offset := now.In(utcZone).Zone()
	fmt.Println("当前时间时区名称:", name, " 对于UTC的时间偏移量:", offset)
}

func demo5() {
	now := time.Now()
	// 1.求一个小时之后的时间
	later := now.Add(time.Hour)         // 当前时间加1小时后的时间
	tomorrow := now.Add(time.Hour * 24) // 当前时间加1天后的时间
	fmt.Println("later :", later, "\ntomorrow: ", tomorrow)
	// 2.当前时间与later的差值
	fmt.Println("Sub :", now.Sub(later))
	// 3.当前时间与later是否相等
	fmt.Println("Equal :", now.Equal(later))
	// 4.当前时间是否在later之前
	fmt.Println("Before :", now.Before(later))
	// 5.当前时间是否在later之后
	fmt.Println("After :", now.After(later))
}

func demo6() {
	// 定义一个1秒间隔(Duration)的定时器
	ticker := time.Tick(time.Second)
	for i := range ticker {
		fmt.Println(i)              //每秒都会执行的任务
		time.Sleep(time.Second * 5) //休眠5S执行
	}
}

func demo7() {
	// 当前UTC时间
	now := time.Now()
	// 设置时区为Asia/Shanghai
	loc, err := time.LoadLocation("Asia/Shanghai")
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("北京时间 :", now.In(loc), "\n地点时区 :", loc)

	// 1.时间格式化
	fmt.Println("格式1 :", now.Format("2006/01/02"))
	fmt.Println("格式2 :", now.Format("2006/01/02 15:04"))
	fmt.Println("格式3 :", now.Format("15:04 2006/01/02"))

	// 24小时制
	fmt.Println("格式4 :", now.Format("2006-01-02 15:04:05.000 Mon Jan"))

	// 12小时制
	fmt.Println("格式5 :", now.Format("2006-01-02 03:04:05.000 PM"))
	fmt.Println("格式6 :", now.Format("2006-01-02 03:04:05.000 PM Mon Jan"))
	fmt.Println("Kitchen 格式 :", now.Format(time.Kitchen))

	// 时区展示
	fmt.Println("RFC1123 格式 :", now.Format(time.RFC1123))
	fmt.Println("RFC1123 格式 :", now.Format(time.RFC1123Z))
	fmt.Println("RFC3339 格式 :", now.Format(time.RFC3339))
	fmt.Println("RFC3339Nano 格式 :", now.Format(time.RFC3339Nano))
}

func demo8() {
	// 1.时间与时区设置
	now := time.Now()
	loc, _ := time.LoadLocation("Asia/Shanghai")
	// 2.按照指定时区和指定格式解析字符串时间
	timeObj1, _ := time.Parse("2006-01-02 15:04:05", "2021-09-27 14:15:20")
	timeObj2, _ := time.ParseInLocation("2006/01/02 15:04:05", "2021/09/27 14:15:20", time.Local) // 操作系统本地时区
	timeObj3, _ := time.ParseInLocation("2006/01/02 15:04:05", "2021/09/27 14:15:20", loc)        // 指定时区

	fmt.Printf("Now: %v\ntimeObj1: %v\ntimeObj2: %v\ntimeObj3: %v\n", now.Local(), timeObj1, timeObj2, timeObj3)

	// 将当地时区转化为UTC时间
	utcLocal := timeObj3.UTC()
	fmt.Println("将当地时区转化为UTC时间:", utcLocal)
	// 将UTC时间转化为当地时间(+8)
	localTime := utcLocal.Local()
	fmt.Println("将UTC时间转化为当地时间:", localTime)

	// 3.相互转换后的时间进行对比.
	fmt.Println("相互转换后的时间进行对比:", utcLocal.Equal(localTime))

	// 4.输入的时间字符串与当前时间的相差时间.
	d := timeObj3.Sub(now)
	// 可以看到timeObj 时间 与 当前时间 相差 33 分钟 55 秒
	fmt.Println("看到timeObj3 时间 与 当前时间 相差:", d.String())
}

func main() {
	//demo1()
	//demo2()
	//demo3()
	//demo4()
	//demo5()
	//demo6()
	//demo7()
	demo8()
}
