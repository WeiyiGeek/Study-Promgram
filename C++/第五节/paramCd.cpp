#include <iostream>
/**������ - demo**/ 
using namespace std;
//���ò������л�ȡ��������ĵ�ַ 
void paraPt(int &aPt, int &bPt){
	//ͬʱ���ﲻ��Ҫ���С������á� 
	aPt ^= bPt;  //����xor�ķ������н���ֵ 
	bPt ^= aPt;  // b = a 
	aPt ^= bPt;  // a = b 
}

int main(void){
	int a = 10;
	int b = 24;
	cout << "��ʼ�� a - b ֵ�� " << a << " - " << b << endl; 
	//����ֻ���﷨����Ĳ��첻���ڵ��ú�����ʱ��Բ������� ��& �� 
	paraPt(a,b); 
	cout << "��ַ�� a - b ֵ�� " << a << " - " << b << endl; 
	return 0;
}
