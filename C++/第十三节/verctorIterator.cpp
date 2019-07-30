#include <iostream>
#include <string>
#include <vector>
/**
    容器与迭代器（Iterator）
**/

int main(void)
{
    std::vector<std::string> names;
    names.push_back("Weiye");
    names.push_back("Weiy_");
    names.push_back("Weiyi");
    names.push_back("WeiyiGeek");

    //声明定义迭代器（Iterator），并且指向容器初始位置
    std::vector<std::string>::iterator itera = names.begin();
    while( itera != names.end() )
    {
        std::cout << *itera << "\n";
        ++itera;  //指针的方法（值的学习）
    }
    return 0;
}

