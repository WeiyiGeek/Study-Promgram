package main

import "fmt"

// 父
type Animal struct{ name string }

func (a *Animal) voice(v string) {
	fmt.Printf("我是动物，我叫 %v, 我会叫 %s,", a.name, v)
}

// 子
type Dog struct {
	eat string
	*Animal
}

func (d *Dog) love() {
	fmt.Printf("狗狗喜欢吃的食物是 %v.\n", d.eat)
}

type Cat struct {
	eat string
	*Animal
}

func (c *Cat) love() {
	fmt.Printf("猫猫喜欢吃的食物是 %v.\n", c.eat)

}

func main() {
	d1 := &Dog{
		//注意嵌套的是结构体指针
		Animal: &Animal{
			name: "小黄",
		},
		eat: "bone",
	}
	d1.voice("汪汪.汪汪.")
	d1.love()

	c1 := &Cat{
		//注意嵌套的是结构体指针
		Animal: &Animal{
			name: "小白",
		},
		eat: "fish",
	}
	c1.voice("喵喵.喵喵.")
	c1.love()
}
