#include <iostream>
/** 实现友元函数运算符重载 **/
class Base{
public:
    Base(){
        num1 = 0;
        num2 = 0;
    }
    Base(double a,double b){
        num1 = a ;
        num2 = b;
    }
    //友元函数
   friend Base operator+ (Base &c,Base &d);
    void print(){
        std::cout << "(" << num1 << "," << num2 << "i) \n";
    }
private:
    double num1;
    double num2;
};


//注意，这里作为友元函数，不属于Base，记得别写 :: 咯!
Base operator+(Base &c, Base &d)
{
    return Base(c.num1+d.num1, c.num2+d.num2);
}

class Others{
public:
    double num1;
    double num2;
    Others(){
        num1 = 0;
        num2 = 0;
    }
    Others(double n1,double n2){
        num1 = n1;
        num2 = n2;
    }
};

int main(void){
    //实例化对象
    Base d1(5,6),d2(7,5),d3;

    d3 = d1 + d2;
    std::cout << "d3 = d1 + d2 : ";
    d3.print();

    return 0;
}
