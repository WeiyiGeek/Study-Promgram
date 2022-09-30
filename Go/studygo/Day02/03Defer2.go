package main

import "fmt"

func calc(index string, a, b int) int {
	ret := a + b
	fmt.Println(index, a, b, ret)
	return ret
}

func main() {
	x := 1
	y := 2
	defer calc("AA", x, calc("A", x, y))
	// calc("A", x, y) =>calc("A", 1, 2) = 3  {"A" , 1, 2, 3}
	// defer calc("AA", 1, 3) = 4 {"AA", 1, 3, 4}
	x = 10
	defer calc("BB", x, calc("B", x, y))
	// calc("B", x, y) = calc("B", 10, 2) = 12  {"B" , 10, 2, 12}
	// defer calc("BB", 10, 12) = 22 {"BB",10,12,22}
	y = 20
}
