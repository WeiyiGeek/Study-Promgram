package main

import "fmt"

//Address 地址结构体
type Address struct {
	Province string
	City     string
}

//Email 邮箱结构体
type Email struct {
	Account    string
	CreateTime string
}

//User 用户结构体
type User struct {
	Name    string
	Gender  string
	Address Address
}

//AnonUser 用户结构体
type AnonUser struct {
	Name    string
	Gender  string
	Address // 采用匿名字段
	Email   // 采用匿名字段
}

// 1.嵌套结构体
func demo1() {
	// 结构体初始化
	user := User{
		Name:   "WeiyiGeek",
		Gender: "男",
		Address: Address{
			Province: "重庆",
			City:     "重庆",
		},
	}
	fmt.Printf("Struct : %#v \n", user)
	fmt.Printf("Name = %v, Address City = %v \n", user.Name, user.Address.City)
}

// 2.嵌套匿名字段防止字段米名称冲突
func demo2() {
	var anonuser = AnonUser{
		Name:   "WeiyiGeek",
		Gender: "男",
		Address: Address{
			"重庆",
			"重庆",
		},
		Email: Email{
			"Master@weiyigeek.top",
			"2021年8月23日 10:21:36",
		},
	}
	fmt.Printf("Struct : %#v\n", anonuser)
	fmt.Printf("Name = %v,Address Province = %v, Email Account = %v \n", anonuser.Name, anonuser.Address.Province, anonuser.Email.Account)
}
func main() {
	demo1()
	fmt.Println()
	demo2()

}
