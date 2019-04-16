#include <iostream>
// Returns a hash code based on an address
//体现哈希的思想
using namespace std;
unsigned short Hash( void *p ) {
	unsigned int val = reinterpret_cast<unsigned int>( p );  //进行传输地址的转换成int类型
	cout << val << " -- "; 
	return ( unsigned short )( val ^ (val >> 16));     // 让val进行 位运算 与 异或运算
}


int main() {
	int a[20] = {0};
	for ( int i = 0; i < 20; i++ )
		cout << Hash( a + i ) << endl;  //函数名其实就是指针指向第一个元素地址
}

//如果跟我一样是64位的系统，可能需要将unsigned int改成 unsigned long才能运行。
