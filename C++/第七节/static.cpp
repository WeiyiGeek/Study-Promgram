#include <iostream>

using namespace std;

void add(int a){
	static int num = 0;	 //��̬����  ֻ���ڳ������ʱ�����٣� 
	num += a;
	cout << "��̬����num��ֵΪ��" << num << endl;
}

int reduce(){
	static int count = 10; //������ǰ������������һ�Σ��ڴ����ͳ�ʼ����,�����ڳ���������û�����С� 
	return count--;
}

int main(void){
	
	//����ÿ�ζ���num��ʼ�� 
	add(2);
	add(6);
	//����ÿ�ζ���count��ʼ��  
	int b = 1; 
	for(;b<=10;b++){
		cout << b << " " << reduce() << endl;
	} 
	return 0;
} 

