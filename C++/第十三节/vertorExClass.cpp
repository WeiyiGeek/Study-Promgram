#include <iostream>
#include <string>
#include <vector>
#include <math.h>
/**
����Vector������ʵ��������ʹ�ð���
**/

class Square{
public:N
    Square(int a, unsigned int b){
        //ֵ�ĳ�ʼ��
        this->a = a;
        this->b = b;
        //���ƽ��
        res = pow(a,b);
    }
    ~Square(){}
    void print(){
        std::cout << a << "��" << b << "�η����ڣ�" << res << "\n";
    }
protected:
    int a;
    unsigned int b;
    int res;
};

int main(void)
{
    Square sq1(2,1);
    Square sq2(2,2);
    Square sq3(-2,3);

    //ע��:���������� ����
    std::vector<Square> opers;
    opers.push_back(sq1);
    opers.push_back(sq2);
    opers.push_back(sq3);

    std::cout << "������ŵ�ʵ�����������Ϊ��" <<  opers.size() << "\n";
    //�ô�ֵ��ѧϰ
    for(int i = 0; i < opers.size(); i++)
    {
        opers[i].print();
    }
    return 0;
}
