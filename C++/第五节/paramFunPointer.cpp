#include <iostream>

using namespace std;
//���н����� ���ǽ��� ֵ ��ֵ��ѧϰ�� 
void paraPt(int *aPt, int *bPt){
	*aPt ^= *bPt;  //����xor�ķ������н���ֵ 
	*bPt ^= *aPt;  // b = a 
	*aPt ^= *bPt;  // a = b 
}

int main(void){
	int a = 10;
	int b = 24;
	cout << "��ʼ�� a - b ֵ�� " << a << " - " << b << endl; 
	paraPt(&a,&b); 
	cout << "��ַ�� a - b ֵ�� " << a << " - " << b << endl; 
	return 0;
}
