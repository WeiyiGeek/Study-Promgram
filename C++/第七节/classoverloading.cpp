#include <iostream>
/**ʵ��c++����������ذ���**/
class Base{
public:
	void init();
	void init(std::string zz);	
};

class Subf:public Base{
public:
	std::string sub;
	//void init(std::string name,char sex);  //�������أ�Error��		
};
class Subs:public Base{
public:
	std::string sub;
}; 

//���巽�� 
void Base::init()
{
	std::cout << "��ʼ������ ...... \n";
}
//�������صķ���
void Base::init(std::string zz){
	std::cout << "����-���س�ʼ������......" << zz << "\n";
} 

/** ���������ػ��෽���ᱨ�� 
void Subf::init(std::string name,char sex){
	sub = name 
	std::cout << "����-���س�ʼ������ --->>> " << sub << "\n"; 
}**/
 
int main(void){
	Subf demo;
	demo.init();
	demo.init("demo��������\n");
	//�����������ػ���ķ����ᱨ�� 
	//demo.init("Weiyigeek",'F');
	
	Subs demo1;
	demo1.init();
	demo1.init("demo1��������");

	return 0;
} 

