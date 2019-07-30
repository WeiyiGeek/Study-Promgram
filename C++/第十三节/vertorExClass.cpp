#include <iostream>
#include <string>
#include <vector>
#include <math.h>
/**
向量Vector存放类的实例化对象使用案例
**/

class Square{
public:N
    Square(int a, unsigned int b){
        //值的初始化
        this->a = a;
        this->b = b;
        //求出平方
        res = pow(a,b);
    }
    ~Square(){}
    void print(){
        std::cout << a << "的" << b << "次方等于：" << res << "\n";
    }
protected:
    int a;
    unsigned int b;
    int res;
};

int main(void)
{
    Square sq1(2,1);
    Square sq2(2,2);
    Square sq3(-2,3);

    //注意:这里类型是 类名
    std::vector<Square> opers;
    opers.push_back(sq1);
    opers.push_back(sq2);
    opers.push_back(sq3);

    std::cout << "向量存放的实例化对象个数为：" <<  opers.size() << "\n";
    //该处值的学习
    for(int i = 0; i < opers.size(); i++)
    {
        opers[i].print();
    }
    return 0;
}
