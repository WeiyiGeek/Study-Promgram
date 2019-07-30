#include <iostream>
/**
	使用new 与 delete 关键字 demo
	直接分配内存，而无需定义变量 
**/
int main(void){
	//直接创建一个指针，使其它指向新分配的内存块中 
	int *intPt = new int;  //4B 
	char *charPt = new char;  //1B 
	*intPt = 1024; 
	*charPt = 'C';
	std::cout << "Value: " << *intPt << " Address:	" << intPt << std::endl;
	std::cout << "Value: " << charPt << "    Address:	" << reinterpret_cast <unsigned long> (charPt) << std::endl;
	//注意一定要删除我们new的内存空间（程序不会自动Delete） 
	delete intPt;
	delete charPt;
	return 0;
}
