#include <iostream>
/** ʵ�ָ������������������� **/
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
    /**
        ��һ�ַ���
    **/
    Base operator+ (Base &d){
        Base c;
        c.num1 = num1 + d.num1;
        c.num2 = num2 + d.num2;
        return c; //���ض���C
    }
    /**
        �ڶ��ַ���
    **/
    Base operator* (Base &e){
        return Base(num1*e.num1,num2*e.num2);
    }
    void print(){
        std::cout << "(" << num1 << "," << num2 << "i) \n";
    }
private:
    double num1;
    double num2;

};

int main(void){
    //ʵ��������
    Base c1(3,4),c2(5,-10),c3,c4;
    std::cout << "C1 : ";
    c1.print();
    std::cout << "C2 : ";
    c2.print();

    c3 = c1 + c2;
    std::cout << "\nC1 + C2 : ";
    c3.print();

    std::cout << "C2 + C3 : ";
    c4 = c3 + c2;
    c4.print();

    std::cout << "\nC2 * C3 : ";
    c4 = c3 * c2;
    c4.print();

    return 0;
}
