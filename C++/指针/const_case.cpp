#include <iostream>
using namespace std;
//定义字符串的参数时候进行赋值（值得学习，这里是 int *val 来接受 const_case 转换const常量后的地址 ） 
void Printer (int* val,string seperator = "\n")
{
	cout << "进行const_cast转换后的地址：" << val << seperator;
	cout << "*val 值为 ：" << *val << seperator;
	*val = 1024;  //局部变量修改 后 main 中传入&consatant 地址内数据不会被修改 
	cout << "*val 值为 ：" << *val << seperator;
	
}

int main(void) 
{	
	//第一种情况 
	const int consatant = 20;
	//Printer(consatant);//Error: invalid conversion from 'int' to 'int*'
	cout << "Consatant 地址 ：" << &consatant << endl; 
	Printer(const_cast<int *>(&consatant));
	cout << "consatant 值为 ：" << consatant << endl;
	
	
	//第二种情况 
	int variable = 21;
	int* const_p = &variable;
	int* modifier = const_cast<int*>(const_p);
	
	*modifier = 7;
	cout << "variable:" << variable << endl;
	
	return 0;
}
