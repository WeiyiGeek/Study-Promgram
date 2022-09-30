// Go 语言利用 MySQL Driver 连接 MySQL 示例
package main

import (
	"database/sql"
	"fmt"

	_ "github.com/go-sql-driver/mysql"
)

// 定义一个全局对象db
var db *sql.DB

// 定义一个初始化数据库的函数
func initDB() (err error) {

	// DSN(Data Source Name) - 数据库连接数据源
	// MySQL 5.7.X 与 MySQL 8.x 都是支持的
	dsn := "root:www.weiyigeek.top@tcp(10.20.172.248:3306)/test?charset=utf8&parseTime=True"

	// 注册第三方mysql驱动到sql中，此处并不会校验账号密码是否正确，此处赋值给全局变量db。
	db, err = sql.Open("mysql", dsn)
	if err != nil {
		fmt.Printf("DSN : %s Format failed\n%v \n", dsn, err)
		return err
	}

	// 设置与数据库建立连接的最大数目
	db.SetMaxOpenConns(1024)

	// 设置连接池中的最大闲置连接数
	db.SetMaxIdleConns(0) // 不会保留闲置

	// 尝试与数据库建立连接（校验DSN是否正确）
	err = db.Ping()
	if err != nil {
		fmt.Printf("Connection %s Failed,\n%v \n", dsn, err)
		return err
	}

	fmt.Println("数据库初始化连接成功!")

	return nil
}

func main() {
	// 调用输出化数据库的函数
	err := initDB()
	defer db.Close()

	if err != nil {
		fmt.Println("Database Init failed!")
		return
	}
}
