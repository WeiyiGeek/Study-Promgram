#include <iostream>
#include <string>
/**
函数模板的案例
进行不同值得交换
**/
//模板 且使用模板的时候直接使用（无需声明）
template <class T>
//T 代表任意的数据类型（这里就与重载不同了，重载需要每次进行不同类型的声明）
void funSwap(T &a, T &b){
    T temp;
    temp = a;
    a = b;
    b = temp;
}

int main(void){
    int i1 = 1024;
    int i2 = 512;
    std::cout << "交换前：i1 = " << i1 << ", i2 = " << i2 << std::endl;
    funSwap(i1,i2);
    std::cout << "交换后：i1 = " << i1 << ", i2 = " << i2 << std::endl;

    std::string i3 = "WeiyiGeek";
    std::string i4 = "Hacker";
    std::cout << "交换前：i3 = " << i3 << ", i4 = " << i4 << std::endl;
    funSwap(i3,i4);
    std::cout << "交换后：i3 = " << i3 << ", i4 = " << i4 << std::endl;

    return 0;
}




