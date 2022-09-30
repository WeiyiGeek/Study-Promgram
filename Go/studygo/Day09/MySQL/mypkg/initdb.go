package mypkg

import (
	"database/sql"
	"fmt"

	_ "github.com/go-sql-driver/mysql"
)

// 定义一个mysqlObj结构体
type MysqlObj struct {
	Mysql_host             string
	Mysql_port             uint16
	Mysql_user, Mysql_pass string
	Database               string
	Db                     *sql.DB
}

// 定一个Person结构体
type Person struct {
	Uid  int
	Name string
	Age  int
}

// 定义一个初始化数据库的函数
func (conn *MysqlObj) InitDB() (err error) {

	// DSN(Data Source Name) 数据库连接字符串
	// MySQL 5.7.X 与 MySQL 8.x 都是支持的
	dsn := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=utf8mb4&parseTime=True", conn.Mysql_user, conn.Mysql_pass, conn.Mysql_host, conn.Mysql_port, conn.Database)

	// 注册第三方mysql驱动到sql中，此处并不会校验账号密码是否正确，此处赋值给全局变量db。
	conn.Db, err = sql.Open("mysql", dsn)
	if err != nil {
		fmt.Printf("DSN : %s Format failed\n%v \n", dsn, err)
		return err
	}

	// 尝试与数据库建立连接（校验DSN是否正确）
	err = conn.Db.Ping()
	if err != nil {
		fmt.Printf("Connection %s Failed,\n%v \n", dsn, err)
		return err
	}

	// 设置与数据库建立连接的最大数目
	conn.Db.SetMaxOpenConns(1024)

	// 设置连接池中的最大闲置连接数
	conn.Db.SetMaxIdleConns(0) // 不会保留闲置

	return nil
}
