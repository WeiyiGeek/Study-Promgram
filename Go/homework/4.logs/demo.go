package main

/**自定义日志库调用演示入口**/

import (
	"time"

	"weiyigeek.top/packeage/mlogger"
)

// 示例1.向终端中进行日志信息的打印
func demo1() {
	log := mlogger.NewConsoleLog("Debug")
	for {
		log.Debug("Debug 日志: %s", "Deveploment Debug")
		log.Trace("Trace 日志: %s", "Deveploment Trace")
		log.Info("Info 日志: %s,%d", "Production Info", 1024)
		log.Warning("Warning 日志: %s", "Production Warning")
		log.Error("Error 日志: %s", "Production Error")
		log.Falat("Falat 日志: %s", "Production Falat")
		time.Sleep(time.Second * 1)
	}
}

// 示例2.将日志信息输入到文件之中
func demo2() {
	log := mlogger.NewFileLogger("INFO", "./", "weiyigeek", 5*1024)
	for {
		log.Debug("Debug 日志: %s", "FileLogger - 开发环境日志基级别 Debug")
		log.Trace("Trace 日志: %s", "FileLogger - 开发环境日志基级别 Trace")
		log.Info("Info 日志: %s,%d", "FileLogger - 生产环境日志基级别 Info", 1024)
		log.Warning("Warning 日志: %s", "FileLogger - 生产环境日志基级别 Warning")
		log.Error("Error 日志: %s", "FileLogger - 生产环境日志基级别 Error")
		log.Falat("Falat 日志: %s", "FileLogger - 生产环境日志基级别 Falat")
		time.Sleep(time.Second * 1)
	}
}

func main() {
	//demo1()
	demo2()
}
