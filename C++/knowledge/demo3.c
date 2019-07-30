#include <iostream>
#include <stdlib.h>

//欧几里得 辗转相除法 （最大公约数|最小公倍数）
class Relation{
public:
    int a,b,result;
    Relation(int num1,int num2){
        if(num2 == 0){
            num1 ^= num2;
            num2 ^= num1;
            num1 ^= num2;
        }
        result = 0;
        a = abs(num1);
        b = abs(num2);
        maxCommon(a,b);

    }
    //最大公约数
    void maxCommon(int num1, int num2){
        while(num1 % num2){
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
            r = num1 % num2;
        }
        std::cout << "最大公约数：" << num2;
    }

};


int main(void){

    Relation demo(319,377);
    return 0;
}
