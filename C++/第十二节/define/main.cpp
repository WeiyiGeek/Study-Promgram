#include "one.h"
#include "two.h"

/**Ԥ����ָ���**/

int main(void){
    //one.CPP two.cpp
    first(ONE);
    second(TWO);
    //���ʵ����
    Def *pt = new Def("WeiyiGeek","��ȫ����ʦ");
    pt->oneFun();
    pt->twoFun();
    delete pt;
    pt = NULL;
    return 0;
}

