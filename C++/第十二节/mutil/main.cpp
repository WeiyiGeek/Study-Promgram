
#include "customs.h"

/**�Զ���ͷ�ļ�**/

int main(void)
{
    init(NAME,AGE);
    Base *pt = new Base("Lenven","PC");
    pt->print();
    delete pt;
    return 0;
}


