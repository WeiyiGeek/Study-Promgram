#include <iostream>
/**
 *  ָ��������Ĺ�ϵ,����ָ����ж�ȡ����Ԫ�ص�����
 * **/
//����ĳ���
const unsigned short ITEM = 5;

using namespace std;

int main(void)
{
    //��������
    int num[ITEM] = {1,2,3,4,5};
    char chr[ITEM] = {'B','A','I','D','U'};

    //������������ַ��ָ��
    int *nPt = &num[0];
    char *cPt = chr;

    cout << "Ex1:����ָ������������������" << sizeof(num) / sizeof(int) << endl;
    for(int i = 0; i < ITEM; i++){
        cout << *nPt << " at " << nPt << endl;
        nPt ++;
    }

    cout << "Ex1:����ָ������ַ����������" << sizeof(chr)<<endl;
    for(int i = 0; i < ITEM; i++){
        cout << *cPt << " AT " << reinterpret_cast<unsigned long>(cPt) << endl;
        cPt++;
    }

    return 0;
}
