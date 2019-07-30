#include <iostream>
#include <string>
#include <stdlib.h>

//有理数 Rational

class Rational
{
public:
    // num = 分子, denom = 分母
    Rational(int num, int denom){
        numerator = num;
        denominator = denom;
        normalize();  //初始化
    }
    Rational operator+(Rational rhs);  // rhs == right hand side
    Rational operator-(Rational rhs);
    Rational operator*(Rational rhs);
    Rational operator/(Rational rhs);

private:
    void normalize(); // 负责对分数的简化处理
    int numerator;    // 分子
    int denominator;  // 分母
    //注意这里我们需要声明一个又元函数
    //使其能访问到类中的私有变量
    friend std::ostream& operator<<(std::ostream& os, Rational f);

};


// normalize() 对分数进行简化操作包括：
// 1. 只允许分子为负数，如果分母为负数则把负数挪到分子部分，如 1/-2 == -1/2
// 2. 利用欧几里德算法（辗转求余原理）将分数进行简化：2/10 => 1/5
void Rational::normalize()
{
    // 确保分母为正
    if( denominator < 0 )
    {
        numerator = -numerator;
        denominator = -denominator;
    }

    // 欧几里德算法 （绝对值）
    int a = abs(numerator);
    int b = abs(denominator);

    // 求出最大公约数 （（就是当 a / b 第一次都能整除的时候也要进行一次循环）
    while( b > 0 )
    {
        int t = a % b;
        a = b;  //a 为最大公约数
        b = t;  //余数为0时候
    }

    // 分子、分母分别除以最大公约数得到最简化分数
    numerator /= a;
    denominator /= a;
}

// a   c   a*d   c*b   a*d + c*b
// - + - = --- + --- = ---------
// b   d   b*d   b*d =    b*d
Rational Rational::operator+(Rational rhs)
{
    //this指针 默认指向 a b
    int a = numerator;
    int b = denominator;
    int c = rhs.numerator;
    int d = rhs.denominator;

    int e = a*b + c*d;
    int f = b*d;

    return Rational(e, f);
}

// a   c   a   -c
// - - - = - + --
// b   d   b   d
Rational Rational::operator-(Rational rhs)
{
    //这里是值得学习的地方，- 及 +
    rhs.numerator = -rhs.numerator;  //注意这里是分子
    return operator+(rhs);
}

// a   c   a*c
// - * - = ---
// b   d   b*d
Rational Rational::operator*(Rational rhs)
{
    int a = numerator;
    int b = denominator;
    int c = rhs.numerator;
    int d = rhs.denominator;

    int e = a*c;
    int f = b*d;

    return Rational(e, f);
}

// a   c   a   d
// - / - = - * -
// b   d   b   c
Rational Rational::operator/(Rational rhs)
{
    //除法 同样是 将 分子分母相交换
    int t = rhs.numerator;
    rhs.numerator = rhs.denominator;
    rhs.denominator = t;

    return operator*(rhs);
}

//声明外部函数
//参数1输出流对象
//参数2Rational类型对象（要写进流的）
std::ostream& operator<<(std::ostream& os,Rational f);

int main()
{
    Rational f1(2, 16);
    Rational f2(7, 8);

    // 测试有理数加法运算
    std::cout << f1 << " + " << f2 << " = " << (f1+f2) << std::endl;
    // 测试有理数减法运算
    std::cout << f1 << " - " << f2 << " = " << (f1-f2) << std::endl;

    // 测试有理数乘法运算
    std::cout << f1 << " * " << f2 << " = " << (f1*f2) << std::endl;

    // 测试有理数除法运算
    std::cout << f1 << " / " << f2 << " = " << (f1/f2) << std::endl;

    return 0;
}
//重载 << 定义  （这里指的学习 - 当 计算后 的值经过 F 对象又进行了一次//初始化，简化了分子分母）
std::ostream& operator<<(std::ostream& os,Rational f){
    os << f.numerator << "/" << f.denominator;
    return os;
}


