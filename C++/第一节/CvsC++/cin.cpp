#include <iostream> 
/*
cin.peek();
cin.get() 
*/
using namespace std;

int main(void){
	int sum = 0,i;
	cout << "������һ����������������Ŀո�:";
	// >> cin �������������ȡ����������һ�δ�������������ȡһ������
	// ���û����м�������ʱ��,�Ƚ��ַ����뵽����ϵͳ���̻�������,��enter�Ű����Ǵ���cin���ڲ���������>> ��������������ȡ�ַ� 
	while(cin >> i){
		sum += i;
		while(cin.peek() == ' '){
			cin.get();
		}
		if(cin.peek() == '\n'){
			break;
		} 
	}
	cout << "����ǣ�" << sum << endl; 
	return 0;
}
