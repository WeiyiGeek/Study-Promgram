#include <fstream>
#include <iostream>

//ʹ�����ֿռ� 
using namespace std;

int main(){
	
	//��ȡ 
	ifstream in;  //in����ӵ����ifstream��������뷽�� 
	in.open("test.txt");
	
	//������0ʱ���ʧ��
	if(!in){
		cerr << "Open Fail!!\n" << endl;
		return 0; 
	} 
	
	//����һ���ַ����� ���������ض����ȡ�ļ����ַ���������ն��� 
	char x;
	while(in >> x){
		cout << x;
	}
	cout << endl; 	//ע������������ 
	in.close(); //�رմ򿪵��ļ�
	
	
	//д��,���ù��캯�� 
	ofstream out("test.txt"); 
	if(!out){
		cerr << "Open Fail !!" << endl;
		return 0; 
	} 
	
	//C++���� ������ԭ���ļ��е����� 
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
