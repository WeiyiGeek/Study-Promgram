#include <iostream> 
#include <sstream>
#include <cstring>

//字符类 stringstream 
using namespace std;

int main(void){
	//字符串到整型 
	char test[] = "123";
	int num;
	stringstream ab(test);
	ab >> num;
	cout << "两个数之和 " << num + num << endl;
	 
	//整型到字符串
	float x = 10.24 ;
	stringstream sstr;
	sstr << x; 
    string str = sstr.str();   //string 需要引入 <cstring> 头文件 
    cout << "String 为 " << str << endl; 
	return 0;
}
