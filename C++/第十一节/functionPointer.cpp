#include <iostream>

int fun(int i,int j);

int main(void){
    //��������ָ��
    int (*funp)(int,int);
    funp = fun; //ָ��һ������
    std::cout << "����ָ���ֵ�ǣ�" << (*funp)(5,6) << "\n";
    return 0;
}
fun(int i,int j){
    return i+j;
}
