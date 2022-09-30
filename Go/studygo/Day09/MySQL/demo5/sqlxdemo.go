package main

import (
	"database/sql/driver"
	"errors"
	"fmt"
	"strings"

	"github.com/jmoiron/sqlx"
	"weiyigeek.top/studygo/Day09/MySQL/mypkg"
)

// ## 查询显示单行数据示例代码
func queryRow(db *sqlx.DB) {
	// User 结构体类型声明
	var u mypkg.User
	sqlStr := "SELECT uid,name,age FROM user WHERE uid=?"
	// 执行查询语句并通过反射reflect将查询结果进行一一绑定,返回单行数据
	err := db.Get(&u, sqlStr, 1)
	if err != nil {
		fmt.Printf("get failed, err:%v\n", err)
		return
	}
	fmt.Printf("id:%d name:%s age:%d\n", u.Uid, u.Name, u.Age)
}

// ## 查询显示多行数据示例代码
func queryMultiRow(db *sqlx.DB) {
	// User 结构体类型数组声明
	var u []mypkg.User
	sqlStr := "select uid, name, age from user where uid > ?"

	// 执行多行数据结果查询
	err := db.Select(&u, sqlStr, 8)
	if err != nil {
		fmt.Printf("query failed, err:%v\n", err)
		return
	}
	fmt.Printf("users:%#v\n", u)
}

// 插入数据方法示例
func insertRow(db *sqlx.DB) {
	sqlStr := "insert into user(name, age) values (?,?)"
	// EXEC 方法执行的SQL语句包括 插入/更新和删除
	ret, err := db.Exec(sqlStr, "我爱学Go", 19)
	if err != nil {
		fmt.Printf("insert failed, err:%v\n", err)
		return
	}
	theID, err := ret.LastInsertId() // 新插入数据的id
	if err != nil {
		fmt.Printf("get lastinsert ID failed, err:%v\n", err)
		return
	}
	fmt.Printf("insert success, the id is %d.\n", theID)
}

// 更新数据
func updateRow(db *sqlx.DB) {
	sqlStr := "update user set age=? where uid = ?"
	ret, err := db.Exec(sqlStr, 39, 8)
	if err != nil {
		fmt.Printf("update failed, err:%v\n", err)
		return
	}
	n, err := ret.RowsAffected() // 操作影响的行数
	if err != nil {
		fmt.Printf("get RowsAffected failed, err:%v\n", err)
		return
	}
	fmt.Printf("update success, affected rows:%d\n", n)
}

// 删除数据
func deleteRow(db *sqlx.DB) {
	sqlStr := "delete from user where uid = ?"
	ret, err := db.Exec(sqlStr, 16)
	if err != nil {
		fmt.Printf("delete failed, err:%v\n", err)
		return
	}
	n, err := ret.RowsAffected() // 操作影响的行数
	if err != nil {
		fmt.Printf("get RowsAffected failed, err:%v\n", err)
		return
	}
	fmt.Printf("delete success, affected rows:%d\n", n)
}

// 事务处理
func transactionSqlx(db *sqlx.DB) (err error) {
	// 开启事务
	tx, err := db.Beginx()
	if err != nil {
		fmt.Printf("begin trans failed, err:%v\n", err)
		return err
	}
	// 任务执行完毕后判断是否进行rollback
	defer func() {
		if p := recover(); p != nil {
			// 回滚操作
			tx.Rollback()
			panic(p) // re-throw panic after Rollback
		} else if err != nil {
			fmt.Println("rollback")
			// 回滚操作
			tx.Rollback() // err is non-nil; don't change it
		} else {
			// 提交操作
			err = tx.Commit() // err is nil; if Commit returns error update err
			fmt.Println("commit")
		}
	}()

	// A 用户向 B用户转账 50
	sqlStr1 := "UPDATE `money` SET balance=balance-50 WHERE id=?"
	rs, err := tx.Exec(sqlStr1, 1)
	if err != nil {
		return err
	}
	n, err := rs.RowsAffected()
	if err != nil {
		return err
	}
	if n != 1 {
		return errors.New("exec sqlStr1 failed")
	}

	// B 接收到 A用户的转账 50
	sqlStr2 := "UPDATE `money` SET balance=balance+50 WHERE id=?;"
	rs, err = tx.Exec(sqlStr2, 2)
	if err != nil {
		return err
	}
	n, err = rs.RowsAffected()
	if err != nil {
		return err
	}
	if n != 1 {
		return errors.New("exec sqlStr1 failed")
	}

	return err
}

type User struct {
	// Uid int `db:"uid"`
	Name string `db:"name"`
	Age  int    `db:"age"`
}

// BatchInsertUsers 自行构造批量插入的语句
func BatchInsertUsers(users []*User, db *sqlx.DB) error {
	// 存放 (?, ?) 的slice
	valueStrings := make([]string, 0, len(users))
	// 存放values的slice
	valueArgs := make([]interface{}, 0, len(users)*2)
	// 遍历users准备相关数据
	for _, u := range users {
		// 此处占位符要与插入值的个数对应
		valueStrings = append(valueStrings, "(?, ?)")
		valueArgs = append(valueArgs, u.Name)
		valueArgs = append(valueArgs, u.Age)
	}
	fmt.Printf("%#v\n%#v\n", valueStrings, valueArgs)

	// 自行拼接要执行的具体语句
	stmt := fmt.Sprintf("INSERT INTO user (name, age) VALUES %s",
		strings.Join(valueStrings, ","))
	fmt.Println(stmt)
	res, err := db.Exec(stmt, valueArgs...)
	if err != nil {
		fmt.Printf("Exec Batch Insert Users SQL Failed, %v\n", err)
		return err
	}

	// 输出插入成功的行函数(影响行)
	count, err := res.RowsAffected()
	if err != nil {
		fmt.Printf("Get Rows Affected Failed, %v\n", err)
		return err
	} else {
		fmt.Println("Insert Rows Affected ：", count)
		return nil
	}
}

// 插入实例前提是需要我们的结构体实现driver.Valuer接口：
func (u User) Value() (driver.Value, error) {
	return []interface{}{u.Name, u.Age}, nil
}

// BatchInsertUsers2 使用sqlx.In帮我们拼接语句和参数, 注意传入的参数是[]interface{}
func BatchInsertUsers2(users []interface{}, db *sqlx.DB) error {
	// 1.预处理SQL将参数与占位符绑定。
	query, args, _ := sqlx.In(
		"INSERT INTO user (name, age) VALUES (?), (?), (?)",
		users..., // 如果arg实现了 driver.Valuer, sqlx.In 会通过调用 Value()来展开它
	)
	fmt.Println(query) // 查看生成的querystring
	fmt.Println(args)  // 查看生成的args

	// 2.执行批量插入。
	res, err := db.Exec(query, args...)
	if err != nil {
		fmt.Printf("Exec Batch Insert Users SQL Failed, %v\n", err)
		return err
	}

	// 3.输出插入成功的行函数(影响行)。
	count, err := res.RowsAffected()
	if err != nil {
		fmt.Printf("Get Rows Affected Failed, %v\n", err)
		return err
	} else {
		fmt.Println("Insert Rows Affected ：", count)
		return nil
	}
}

// BatchInsertUsers3 使用NamedExec实现批量插入
func BatchInsertUsers3(users []*User, db *sqlx.DB) error {
	// 1.SQL预处理以及执行批量插入
	res, err := db.NamedExec("INSERT INTO user (name, age) VALUES (:name, :age)", users)
	if err != nil {
		fmt.Printf("Exec Batch Insert Users SQL Failed, %v\n", err)
		return err
	}

	// 2.输出插入成功的行函数(影响行)。
	count, err := res.RowsAffected()
	if err != nil {
		fmt.Printf("Get Rows Affected Failed, %v\n", err)
		return err
	} else {
		fmt.Println("Insert Rows Affected ：", count)
		return nil
	}
}

func main() {
	// 1.sqlx结构体初始化
	conn := &mypkg.SqlObj{
		Mysql_host: "10.20.172.248",
		Mysql_port: 3306,
		Mysql_user: "root",
		Mysql_pass: "weiyigeek.top",
		Database:   "test",
	}

	// 2.连接数据库初始化操作
	err := conn.InitDB()
	if err != nil {
		panic(err)
	} else {
		fmt.Println("[INFO] - 数据库已连接成功！")
	}

	// 3.关闭sqlx.DB数据连接对象(资源释放)
	defer conn.DB.Close()

	// // 4.单行数据查询
	// fmt.Println("单行数据查询结果：")
	// queryRow(conn.DB)

	// // 6.插入数据
	// fmt.Println("输入数据操作：")
	// insertRow(conn.DB)

	// // 7.更新数据
	// fmt.Println("更新数据操作: ")
	// updateRow(conn.DB)

	// // 8.删除数据
	// fmt.Println("删除数据操作: ")
	// deleteRow(conn.DB)

	// //9.事务处理
	// transactionSqlx(conn.DB)

	// 10.自定义利用占位符进行批量插入
	// userInsert := make([]*User, 0)
	// userInsert = append(userInsert, &User{Name: "WeiyiGeek-20", Age: 20})
	// userInsert = append(userInsert, &User{Name: "WeiyiGeek-21", Age: 21})
	// userInsert = append(userInsert, &User{Name: "WeiyiGeek-22", Age: 22})
	// err = BatchInsertUsers(userInsert, conn.DB)
	// if err != nil {
	// 	panic(err)
	// } else {
	// 	fmt.Println("批量插入执行完毕!")
	// }

	// 11.使用sqlx.in进行批量插入
	// userInsert := make([]interface{}, 0) // 空接口数组内存申请
	// userInsert = append(userInsert, &User{Name: "Gooo-20", Age: 20})
	// userInsert = append(userInsert, &User{Name: "R-21", Age: 21})
	// userInsert = append(userInsert, &User{Name: "Javascript-22", Age: 22})
	// err = BatchInsertUsers2(userInsert, conn.DB)
	// if err != nil {
	// 	panic(err) // 在进行开发测试代码时使用，正式环境中请勿使用。
	// } else {
	// 	fmt.Println("sqlx.In - 批量插入执行完毕!")
	// }

	// 12.使用 NamedExec 实现批量插入
	userInsert := make([]*User, 0)
	userInsert = append(userInsert, &User{Name: "小红", Age: 20})
	userInsert = append(userInsert, &User{Name: "小南", Age: 21})
	userInsert = append(userInsert, &User{Name: "小白", Age: 22})
	err = BatchInsertUsers3(userInsert, conn.DB)
	if err != nil {
		fmt.Printf("[Error] - %v\n", err)
	} else {
		fmt.Println("NamedExec - 批量插入执行完毕!")
	}
}
