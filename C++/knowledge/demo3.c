#include <iostream>
#include <stdlib.h>

//ŷ����� շת����� �����Լ��|��С��������
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
    //���Լ��
    void maxCommon(int num1, int num2){
        while(num1 % num2){
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
            r = num1 % num2;
        }
        std::cout << "���Լ����" << num2;
    }

};


int main(void){

    Relation demo(319,377);
    return 0;
}
