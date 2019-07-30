#include <iostream>
/**联合类型**/
using namespace std;
//定义联合类型
union mima {
    unsigned long birthday;
    unsigned short ssn;
    char* pet;
} pass; //注意分号

int main(void){
	//对联合体成员赋值 
	pass.birthday = 20170101;
	cout << "生日密码：" << pass.birthday << endl;
	//将字符串赋值给pass联合体pet成员 ，这时将会丢弃birthday成员的值； 
	pass.pet = "DOG-pig";
	cout << "生日宠物：" << pass.pet << endl;	 
	cout << "输出实际是pass.pet值：" << (char*)pass.birthday << endl;
	cout << "pass.birthday输出实际是pass.pet地址：" << pass.birthday << endl;
	return 0;
} 

