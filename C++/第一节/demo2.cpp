#include <iostream>
/**
	�����¶�  F = �����¶� C ���໥ת��
	F =  C * 9.0 / 5.0 + 32��
	�����¶Ⱦ��������㣻 
**/

int main(void){
	//��C++���峣������ʹ��const 
	const unsigned short NUM = 32;
	const double RATIO = 9.0 / 5.0;
	
	double tempIn,tempOut; //����������ֵ 
	char  typeIn,typeOut; //�������ĵ�λ
	
	std::cout << "������xxx.XX F ���� ooo.oo C�ĸ�ʽ���л����¶��������¶��໥ת����"; 
	std::cin >> tempIn >> typeIn;
	std::cin.ignore(100,'\n'); //���Իس� 
	std::cout << std::endl;
	 
	switch(typeIn){
		case 'f':
		case 'F':
			tempOut =  (tempIn - NUM) * (1.0 / RATIO); 
			typeIn = 'F';
			typeOut = 'C';
			break;
			
		case 'c':
		case 'C':
			tempOut =  tempIn * RATIO + NUM; 
			typeIn = 'C';
			typeOut = 'F';
			break;
		default:
			typeOut = 'E';
			std::cout << "Dear.�����ʽ����" << std::endl; 
	} 
	
	//Ϊ�˳���Ľ�׳�ԣ����뽫�û������ 
	if(typeOut != 'E'){
		std::cout << "���������Ϊ��\n" << tempIn << typeIn << " = " << tempOut << typeOut << std::endl;
	}else{
		return 1;
	}
	std::cout << "�������κη��Ž�������!" << std::endl; 
	std::cin.get();
	
	return 0; 
}
