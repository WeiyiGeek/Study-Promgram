#include <iostream>
/**
 *  指针与数组的关系,利用指针进行读取数组元素的内容
 * **/
//数组的长度
const unsigned short ITEM = 5;

using namespace std;

int main(void)
{
    //建立数组
    int num[ITEM] = {1,2,3,4,5};
    char chr[ITEM] = {'B','A','I','D','U'};

    //建立存放数组地址的指针
    int *nPt = &num[0];
    char *cPt = chr;

    cout << "Ex1:利用指针进行整形数组输出：" << sizeof(num) / sizeof(int) << endl;
    for(int i = 0; i < ITEM; i++){
        cout << *nPt << " at " << nPt << endl;
        nPt ++;
    }

    cout << "Ex1:利用指针进行字符数组输出：" << sizeof(chr)<<endl;
    for(int i = 0; i < ITEM; i++){
        cout << *cPt << " AT " << reinterpret_cast<unsigned long>(cPt) << endl;
        cPt++;
    }

    return 0;
}
