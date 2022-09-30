package main

import (
	"fmt"
	"math"
)

type GarphicArea interface {
	Square(float64) float64                     // 正方形
	Triangle(float64, float64, float64) float64 //三角形
}
type GarphicName struct{ Name string }

func (g *GarphicName) Square(a float64) float64 {
	// S = a^2
	return math.Pow(a, 2)
}

func (g *GarphicName) Triangle(a, b, c float64) float64 {
	//（海伦公式）（p=(a+b+c)/2） S=sqrt[p(p-a)(p-b)(p-c)]
	p := (a + b + c) / 2
	return math.Sqrt(p * (p - a) * (p - b) * (p - c))
}

func main() {
	var ga GarphicArea = &GarphicName{"正方形"}
	fmt.Println("正方形面积: ", ga.Square(4))
	ga = &GarphicName{"三角形"}
	fmt.Println("三角形面积: ", ga.Triangle(3, 4, 5))
}
