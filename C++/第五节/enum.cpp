#include <iostream>

int main(void){
	
	enum week {
		Monday,Tuesday,Wednesday,Thursday,Friday
	} toDay;
	
	toDay = Monday; 

	switch (toDay){
		case 0:
			std::cout << "����������1" << std::endl;
			break;
		case 1:
			std::cout << "����������2" << std::endl;
			break;
		case 2:
			std::cout << "����������3" << std::endl;
			break;
		case 3:
			std::cout << "����������4" << std::endl;
			break;
		case 4:
			std::cout << "����������5" << std::endl;
			break;
		default:
			std::cerr << "��������" << std::endl; 
	}
	
	std::cout << "ö��������" << toDay << std::endl;
	
	return 0;
}
