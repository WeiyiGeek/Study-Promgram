#include <iostream>

using namespace std;
//进行解引用 才是交换 值 （值得学习） 
void paraPt(int *aPt, int *bPt){
	*aPt ^= *bPt;  //采用xor的方法进行交换值 
	*bPt ^= *aPt;  // b = a 
	*aPt ^= *bPt;  // a = b 
}

int main(void){
	int a = 10;
	int b = 24;
	cout << "初始化 a - b 值： " << a << " - " << b << endl; 
	paraPt(&a,&b); 
	cout << "传址后 a - b 值： " << a << " - " << b << endl; 
	return 0;
}
