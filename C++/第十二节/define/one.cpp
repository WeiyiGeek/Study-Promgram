#include "one.h"
//��Ҫ��ʵ�ֶ��巽��
int first(int o){
    std::cout << "First | one: " << ONE << " / 2 = " << o / 2 << "\n";
    return 1;
}

//��Ĺ�����
Def::Def(std::string name,std::string worker){
    std::cout << "---�����ʼ��\n";
    this->name = name;
    this->worker = worker;
}

void Def::oneFun(){
    std::cout << "oneFun: " << name << " | Worker: " << worker << std::endl;
}
