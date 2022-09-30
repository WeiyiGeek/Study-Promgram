package main

import (
	"database/sql"
	"fmt"

	"weiyigeek.top/studygo/Day09/MySQL/mypkg"
)

// ## 事务操作示例
func transactionDemo(conn *sql.DB, money int) {
	// 开启事务
	tx, err := conn.Begin()
	if err != nil {
		if tx != nil {
			tx.Rollback() // 回滚
		}
		fmt.Printf("begin trans failed, err:%v\n", err)
		return
	}

	// (1) A 用户转账 50 给 B 则 - 50
	sqlStr1 := "UPDATE `money` SET balance=balance-? WHERE id=?;"
	ret1, err := tx.Exec(sqlStr1, money, 1)
	if err != nil {
		tx.Rollback() // 回滚
		fmt.Printf("exec sql1 failed, err:%v\n", err)
		return
	}
	affRow1, err := ret1.RowsAffected()
	if err != nil {
		tx.Rollback() // 回滚
		fmt.Printf("exec ret1.RowsAffected() failed, err:%v\n", err)
		return
	}

	// B 用户接收到 A 转账的 50 给 则 + 50
	sqlStr2 := "UPDATE `money` SET balance=balance+? WHERE id=?;"
	ret2, err := tx.Exec(sqlStr2, money, 2)
	if err != nil {
		tx.Rollback() // 回滚
		fmt.Printf("exec sql2 failed, err:%v\n", err)
		return
	}
	affRow2, err := ret2.RowsAffected()
	if err != nil {
		tx.Rollback() // 回滚
		fmt.Printf("exec ret1.RowsAffected() failed, err:%v\n", err)
		return
	}

	// 事务处理影响行数判断是否修改成功
	fmt.Println("事务处理影响行数判断是否修改成功: ", affRow1, affRow2)
	if affRow1 == 1 && affRow2 == 1 {
		fmt.Println("事务正在提交啦...")
		tx.Commit() // 提交事务
	} else {
		tx.Rollback()
		fmt.Println("事务回滚啦...")
	}

	fmt.Println("[INFO] - 事务完成了 ，exec trans success!")
}

func main() {
	// (1) MysqlObj 结构体初始化
	conn := &mypkg.MysqlObj{
		Mysql_host: "10.20.172.248",
		Mysql_port: 3306,
		Mysql_user: "root",
		Mysql_pass: "weiyigeek.top",
		Database:   "test",
	}

	// (2) 数据库初始化
	err := conn.InitDB()
	if err != nil {
		panic(err)
	} else {
		fmt.Println("[INFO] - 已成功连接到数据库!")
	}
	// 关闭数据库对象
	defer conn.Db.Close()

	// (3) 简单的事务操作示例
	transactionDemo(conn.Db, 50)
}
