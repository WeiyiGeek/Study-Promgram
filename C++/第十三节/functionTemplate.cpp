#include <iostream>
#include <string>
/**
����ģ��İ���
���в�ֵͬ�ý���
**/
//ģ�� ��ʹ��ģ���ʱ��ֱ��ʹ�ã�����������
template <class T>
//T ����������������ͣ�����������ز�ͬ�ˣ�������Ҫÿ�ν��в�ͬ���͵�������
void funSwap(T &a, T &b){
    T temp;
    temp = a;
    a = b;
    b = temp;
}

int main(void){
    int i1 = 1024;
    int i2 = 512;
    std::cout << "����ǰ��i1 = " << i1 << ", i2 = " << i2 << std::endl;
    funSwap(i1,i2);
    std::cout << "������i1 = " << i1 << ", i2 = " << i2 << std::endl;

    std::string i3 = "WeiyiGeek";
    std::string i4 = "Hacker";
    std::cout << "����ǰ��i3 = " << i3 << ", i4 = " << i4 << std::endl;
    funSwap(i3,i4);
    std::cout << "������i3 = " << i3 << ", i4 = " << i4 << std::endl;

    return 0;
}




