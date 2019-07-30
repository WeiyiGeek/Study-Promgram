#include <iostream>
/**
	�����¶�  F = �����¶� C ���໥ת��
	F =  C * 9.0 / 5.0 + 32��
	����C++���صķ�ʽ 
**/

//�������غ��� 
void convertTemparature(double tempIn,char typeIn);
void convertTemparature(int tempIn, char typeIn) ;

int main(void){
	
	//��������Ϊ�����������ͽ���ֵ�ı��� 
	double tempIn;
	int tempInInt;
	char  typeIn; //�������ĵ�λ
	
	std::cout << "������xxx.XX F ���� ooo.oo C�ĸ�ʽ���л����¶��������¶��໥ת����"; 
	std::cin >> tempIn >> typeIn;
	std::cin.ignore(100,'\n'); //���Իس� 
	std::cout << std::endl;
	convertTemparature(tempIn,typeIn);
	
	std::cout << "������xxx F ���� ooo C�ĸ�ʽ���л����¶��������¶��໥ת����"; 
	std::cin >> tempInInt >> typeIn;
	std::cin.ignore(100,'\n'); //���Իس� 
	std::cout << std::endl;
	convertTemparature(tempInInt,typeIn);

}

//����Ϊ������ 
void convertTemparature(double tempIn , char typeIn){
	//��C++���峣������ʹ��const 
	const unsigned short NUM = 32;
	const double RATIO = 9.0 / 5.0;
	
	double tempOut; 
	char typeOut;
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
		return;
	}
	std::cout << "�������κη��Ž�������!" << std::endl; 
	std::cin.get();
}

//����Ϊ����
void convertTemparature(int tempIn , char typeIn){
	//��C++���峣������ʹ��const 
	const unsigned short NUM = 32;
	const double RATIO = 9.0 / 5.0;
	int tempOut; 
	char typeOut;
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
		return;
	}
	std::cout << "�������κη��Ž�������!" << std::endl; 
	std::cin.get();
}
