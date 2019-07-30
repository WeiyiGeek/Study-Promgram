#include <iostream>

class Complex
{
public:
    Complex(){
        real = 0;
        imag = 0;
    }
    Complex(double r, double i){
       real = r;
       imag = i;
    }
    //���ѵ����Լ��� ����ʵ���ϲ����� this ָ�� �� ��������ַ
    Complex complex_add(Complex &d){
        Complex c;
        //ע�� d.real ��Щ���� ������ ���ô��� ��ʹ��d.��Ա
        c.real = real + d.real;
        c.imag = imag + d.imag;
        return c;
    }
    void print(){
     std::cout << "(" << real << ", " << imag << "i)\n";
    }
private:
    double real;
    double imag;
};

int main()
{
    Complex c1(3, 4), c2(5, -10), c3;
    //ʵ�����������ô���
    c3 = c1.complex_add(c2);

    std::cout << "c1 = ";
    c1.print();
    std::cout << "c2 = ";
    c2.print();
    std::cout << "c1 + c2 = ";
    c3.print();

    return 0;
}
