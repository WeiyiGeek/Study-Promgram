#include <iostream>
#include "header.h"

static bool printMe = false;   //�����ӣ�Static��̬�洢��|ֻ���ڱ��ļ���ʹ��|���������ļ�����ͬ������Ӱ�죩

int main()
{
    unsigned short mainNum = 10;  //���ļ�������
    std::cout << mainNum << "! is equal to " << returnFactorial(mainNum) << "\n\n";  //����������ͷ�ļ���
    std::cout << thatNum << "! is equal to " << returnFactorial(thatNum) << "\n\n";
    std::cout << headerNum << "! is equal to " << returnFactorial(headerNum) << "\n\n";

    if(printMe)
    {
        std::cout << "��̬�洢���������ᱻ��ӡ��\n\n";
    }
    return 0;
}
