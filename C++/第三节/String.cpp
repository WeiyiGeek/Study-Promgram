#include <iostream>
//����String�����������һ���ַ��� 

int main(void){
	//�ַ������� 
	std::string str; 
	std::cout << "������һ���ַ�����";
	//cin ֱ�ӽ��ո�ʶ��Ϊ�������ţ�
	//std::cin >> str; 
	//�����������getline 
	std::getline(std::cin,str);
	std::cout << str << std::endl;
	return 0;
}
