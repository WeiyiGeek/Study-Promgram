#include "header.h"

unsigned short thatNum = 8; //ȫ�ֱ���
bool printMe = true; //�����ܵ�main.cpp��printMeӰ��

//��׳�
unsigned long returnFactorial(unsigned short num)
{
    unsigned long sum = 1;
    for( int i=1; i <= num; i++ )
    {
        sum *= i;
    }
    if(printMe)
    {
        return sum;
    }
    else
    {
        return 0;
    }
}
