#include <iostream>
#include "header.h"

static bool printMe = false;   //内连接（Static静态存储区|只能在本文件中使用|不受其他文件中相同变量的影响）

int main()
{
    unsigned short mainNum = 10;  //本文件的数字
    std::cout << mainNum << "! is equal to " << returnFactorial(mainNum) << "\n\n";  //函数声明在头文件中
    std::cout << thatNum << "! is equal to " << returnFactorial(thatNum) << "\n\n";
    std::cout << headerNum << "! is equal to " << returnFactorial(headerNum) << "\n\n";

    if(printMe)
    {
        std::cout << "静态存储区（将不会被打印）\n\n";
    }
    return 0;
}
