#include <iostream>

int main(void){
	
	enum week {
		Monday,Tuesday,Wednesday,Thursday,Friday
	} toDay;
	
	toDay = Monday; 

	switch (toDay){
		case 0:
			std::cout << "今天是星期1" << std::endl;
			break;
		case 1:
			std::cout << "今天是星期2" << std::endl;
			break;
		case 2:
			std::cout << "今天是星期3" << std::endl;
			break;
		case 3:
			std::cout << "今天是星期4" << std::endl;
			break;
		case 4:
			std::cout << "今天是星期5" << std::endl;
			break;
		default:
			std::cerr << "输入有误！" << std::endl; 
	}
	
	std::cout << "枚举索引：" << toDay << std::endl;
	
	return 0;
}
