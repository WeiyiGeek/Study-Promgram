#include <iostream>

int main(void){
	int num[5] = {0,1,2,3,4};
	char chr[5] = {'y','a','f','a','n'};
	int *pt1 = num;
	char *pt2 = chr;
	 
	std::cout << "��֤ pt1 ָ�����ԣ�" << std::endl;
	std::cout << *pt1 << " At " << pt1 << std::endl;
	std::cout << *(pt1+1)<< " At " << pt1+1 << std::endl; 
	std::cout << *pt1+1 << " At " << pt1+1 << std::endl; 
	
	
	std::cout << "\n��֤ pt1 ָ�����ԣ�" << std::endl;
	std::cout << *pt2 << " At " <<  reinterpret_cast<unsigned int>(pt2)<< std::endl;
	std::cout << *(pt2+1)<< " At " <<  reinterpret_cast<unsigned long>(pt2+1) << std::endl;
	std::cout << *pt2+1 << " At " << "�൱ y ASCII+1 " <<std::endl;   // 122 = z �൱ y ASCII+1 
	return 0;
}
