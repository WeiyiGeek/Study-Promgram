#include <iostream>
/**
C++利用数组求几个数的之和(注意程序的健壮性)
**/
 
int main(void){
 	//为了程序的通用性 （局部变量在栈里面） 
	const unsigned short ITEM = 5; 
	int arr[ITEM];
	//std作用域 
	std::cout << "求" << ITEM << "个数相加之和;\n" << std::endl; 
	for(int i = 0 ; i < ITEM ; i++){ 
		std::cout << "请输入第" << i <<"数值：";
		// 0 1  读取错误返回0 
		// 1 0  成功则返回非0 
		while(!(std::cin >> arr[i])){
			std::cin.clear();  //清理输入
			std::cerr << "输入有误请重新输入\n"; 
		} 	
	}
	
	//注意局部变量一定要初始化否则程序会乱指一个地址 
	int res = 0; 
	for(int i = 0; i < ITEM; i++){
		res += arr[i];
	} 
	std::cout << "数组相加之和为：" << res << "\n";
	std::cout << "平均值为：" << (float)res / ITEM << "\n"; 
	return 0;
}
