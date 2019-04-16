#include <iostream>
/**
 *  泛型程序 -->>  使用指针进行读取数组元素的内容
 */
const unsigned short ITEM = 5;
using namespace std;

//泛型程序设计的函数
template <typename elemType>
void print(elemType *cBegin,elemType *cEnd){
    //建立存放数组地址的指针
    cout << "Ex1:利用指针进行字符数组输出："  << endl;
    while(cBegin != cEnd){
    	cout << *cBegin << " at " << reinterpret_cast<unsigned long>(cBegin) << endl;
		cBegin++;
	}
}

int main(void)
{
    //建立数组
    int num[ITEM] = {1,2,3,4,5};
    char chr[ITEM] = {'B','A','I','D','U'};

	cout << "------泛型程序设计 使用指针进行读取数组元素的内容-----\n" << endl; 
    print(num,num+5);
    cout << "\n" << endl;
    
    print(chr,chr+5);
    cout << "\n" << endl;

    return 0;
}

