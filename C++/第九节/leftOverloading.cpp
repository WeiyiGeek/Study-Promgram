#include <iostream>
#include <string>
#include <stdlib.h>

//������ Rational

class Rational
{
public:
    // num = ����, denom = ��ĸ
    Rational(int num, int denom){
        numerator = num;
        denominator = denom;
        normalize();  //��ʼ��
    }
    Rational operator+(Rational rhs);  // rhs == right hand side
    Rational operator-(Rational rhs);
    Rational operator*(Rational rhs);
    Rational operator/(Rational rhs);

private:
    void normalize(); // ����Է����ļ򻯴���
    int numerator;    // ����
    int denominator;  // ��ĸ
    //ע������������Ҫ����һ����Ԫ����
    //ʹ���ܷ��ʵ����е�˽�б���
    friend std::ostream& operator<<(std::ostream& os, Rational f);

};


// normalize() �Է������м򻯲���������
// 1. ֻ�������Ϊ�����������ĸΪ������Ѹ���Ų�����Ӳ��֣��� 1/-2 == -1/2
// 2. ����ŷ������㷨��շת����ԭ�����������м򻯣�2/10 => 1/5
void Rational::normalize()
{
    // ȷ����ĸΪ��
    if( denominator < 0 )
    {
        numerator = -numerator;
        denominator = -denominator;
    }

    // ŷ������㷨 ������ֵ��
    int a = abs(numerator);
    int b = abs(denominator);

    // ������Լ�� �������ǵ� a / b ��һ�ζ���������ʱ��ҲҪ����һ��ѭ����
    while( b > 0 )
    {
        int t = a % b;
        a = b;  //a Ϊ���Լ��
        b = t;  //����Ϊ0ʱ��
    }

    // ���ӡ���ĸ�ֱ�������Լ���õ���򻯷���
    numerator /= a;
    denominator /= a;
}

// a   c   a*d   c*b   a*d + c*b
// - + - = --- + --- = ---------
// b   d   b*d   b*d =    b*d
Rational Rational::operator+(Rational rhs)
{
    //thisָ�� Ĭ��ָ�� a b
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
    //������ֵ��ѧϰ�ĵط���- �� +
    rhs.numerator = -rhs.numerator;  //ע�������Ƿ���
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
    //���� ͬ���� �� ���ӷ�ĸ�ཻ��
    int t = rhs.numerator;
    rhs.numerator = rhs.denominator;
    rhs.denominator = t;

    return operator*(rhs);
}

//�����ⲿ����
//����1���������
//����2Rational���Ͷ���Ҫд�����ģ�
std::ostream& operator<<(std::ostream& os,Rational f);

int main()
{
    Rational f1(2, 16);
    Rational f2(7, 8);

    // �����������ӷ�����
    std::cout << f1 << " + " << f2 << " = " << (f1+f2) << std::endl;
    // ������������������
    std::cout << f1 << " - " << f2 << " = " << (f1-f2) << std::endl;

    // �����������˷�����
    std::cout << f1 << " * " << f2 << " = " << (f1*f2) << std::endl;

    // ������������������
    std::cout << f1 << " / " << f2 << " = " << (f1/f2) << std::endl;

    return 0;
}
//���� << ����  ������ָ��ѧϰ - �� ����� ��ֵ���� F �����ֽ�����һ��//��ʼ�������˷��ӷ�ĸ��
std::ostream& operator<<(std::ostream& os,Rational f){
    os << f.numerator << "/" << f.denominator;
    return os;
}


