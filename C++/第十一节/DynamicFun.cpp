#include <iostream>
/**�������������ڴ�**/

//ָ�뺯��
int *newInt(int value);

int main(void){
    int *x = newInt(1024);
    std::cout << "�������������ڴ��ֵ��" << *x;
    delete x;
    x = NULL;
    return 0;
}


int *newInt(int value){
    //new һ���µ��ڴ�飨����ڶ����棩
    int *myInt = new int;
    *myInt = value;
    return myInt; //����new0����ĵ�ַ
}
