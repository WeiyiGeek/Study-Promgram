#include <iostream>
//�û������ж� ��cin.ignore������ʹ�� 
int main(void){
	
	char ch;
	std::cout << "�Ƿ�������Ҫȥ����?��Y/N����" ;
	std::cin >> ch; //�������û�����  
	std::cout << std::endl; 
	switch(ch){
		case 'y':
		case 'Y':
			std::cout << "## �����������ܺã�һ����ȥ���Σ�\n" << std::endl;
			break; 
		case 'n':
		case 'N':
			std::cout << "** ����������Ҫ���꣬�һ����ڼ�дЪ����ѣ�\n" << std::endl; 
			break;
		default:
			std::cout << "��������" << std::endl; 
	}	
	
	std::cin.ignore(100,'\n'); //���� ǰ100���س��� 
	std::cin.get();  //��ֹ���ڹر� 
	return 0;
}
