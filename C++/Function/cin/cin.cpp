#include <iostream>
using namespace std;
int main(void){
	int num,sum=0;
	cout << "������һ����������";
	//����������3.14 ����һ��false ,��ʱsum ֻ���ȡ�� 3  
	while(cin >> num){
		sum += num;
	}	
	cout << "Sum = " << sum << endl; 
	return 0;
}
