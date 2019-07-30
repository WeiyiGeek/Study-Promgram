#include <iostream>
//用户输入判断 ，cin.ignore函数的使用 
int main(void){
	
	char ch;
	std::cout << "是否星期天要去春游?【Y/N】：" ;
	std::cin >> ch; //将接收用户输入  
	std::cout << std::endl; 
	switch(ch){
		case 'y':
		case 'Y':
			std::cout << "## 星期天天气很好，一定会去旅游！\n" << std::endl;
			break; 
		case 'n':
		case 'N':
			std::cout << "** 看来星期天要下雨，我还是在家写歇代码把！\n" << std::endl; 
			break;
		default:
			std::cout << "输入有误！" << std::endl; 
	}	
	
	std::cin.ignore(100,'\n'); //忽略 前100个回车符 
	std::cin.get();  //防止窗口关闭 
	return 0;
}
