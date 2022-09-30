package main

import (
	// . "fmt" 不建议如此使用

	_ "fmt"

	demo "weiyigeek.top/packeage/pkg/demo1"
)

func main() {
	println(demo.Flag)
	println(demo.FLAG)
	demo.Show()
	demo.Exec(demo.Person{Name: "Weiyieek"})
}
