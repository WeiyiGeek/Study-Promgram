#include <fstream>
#include <iostream> 
using namespace std;

int main() {
	
	//ֱ����fstream�����
	fstream io("test.txt",ios::in|ios::out); 
	if(!io){
		cerr << "Error" << endl;
		return 0; 
	}
	
	io << "I-love-C++-PROGRAM-Language!";
	//ֵ��ע��ĵط���������Ǿ�̬�� 
	static char test[100];
	
	io.seekg(ios::beg); //ָ���ļ���ͷ 
	
	while(io >> test)
		; 
	//�ո�֮ǰ���ַ�������ʾ 
	cout << test << endl;	
	io.close();
	return 0; 
}
