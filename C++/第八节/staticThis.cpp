#include<iostream>
/**静态方法 与 this 指针 Demo**/
class Point
{
private:
	int x, y;
//可以直接在类里面进行方法的声明定义
public:
	Point(int a, int b)
	{ 
		x = a;
		y = b;
	}
	void MovePoint( int a, int b)
	{ 
		x = a; 
		y = b;
	}
	void print()
	{ 
		std::cout << "x=" << x << " , y=" << y << std::endl;
	}
};

int main()
{
	Point point1(10, 10); 
	point1.print();
	point1.MovePoint(2, 2);  // 当对象point1调用MovePoint(2,2)函数时，即将point1对象的地址传递给了this指针。
	// MovePoint函数的原型事实上应该是 void MovePoint( Point *this, int a, int b);
	// 第一个参数是指向该类对象的一个指针，我们在定义成员函数时没看见是因为这个参数在类中是隐含的。
	point1.print();
	// 这样point1的地址传递给了this，所以在MovePoint函数中便可以显式的写成：void MovePoint(int a, int b) { this->x = a; this->y = b;} 
	// 即可以知道，point1调用该函数后，也就是point1的数据成员被调用并更新了值。
	return 0;
}




