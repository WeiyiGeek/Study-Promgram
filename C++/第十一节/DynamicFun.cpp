#include <iostream>
/**函数方法返回内存**/

//指针函数
int *newInt(int value);

int main(void){
    int *x = newInt(1024);
    std::cout << "函数方法返回内存的值：" << *x;
    delete x;
    x = NULL;
    return 0;
}


int *newInt(int value){
    //new 一个新的内存块（存放在堆里面）
    int *myInt = new int;
    *myInt = value;
    return myInt; //返回new0申请的地址
}
