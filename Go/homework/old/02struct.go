package main

import (
	"fmt"
	"os"
)

/**	Desc: 采用结构体方法实现考生信息的增加与删除**/

var (
	// options
	flag uint8

	// key : value
	allStudent map[int64]*Student
)

// 结构体
type Student struct {
	id   int64
	name string
	age  uint8
}

// 构造函数
func newStudent(id int64, name string, age uint8) *Student {
	return &Student{
		id:   id,
		name: name,
		age:  age,
	}
}

// 验证考生是否存在
func (s *Student) judge(id int64) bool {
	_, ok := allStudent[id]
	if ok {
		return true
	} else {
		return false
	}
}

// 添加考生
func (s *Student) add() {
	var (
		id   int64
		name string
		age  uint8
	)
	fmt.Println("#请输入考生 id name age 信息以空格分割：")
	fmt.Scan(&id, &name, &age)
	if !s.judge(id) {
		student := newStudent(id, name, age)
		allStudent[id] = student
	} else {
		fmt.Println("该id号的考生已存在无需重复添加.")
	}
}

// 删除考生
func (s *Student) del(id int64) {
	if s.judge(id) {
		delete(allStudent, id)
		fmt.Printf("已删除考生号为 %d 的学生信息.\n", id)
	} else {
		fmt.Println("该id号的考生不存在.")
	}

}

// 显示考生
func (s *Student) show() {
	for k, v := range allStudent {
		fmt.Printf("uid: %d 姓名: %s 年龄: %d\n", k, v.name, v.age)
	}
}

func main() {
	// Step 0.初始化存放考生信息的Map
	allStudent = make(map[int64]*Student, 48)
	student := Student{}

	// Step 1
	fmt.Println("欢迎使用学生信息系统简单版本")
	fmt.Printf("功能说明: \n1.增加学生\n2.查看学生\n3.删除学生\n4.退出程序\n\n")

	// Step 2
	for {
		fmt.Printf("功能选择: ")
		fmt.Scanln(&flag)
		fmt.Printf("#你选择第 %d 个的选项\n", flag)

		// step 3
		switch flag {
		case 1:
			student.add()
		case 2:
			student.show()
		case 3:
			fmt.Printf("请输入要删除的学生 uid:")
			var uid int64
			fmt.Scanln(&uid)
			student.del(uid)
		case 4:
			fmt.Printf("程序结束 :")
			os.Exit(1)
		default:
			fmt.Printf("功能说明: \n1.增加学生\n2.查看学生\n3.删除学生\n4.退出程序")
		}
	}
}
