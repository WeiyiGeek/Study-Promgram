#include <iostream>
using namespace std;
//�����ַ����Ĳ���ʱ����и�ֵ��ֵ��ѧϰ�������� int *val ������ const_case ת��const������ĵ�ַ �� 
void Printer (int* val,string seperator = "\n")
{
	cout << "����const_castת����ĵ�ַ��" << val << seperator;
	cout << "*val ֵΪ ��" << *val << seperator;
	*val = 1024;  //�ֲ������޸� �� main �д���&consatant ��ַ�����ݲ��ᱻ�޸� 
	cout << "*val ֵΪ ��" << *val << seperator;
	
}

int main(void) 
{	
	//��һ����� 
	const int consatant = 20;
	//Printer(consatant);//Error: invalid conversion from 'int' to 'int*'
	cout << "Consatant ��ַ ��" << &consatant << endl; 
	Printer(const_cast<int *>(&consatant));
	cout << "consatant ֵΪ ��" << consatant << endl;
	
	
	//�ڶ������ 
	int variable = 21;
	int* const_p = &variable;
	int* modifier = const_cast<int*>(const_p);
	
	*modifier = 7;
	cout << "variable:" << variable << endl;
	
	return 0;
}
