#include <iostream> 
using namespace std;
int main(void){
	char ch;
	cout << "�������ַ���:";
	// >> cin �������������ȡ����������һ�δ�������������ȡһ������
	// ���û����м�������ʱ��,�Ƚ��ַ����뵽����ϵͳ���̻�������,��enter�Ű����Ǵ���cin���ڲ���������>> ��������������ȡ�ַ� 
	
	while(cin.peek() != '\n'){
		//���������̨ 
		cout << (ch = cin.get());
	} 
	
	cout << endl; 
	return 0;
}
