package main

import "fmt"

func main() {
	var name string
	var age int
	var boolean_value bool

	n, err := fmt.Sscan("WeiyiGeek 18 true",
		&name, &age, &boolean_value)

	if err != nil {
		panic(err)
	}
	fmt.Printf("%d:%s, %d, %t", n, name, age, boolean_value)
}
