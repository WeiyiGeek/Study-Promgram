#include <iostream>
/**
 *  利用重载 使用指针进行读取数组元素的内容
 */
const unsigned short ITEM = 5;
using namespace std;

//重载的函数
void print(int *num, int *length);
void print(char *chr, char *length);

int main(void)
{
    //建立数组
    int num[ITEM] = {1,2,3,4,5};
    char chr[ITEM] = {'B','A','I','D','U'};

	cout << "------利用重载 使用指针进行读取数组元素的内容-----\n" << endl; 
    print(num,num+5);
    cout << "\n" << endl;
    
    print(chr,chr+5);
    cout << "\n" << endl;

    return 0;
}

//Method 1 
void print(int *num, int *length){
//建立存放数组地址的指针
    int *nPt = num;
    cout << "Ex1:利用指针进行整形数组输出：" << endl;
    for(;nPt < length; nPt++){
        cout << *nPt << " at " << nPt << endl;
    }

}

//Method 2 
void print(char *cBegin, char *cEnd){
    //建立存放数组地址的指针
    cout << "Ex1:利用指针进行字符数组输出："  << endl;
    while(cBegin != cEnd){
    	cout << *cBegin << " at " << reinterpret_cast<unsigned long>(cBegin) << endl;
		cBegin++;
	}
   
}
