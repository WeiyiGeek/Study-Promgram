#include <iostream>

int main(void){
	//声明定义指针变量 
	int *pt;
	int num = 1024;
	//其实与C一样取num变量名地址存放如pt指针中 
	pt = &num;
	
	std::cout << "pt地址为：" << pt << " 或者 " << &num << std::endl; 
	std::cout << "*pt变量值为：" << *pt << std::endl; 

	return 0;
}
