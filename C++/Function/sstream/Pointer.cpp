#include <iostream>

int main(void){
	//��������ָ����� 
	int *pt;
	int num = 1024;
	//��ʵ��Cһ��ȡnum��������ַ�����ptָ���� 
	pt = &num;
	
	std::cout << "pt��ַΪ��" << pt << " ���� " << &num << std::endl; 
	std::cout << "*pt����ֵΪ��" << *pt << std::endl; 

	return 0;
}
