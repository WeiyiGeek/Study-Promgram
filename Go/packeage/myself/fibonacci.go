package myself

func Fibonacci(number int) int {
	if number == 0 {
		return 0
	}
	if number == 1 || number == 2 {
		return 1
	}
	return Fibonacci(number-1) + Fibonacci(number-2)
}
