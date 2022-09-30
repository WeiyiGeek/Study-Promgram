package main

import (
	"database/sql"
	"fmt"

	db "weiyigeek.top/studygo/Day09/MySQL/mypkg"
)

// ## 预处理查询示例函数
func prepareQuery(conn *sql.DB, id int) {
	// SQL语句
	sqlStr := "select uid,name,age from user where uid > ?;"
	// 预处理
	stmt, err := conn.Prepare(sqlStr)
	if err != nil {
		fmt.Printf("prepare failed, err:%v\n", err)
		return
	}
	// 释放预处理
	defer stmt.Close()

	// 查询 uid 为 id 以上的数据
	rows, err := stmt.Query(id)
	if err != nil {
		fmt.Printf("query failed, err:%v\n", err)
		return
	}
	// 释放 rows
	defer rows.Close()

	// 循环读取结果集中的数据
	res := make(map[int]db.Person, 5)
	for rows.Next() {
		var u db.Person
		err := rows.Scan(&u.Uid, &u.Name, &u.Age)
		if err != nil {
			fmt.Printf("scan failed, err:%v\n", err)
			return
		}
		_, ok := res[u.Uid]
		if !ok {
			res[u.Uid] = u
		}
		fmt.Printf("id:%d name:%s age:%d\n", u.Uid, u.Name, u.Age)
	}
	fmt.Printf("%#v\n", res)
}

// ## 插入、更新和删除操作的预处理十分类似，这里以插入操作的预处理为例：
func prepareInsert(conn *sql.DB) {
	// 插入的SQL语句
	sqlStr := "insert into user(name,age) values (?,?)"
	// 进行SQL语句的预处理
	stmt, err := conn.Prepare(sqlStr)
	if err != nil {
		fmt.Printf("prepare failed, err:%v\n", err)
		return
	}
	// 释放 stmt 资源
	defer stmt.Close()

	// 执行预处理后的SQL (可以多次执行)
	_, err = stmt.Exec("WeiyiGeek", 18)
	if err != nil {
		fmt.Printf("insert failed, err:%v\n", err)
		return
	}

	// 执行预处理后的SQL
	_, err = stmt.Exec("插入示例", 82)
	if err != nil {
		fmt.Printf("insert failed, err:%v\n", err)
		return
	}

	// 插入成功会显示如下
	fmt.Println("insert success.")
}

func main() {
	// MysqlObj 结构体初始化
	conn := &db.MysqlObj{
		Mysql_host: "10.20.172.248",
		Mysql_port: 3306,
		Mysql_user: "root",
		Mysql_pass: "weiyigeek.top",
		Database:   "test",
	}
	// 数据库初始化
	err := conn.InitDB()
	if err != nil {
		panic(err)
	} else {
		fmt.Println("[INFO] - 已成功连接到数据库!")
	}
	// 关闭数据库对象
	defer conn.Db.Close()

	// 预处理查询
	fmt.Println("预处理查询示例函数 prepareQuery:")
	prepareQuery(conn.Db, 5)

	// 预处理插入
	fmt.Println("预处理插入示例函数 prepareInsert:")
	prepareInsert(conn.Db)
}
