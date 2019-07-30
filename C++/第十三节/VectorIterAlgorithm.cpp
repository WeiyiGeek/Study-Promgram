#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/**
    容器 迭代器 算法 融合案例
**/

int main(void)
{
    //向量容器
    std::vector<std::string> names;
    names.push_back("Michel");
    names.push_back("Chenjie");
    names.push_back("Lilei");
    names.push_back("Jotjot");
    names.push_back("Westjot");

    //排序算法(排序范围：容器开头到结尾的元素)
    std::sort(names.begin(),names.end());
    std::cout << "名字排序（Sort）后的结果：\n";

    //迭代器（Iterator） - 指向容器元素开头
    std::vector<std::string>::iterator iter = names.begin();
    while(iter != names.end()){
        std::cout << *iter << "\n";
        iter++;
    }
    return 0;
}
