#include <iostream>

using namespace std;

int main(void)
{
  
    //�����������
    int a = 1024;
    float b = 12.34;
    char  c = 'c';
    string d= "I love C++ PragramLanguage";

    //����ָ�벢��ָ�������ű�����ַ
    int *aPointer = &a;
    float *bPointer = &b;
    char *cPointer = &c;
    string *dPointer = &d;

    cout << "Ex1:\n" << *aPointer << endl;  //����ָ����������������
    cout << *bPointer << endl;
    cout  << *cPointer << endl;
    cout << *dPointer << "\n" << endl;

    //�Խ�����ָ�����¸�ֵ
   *aPointer = 2048;
   *bPointer = 78.9;
   *cPointer = 'C';
   *dPointer = "String Class demo";

    cout << "Ex2:\n" << a << sizeof(a) << endl; //����ָ��������ǵı���ֵ����������� (��������)
    cout << b << endl;
    cout << c << sizeof(c) <<endl;
    cout << d << "\n �ַ����ȣ�" << d.length() << endl; //(�ַ�������) 


    return 0;
}
