/**
    fileName:customs.h
    Create:2018��12��9��11:06:49
    Author:WeiyiGeek
    function:Class & FUNCTION
    last editer time ��2018��12��9��11:08:08
**/
#include <iostream>

//ȫ�ֱ���
const std::string NAME = "WeiyiGeek";
const unsigned short AGE = 22;

//����ʵ��
void init(std::string na,unsigned short ag);


//�������
class Base{
public:
    Base(std::string com, std::string pro);
    ~Base();
    void print();
protected:
    std::string company;
    std::string product;
};


