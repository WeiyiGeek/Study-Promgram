#include <iostream>

int fun(int i,int j);

int main(void){
    //声明函数指针
    int (*funp)(int,int);
    funp = fun; //指向一个函数
    std::cout << "函数指针的值是：" << (*funp)(5,6) << "\n";
    return 0;
}
fun(int i,int j){
    return i+j;
}
