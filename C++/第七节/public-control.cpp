#include <iostream>
/**�ؼ������η� -  C++���ʿ��Ƽ���*/

class Base {
public:
	std::string shape;
	Base(std::string xz);
	void modity(std::string xz,std::string ys, short num); 
//���� 
protected:
	std::string color; 
//˽�е�
private:
	unsigned short count;
}; 

class Sub:protected Base {
public:
	Sub(std::string xz);	
}; 

//�������๹����
Base::Base(std::string xz){
	shape = xz;
	color = "red";
	count = 2;
	std::cout << "Init:\n" << shape << " - " << color << " - " << count << "\n"; 
};
//!ע������Ĺ������ļ̳� 
Sub::Sub(std::string xz):Base(xz){
	shape = "Բ��"; 
	color = "yellow"; 
	//count  = 15; (����˽�е��ǲ��ܸ��ĵ�)��ͬ���ʿ���Ȩ�޼���ֻ���޸�ͬȨ�޼������Ȩ�ķ��������� 
	std::cout << "�����ʼ����" << shape << " & " << color;
}

//�������ඨ�巽�� 
void Base::modity(std::string xz,std::string ys, short num){
	shape = xz;
	color = ys;
	count = num;
	std::cout << shape << " - " << color << " - " << count << "\n\n"; 
}


int main(void){
	
	//����1 
	Base squre("squre");
	std::cout << "Modity��\n"; 
	squre.shape = "zhengfangxing";
	//�����Ķ�����public���ʿ����¿���ͨ������.����/�������з���, ���ǣ�protected/private�����ô˽��з������޸ģ� 
	std::cout << squre.shape << "\n"; 
	//������ͨ���ڲ������ķ������и���˽���뱣���������뷽��; 
	squre.modity("������","Blue",5);
	
	std::cout << "-------------------------------" << std::endl;
	
	//����2��
	Sub circular("circular");
	//���̳е�Ȩ��Ϊprotectedʱ����ͨ�� ����.���� ���з��ʻ����е�public���Է��� 
 	//circular.shape = "Circular";
	 
	return 0;
}
