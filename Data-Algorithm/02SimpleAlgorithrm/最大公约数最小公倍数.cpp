#include <iostream>
#include <stdlib.h>

//ŷ����� շת����� �����Լ��|��С��������
class Relation{
public:
    int a,b,result;
    Relation(int num1,int num2){
        //�����ֵ����ǰ��
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
        ���Լ��
        2 % 10 = 2; (2,10)
        10 % 2 = 0;  (10,2) ���ܱ������������Լ��Ϊ2��
    **/
    void maxCommon(int num1, int num2){
        //������Ϊ0ʱ����������Լ��
        while(num1 % num2){
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
            r = num1 % num2;
        }
        std::cout << "���Լ����" << num2;
        result = num2;
    }
    /**
        ���磺��2,10��
        ��С������ = 2 * 10 / 2 (���Լ�� )
    **/
    void minBei(){
        std::cout << "\n��С��������" << a * b / result << "\n";
    }

};


int main(void){
    //���Լ������С������
    Relation demo(319,377);
    demo.minBei();

    return 0;
}
