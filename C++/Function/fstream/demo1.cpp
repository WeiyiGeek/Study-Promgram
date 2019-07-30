#include <fstream>
#include <iostream>

//使用名字空间 
using namespace std;

int main(){
	
	//读取 
	ifstream in;  //in对象拥有了ifstream类的属性与方法 
	in.open("test.txt");
	
	//当返回0时候打开失败
	if(!in){
		cerr << "Open Fail!!\n" << endl;
		return 0; 
	} 
	
	//声明一个字符变量 并且利用重定向读取文件中字符，输出到终端中 
	char x;
	while(in >> x){
		cout << x;
	}
	cout << endl; 	//注意这里是配套 
	in.close(); //关闭打开的文件
	
	
	//写入,采用构造函数 
	ofstream out("test.txt"); 
	if(!out){
		cerr << "Open Fail !!" << endl;
		return 0; 
	} 
	
	//C++特性 将覆盖原有文件中的类容 
	int i = 0;
	while(i < 10){
		out << i;
		i += 1; 

	}
	cout << endl;
	out.close();
	
	system("type test.txt");
	
	return 0;
}
