#include <iostream>
/**
 *  �������� ʹ��ָ����ж�ȡ����Ԫ�ص�����
 */
const unsigned short ITEM = 5;
using namespace std;

//���صĺ���
void print(int *num, int *length);
void print(char *chr, char *length);

int main(void)
{
    //��������
    int num[ITEM] = {1,2,3,4,5};
    char chr[ITEM] = {'B','A','I','D','U'};

	cout << "------�������� ʹ��ָ����ж�ȡ����Ԫ�ص�����-----\n" << endl; 
    print(num,num+5);
    cout << "\n" << endl;
    
    print(chr,chr+5);
    cout << "\n" << endl;

    return 0;
}

//Method 1 
void print(int *num, int *length){
//������������ַ��ָ��
    int *nPt = num;
    cout << "Ex1:����ָ������������������" << endl;
    for(;nPt < length; nPt++){
        cout << *nPt << " at " << nPt << endl;
    }

}

//Method 2 
void print(char *cBegin, char *cEnd){
    //������������ַ��ָ��
    cout << "Ex1:����ָ������ַ����������"  << endl;
    while(cBegin != cEnd){
    	cout << *cBegin << " at " << reinterpret_cast<unsigned long>(cBegin) << endl;
		cBegin++;
	}
   
}
