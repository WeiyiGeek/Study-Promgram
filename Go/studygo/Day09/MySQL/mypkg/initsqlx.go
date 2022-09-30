package mypkg

import (
	"fmt"

	"github.com/jmoiron/sqlx"
)

// 定义一个MysqlObj结构体
type SqlObj struct {
	Mysql_host             string
	Mysql_port             uint16
	Mysql_user, Mysql_pass string
	Database               string
	DB                     *sqlx.DB
}

// 定一个Person结构体
type User struct {
	Uid  int
	Name string
	Age  int
}

func (conn *SqlObj) InitDB() (err error) {
	// DSN(Data Source Name) 数据库连接字符串。
	dsn := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=utf8mb4&parseTime=True", conn.Mysql_user, conn.Mysql_pass, conn.Mysql_host, conn.Mysql_port, conn.Database)

	// 注册第三方mysql驱动到sqlx中并连接到数据库中。
	conn.DB, err = sqlx.Connect("mysql", dsn)
	if err != nil {
		fmt.Printf("Connect %s DB Failed\n%v \n", dsn, err)
		return err
	}

	// 设置与数据库建立连接的最大数目
	conn.DB.SetMaxOpenConns(1024)

	// 设置连接池中的最大闲置连接数
	conn.DB.SetMaxIdleConns(10)

	return nil
}
