#include "two.h"
//��Ҫ��ʵ�ֶ��巽��
int second(int o){
    std::cout << "second | two: " << TWO << " / 2 = " << o / 2 << "\n";
    return 2;
}
//�����ȡ��
Def::~Def(){
    std::cout << "---�뿪\n";
}

void Def::twoFun(){
    std::cout << "twoFun: " << name << " | Worker: " << worker << std::endl;
}
