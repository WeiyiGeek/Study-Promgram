package mlogger

// 主要向文件里写入日志相关信息

import (
	"fmt"
	"os"
	"path"
	"time"
)

// 1.文件记录日志结构体
type FileLogger struct {
	level       Loglevel
	filePath    string
	fileName    string
	fileObj     *os.File
	errFileObj  *os.File
	maxFileSize int64
}

// 2.文件日志构造方法
func NewFileLogger(levelStr, fp, fn string, maxSize int64) *FileLogger {
	// 解析日志等级
	Loglevel, err := parseLogLevel(levelStr)
	if err != nil {
		panic(err)
	}

	// 文件日志结构体对象
	fobj := &FileLogger{
		level:       Loglevel,
		filePath:    fp,
		fileName:    fn,
		maxFileSize: maxSize,
	}

	// 初始化文件日志文件句柄
	initErr := fobj.init()
	if initErr != nil {
		panic(initErr)
	}

	// 返回对象
	return fobj
}

// 3.文件日志显示的等级控制方法(当前日志级别大传入的日志级别则显示)
func (f FileLogger) enable(Loglevel Loglevel) bool {
	return Loglevel >= f.level
}

// 4.初始化文件日志文件句柄方法
func (f *FileLogger) init() error {
	// 通用日志名称与错误日志名称路径拼接
	fullName := path.Join(f.filePath, f.fileName) + ".logs"
	fullErrName := path.Join(f.filePath, f.fileName) + ".err.logs"

	// 创建文件句柄并
	fileObj, err := os.OpenFile(fullName, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Printf("Open Logs file failed, err : %v \n", err)
		return err
	}

	errFileObj, err := os.OpenFile(fullErrName, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Printf("Open Error logs file failed, err : %v \n", err)
		return err
	}

	// 赋值其对象
	f.fileObj = fileObj
	f.errFileObj = errFileObj
	return nil
}

// 5.验证文件的大小方法
func (f *FileLogger) checkFileSize(file *os.File) bool {
	// 文件信息返回的是结构体
	fileInfo, err := file.Stat()
	if err != nil {
		fmt.Printf("checkFileSize - Get file info failed, err : %v \n", err)
		return false
	}
	// 如果当前文件的大小值大于返回True,则进行切割
	if fileInfo.Size() > f.maxFileSize {
		return true
	}
	return false
}

// 6.进行日志文件的切割方法
func (f *FileLogger) SplitFile(file *os.File) (*os.File, error) {
	// 1) 获取文件句柄信息并关闭当前日志文件
	fileInfo, err := file.Stat()
	if err != nil {
		fmt.Printf("SplitFile - Get file info failed, err : %v \n", err)
		return nil, err
	}
	nowStr := time.Now().Format("2006-01-02_150405")
	LogName := path.Join(f.filePath, fileInfo.Name())
	newLogName := fmt.Sprintf("%s.bak.%s", LogName, nowStr)
	file.Close()

	// 2) 备份并重命名日志文件
	os.Rename(LogName, newLogName)

	// 3) 重新打开一个新的日志文件
	fileObj, err := os.OpenFile(LogName, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Printf("Open New Logs file failed, err : %v \n", err)
		return nil, err
	}

	// 4) 将对象进行返回
	return fileObj, nil
}

// 7.将日志分别打印进对应的文件之中
func (f *FileLogger) printLogs(level Loglevel, format string, custom ...interface{}) error {
	// 1) 判断日志等级是否满足指定等级之上的要求
	if f.enable(level) {
		// 2) 异常信息
		msg := fmt.Sprintf(format, custom...)

		// 3) 时间与时区
		now := time.Now()
		//timezone, _ := time.LoadLocation("Asia/Shanghai")

		// 4) 异常文件函数信息
		funcName, fileName, linwNum := getFileLine(2)

		// 5) 通用日志文件切割判断及输入
		if f.checkFileSize(f.fileObj) {
			f.fileObj, _ = f.SplitFile(f.fileObj)
		}
		fmt.Fprintf(f.fileObj, "[%s] [%s] [%s:%s:%d] %s \n", now.Format("2006-01-02 15:04:05"), getLevelName(level), fileName, funcName, linwNum, msg)

		// 6) 严重与错误日志文件切割判断及输入
		if level >= ERROR {
			if f.checkFileSize(f.errFileObj) {
				f.errFileObj, _ = f.SplitFile(f.errFileObj)
			}
			fmt.Fprintf(f.errFileObj, "[%s] [%s] [%s:%s:%d] %s \n", now.Format("2006-01-02 15:04:05"), getLevelName(level), fileName, funcName, linwNum, msg)
		}
	}
	return nil
}

// 8.日志等级调用分别方法
// Debug
func (f *FileLogger) Debug(format string, custom ...interface{}) {
	f.printLogs(DEBUG, format, custom...)
}

// Trace
func (f *FileLogger) Trace(format string, custom ...interface{}) {
	f.printLogs(TRACE, format, custom...)
}

// Info
func (f *FileLogger) Info(format string, custom ...interface{}) {
	f.printLogs(INFO, format, custom...)
}

// Error
func (f *FileLogger) Error(format string, custom ...interface{}) {
	f.printLogs(ERROR, format, custom...)
}

// Warning
func (f *FileLogger) Warning(format string, custom ...interface{}) {
	f.printLogs(WARNING, format, custom...)
}

// Falat
func (f *FileLogger) Falat(format string, custom ...interface{}) {
	f.printLogs(FATAL, format, custom...)
}

func (f *FileLogger) Close() {
	f.fileObj.Close()
	f.errFileObj.Close()
}
