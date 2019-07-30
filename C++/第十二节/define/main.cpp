#include "one.h"
#include "two.h"

/**预编译指令处理**/

int main(void){
    //one.CPP two.cpp
    first(ONE);
    second(TWO);
    //类的实例化
    Def *pt = new Def("WeiyiGeek","安全工程师");
    pt->oneFun();
    pt->twoFun();
    delete pt;
    pt = NULL;
    return 0;
}

