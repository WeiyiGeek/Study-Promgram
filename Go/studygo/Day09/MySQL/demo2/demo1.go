package main

import (
	"database/sql"
	"fmt"

	db "weiyigeek.top/studygo/Day09/MySQL/mypkg"
)

// 单结果语句查询函数示例
func queryPersonOne(conn *sql.DB, Uid int) (res db.Person) {
	// 1.单条SQL语句
	sqlStr := `select Uid,name,age from test.user where Uid=?;`
	// 2.执行SQL语句并返回一条结果
	rowObj := conn.QueryRow(sqlStr, Uid)
	// 3.必须对rowObj调用Scan方法，因为查询后我们需要释放数据库连接对象，而它调用后会自动释放。
	rowObj.Scan(&res.Uid, &res.Name, &res.Age)
	// 4.返回一个person对象
	return res
}

// 多结果语句查询函数示例
func queryPersonMore(conn *sql.DB, id int) {
	// 1.SQL 语句
	sqlStr := `select Uid,name,age from test.user where Uid > ?;`
	// 2.执行 SQL
	rows, err := conn.Query(sqlStr, id)
	if err != nil {
		fmt.Printf("Exec %s query failed！,err : %v \n", sqlStr, err)
		return
	}
	// 3.调用结束后关闭rows，释放数据库连接资源
	defer rows.Close()
	// 4.循环读取结果集中的数据
	for rows.Next() {
		var u db.Person
		err := rows.Scan(&u.Uid, &u.Name, &u.Age)
		if err != nil {
			fmt.Printf("scan failed, err:%v\n", err)
			return
		}
		fmt.Printf("Uid:%d name:%s age:%d\n", u.Uid, u.Name, u.Age)
	}
}

// 执行插入操作的函数示例
func insertPerson(conn *sql.DB) {
	// 1.SQL 语句
	sqlStr := `insert into user(name,age) values("Go语言",15)`
	// 2.执行插入语句
	ret, err := conn.Exec(sqlStr)
	if err != nil {
		fmt.Printf("Insert Failed, err : %v \n", err)
		return
	}
	// 3.插入数据操作，拿到插入数据库的id值
	Uid, err := ret.LastInsertId()
	if err != nil {
		fmt.Printf("Get Id Failed, err : %v \n", err)
		return
	}
	// 4.打印插入数据的id值
	fmt.Println("插入语句Uid值: ", Uid)
}

// 执行更新操作的函数示例
func updatePerson(conn *sql.DB, age, Uid int) {
	// 1.SQL 语句
	sqlStr := `update user set age=? where Uid = ?`
	// 2.执行插入语句
	ret, err := conn.Exec(sqlStr, age, Uid)
	if err != nil {
		fmt.Printf("Update Failed, err : %v \n", err)
		return
	}
	// 3.更新数据操作，获取到受影响的行数
	count, err := ret.RowsAffected()
	if err != nil {
		fmt.Printf("Get Id Failed, err : %v \n", err)
		return
	}
	// 4.打印数据影响的行数
	fmt.Println("更新数据影响的行数: ", count)
}

// 执行删除数据的操作函数示例
func deletePerson(conn *sql.DB, Uid int) {
	// 1.SQL 语句
	sqlStr := `delete from user where Uid > ?`
	// 2.执行删除的语句
	ret, err := conn.Exec(sqlStr, Uid)
	if err != nil {
		fmt.Printf("Delete Failed, err : %v \n", err)
		return
	}
	// 3.删除数据操作，获取到受影响的行数
	count, err := ret.RowsAffected()
	if err != nil {
		fmt.Printf("Get Id Failed, err : %v \n", err)
		return
	}
	// 4.打印删除数据的影响的行数:
	fmt.Println("删除数据影响的行数: ", count)
}

func main() {
	// 1.mysqlObj 结构体实例化
	conn := &db.MysqlObj{
		Mysql_host: "10.20.172.248",
		Mysql_port: 3306,
		Mysql_user: "root",
		Mysql_pass: "weiyigeek.top",
		Database:   "test",
	}
	// 2.初始化数据库
	err := conn.InitDB()
	if err != nil {
		panic(err)
	} else {
		fmt.Println("数据库初始化连接成功!")
	}

	// 3.程序结束时关闭数据库连接
	defer conn.Db.Close()

	// 4.单行查询
	res := queryPersonOne(conn.Db, 1)
	fmt.Printf("单行查询: %#v\n", res)

	// 5.多行查询
	fmt.Println("多行查询")
	queryPersonMore(conn.Db, 6)

	// 6.插入数据
	fmt.Println("插入数据")
	insertPerson(conn.Db)

	// 7.更新数据
	fmt.Println("更新数据")
	updatePerson(conn.Db, 16, 9)

	// 8.删除数据
	fmt.Println("删除数据")
	deletePerson(conn.Db, 10)
}
