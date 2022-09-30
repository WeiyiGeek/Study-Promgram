package bitmove

import "fmt"

func Leftmove(n int, shift int) {
	fmt.Printf("%v << %v = %08b\n", n, shift, n<<shift)
}

func RightMove(n int, shift int) {
	fmt.Printf("%v >> %v = %08b\n", n, shift, n>>shift)
}
