#include <iostream>
#include <string>
#include <vector>
/**演示vector向量使用的案例**/

int main(void)
{
    //定义一个向量容器
    std::vector<std::string> names;
    names.push_back("第一个向量元素");
    names.push_back("第二个向量元素");
    names.push_back("第三个向量元素");

    //容器中元素的个数
    unsigned int cunt = names.size();
    std::cout <<"容器中元素的个数: " << cunt << "\n";
    for(int i=0; i < cunt; i++){
        std::cout << names[i] << "\n";
    }
    return 0;
}
