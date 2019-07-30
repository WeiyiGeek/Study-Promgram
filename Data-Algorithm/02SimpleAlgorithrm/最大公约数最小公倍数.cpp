#include <iostream>
#include <stdlib.h>

//欧几里得 辗转相除法 （最大公约数|最小公倍数）
class Relation{
public:
    int a,b,result;
    Relation(int num1,int num2){
        //将最大值放在前面
        if(num2 == 0 || num1 < num2){
            num1 ^= num2;
            num2 ^= num1;
            num1 ^= num2;
        }
        result = 0;
        a = abs(num1);
        b = abs(num2);
        std::cout << "a = " << a << "  b = " << b << std::endl;
        maxCommon(a,b);
    }
    /**
        最大公约数
        2 % 10 = 2; (2,10)
        10 % 2 = 0;  (10,2) （能被整除所以最大公约数为2）
    **/
    void maxCommon(int num1, int num2){
        //当整除为0时候则出现最大公约数
        while(num1 % num2){
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
            r = num1 % num2;
        }
        std::cout << "最大公约数：" << num2;
        result = num2;
    }
    /**
        例如：（2,10）
        最小公倍数 = 2 * 10 / 2 (最大公约数 )
    **/
    void minBei(){
        std::cout << "\n最小公倍数：" << a * b / result << "\n";
    }

};


int main(void){
    //最大公约数与最小公倍数
    Relation demo(319,377);
    demo.minBei();

    return 0;
}
