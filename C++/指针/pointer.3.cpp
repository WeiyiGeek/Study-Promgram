#include <iostream>
/**
 *  ���ͳ��� -->>  ʹ��ָ����ж�ȡ����Ԫ�ص�����
 */
const unsigned short ITEM = 5;
using namespace std;

//���ͳ�����Ƶĺ���
template <typename elemType>
void print(elemType *cBegin,elemType *cEnd){
    //������������ַ��ָ��
    cout << "Ex1:����ָ������ַ����������"  << endl;
    while(cBegin != cEnd){
    	cout << *cBegin << " at " << reinterpret_cast<unsigned long>(cBegin) << endl;
		cBegin++;
	}
}

int main(void)
{
    //��������
    int num[ITEM] = {1,2,3,4,5};
    char chr[ITEM] = {'B','A','I','D','U'};

	cout << "------���ͳ������ ʹ��ָ����ж�ȡ����Ԫ�ص�����-----\n" << endl; 
    print(num,num+5);
    cout << "\n" << endl;
    
    print(chr,chr+5);
    cout << "\n" << endl;

    return 0;
}

