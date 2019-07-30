#include <iostream>
/**传引用 - demo**/ 
using namespace std;
//利用参数进行获取传入变量的地址 
void paraPt(int &aPt, int &bPt){
	//同时这里不需要进行“解引用” 
	aPt ^= bPt;  //采用xor的方法进行交换值 
	bPt ^= aPt;  // b = a 
	aPt ^= bPt;  // a = b 
}

int main(void){
	int a = 10;
	int b = 24;
	cout << "初始化 a - b 值： " << a << " - " << b << endl; 
	//下面只是语法上面的差异不用在调用函数的时候对参数进行 “& ” 
	paraPt(a,b); 
	cout << "传址后 a - b 值： " << a << " - " << b << endl; 
	return 0;
}
