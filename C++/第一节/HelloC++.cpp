#include <iostream> 

//当不使用using来引用名字空间 时候,需要在cout对象前输std::
using namespace std; 

int main(void){
	
	cout << "Hello Wrold,C++ Plus\n" << endl; 
	//std::cout << "Hello Wrold,C++ Plus\n" << std::endl; 

	return 0;
}

