package mlogger

import (
	"errors"
	"fmt"
	"path"
	"runtime"
	"strings"
	"time"
)

// 1.自定义日志库等级
type Loglevel uint8

const (
	UNKNOWN Loglevel = iota
	DEBUG
	TRACE
	INFO
	WARNING
	ERROR
	FATAL
)

// 2.解析日志等级方法
func parseLogLevel(s string) (Loglevel, error) {
	s = strings.ToUpper(s)
	switch s {
	case "DEBUG":
		return DEBUG, nil
	case "TRACE":
		return TRACE, nil
	case "INFO":
		return INFO, nil
	case "WARNING":
		return WARNING, nil
	case "ERROR":
		return ERROR, nil
	case "FATAL":
		return FATAL, nil
	default:
		// 主意不能以标点符号来结束错误信息抛出
		err := errors.New("无效的日志级别-Log Levels Error")
		return UNKNOWN, err
	}
}

// 3.ConsoleLogger结构体
type ConsoleLogger struct {
	level Loglevel
}

// 4.ConsoleLogger结构体构造方法
func NewConsoleLog(level string) ConsoleLogger {
	logLevel, err := parseLogLevel(level)
	if err != nil {
		fmt.Print(err)
	}
	// 返回ConsoleLogger结构体对象
	return ConsoleLogger{
		level: logLevel,
	}
}

// 5.解析日志等级字符串名称
func getLevelName(lv Loglevel) string {
	switch lv {
	case DEBUG:
		return "DEBUG"
	case TRACE:
		return "TRACE"
	case INFO:
		return "INFO"
	case WARNING:
		return "WARNING"
	case ERROR:
		return "ERROR"
	case FATAL:
		return "FATAL"
	default:
		return "UNKNOWN"
	}
}

// 6.获取错误的函数名 文件 以及 行号的方法
func getFileLine(skip int) (funcName, fileName string, lineNum int) {
	pc, fileName, lineNum, ok := runtime.Caller(skip)
	if !ok {
		fmt.Printf("Runtime,Caller() failed\n")
	}
	funcName = runtime.FuncForPC(pc).Name()
	fileName = path.Base(fileName)
	funcName = strings.Split(funcName, ".")[1]
	return
}

// 7.日志显示的等级(当前日志级别大传入的日志级别则显示)
func (l ConsoleLogger) enable(Loglevel Loglevel) bool {
	return Loglevel >= l.level
}

// 8.向终端打印日志的方法
func printLogs(lv, format string, custom ...interface{}) {
	// 错误信息拼接
	msg := fmt.Sprintf(format, custom...)

	// 时间&时区
	now := time.Now()
	//timezone, _ := time.LoadLocation("Asia/Shanghai")

	// 错误文件以及函数名称
	funcName, fileName, linwNum := getFileLine(2)

	fmt.Printf("[%s] [%s] [%s:%s:%d] %s \n", now.Format("2006-01-02 15:04:05"), lv, fileName, funcName, linwNum, msg)
}

// 9.各日志等级打印
// Debug
func (l ConsoleLogger) Debug(format string, custom ...interface{}) {
	// 满足等级则打印日志
	// custom 可变参数,其底层是切片
	if l.enable(DEBUG) {
		printLogs("DEBUG", format, custom...)
	}
}

// Trace
func (l ConsoleLogger) Trace(format string, custom ...interface{}) {
	// 满足等级则打印日志
	if l.enable(TRACE) {
		printLogs("TRACE", format, custom...)
	}
}

// Info
func (l ConsoleLogger) Info(format string, custom ...interface{}) {
	// 满足等级则打印日志
	if l.enable(INFO) {
		printLogs("INFO", format, custom...)
	}
}

// Error
func (l ConsoleLogger) Error(format string, custom ...interface{}) {
	// 满足等级则打印日志
	if l.enable(ERROR) {
		printLogs("ERROR", format, custom...)
	}
}

// Warning
func (l ConsoleLogger) Warning(format string, custom ...interface{}) {
	// 满足等级则打印日志
	if l.enable(WARNING) {
		printLogs("WARNING", format, custom...)
	}
}

// Falat
func (l ConsoleLogger) Falat(format string, custom ...interface{}) {
	// 满足等级则打印日志
	if l.enable(FATAL) {
		printLogs("FATAL", format, custom...)
	}
}

// 方法接口定义
type Logger interface {
	Debug(format string, custom ...interface{})
	Trace(format string, custom ...interface{})
	Info(format string, custom ...interface{})
	Warning(format string, custom ...interface{})
	Error(format string, custom ...interface{})
	Falat(format string, custom ...interface{})
}
