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
    //自已调用自己类 这里实际上采用了 this 指针 和 传入对象地址
    Complex complex_add(Complex &d){
        Complex c;
        //注意 d.real 有些特殊 由于是 引用传递 才使用d.成员
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
    //实例化对象并引用传递
    c3 = c1.complex_add(c2);

    std::cout << "c1 = ";
    c1.print();
    std::cout << "c2 = ";
    c2.print();
    std::cout << "c1 + c2 = ";
    c3.print();

    return 0;
}
