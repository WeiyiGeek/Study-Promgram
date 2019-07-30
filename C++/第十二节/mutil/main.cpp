
#include "customs.h"

/**自定义头文件**/

int main(void)
{
    init(NAME,AGE);
    Base *pt = new Base("Lenven","PC");
    pt->print();
    delete pt;
    return 0;
}


