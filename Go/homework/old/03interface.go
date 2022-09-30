package main

import "fmt"

type People interface {
	Speak(string) string
}

type Student struct{}

func (stu *Student) Speak(think string) (talk string) {
	if think == "man" {
		talk = "你好,帅哥"
	} else {
		talk = "您好,美女"
	}
	return
}

func main() {
	var peo People = &Student{}
	think := "woman"
	fmt.Println(peo.Speak(think))
}
