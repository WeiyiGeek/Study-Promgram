#include <iostream>
/**
	ʹ��new �� delete �ؼ��� demo
	ֱ�ӷ����ڴ棬�����趨����� 
**/
int main(void){
	//ֱ�Ӵ���һ��ָ�룬ʹ����ָ���·�����ڴ���� 
	int *intPt = new int;  //4B 
	char *charPt = new char;  //1B 
	*intPt = 1024; 
	*charPt = 'C';
	std::cout << "Value: " << *intPt << " Address:	" << intPt << std::endl;
	std::cout << "Value: " << charPt << "    Address:	" << reinterpret_cast <unsigned long> (charPt) << std::endl;
	//ע��һ��Ҫɾ������new���ڴ�ռ䣨���򲻻��Զ�Delete�� 
	delete intPt;
	delete charPt;
	return 0;
}
