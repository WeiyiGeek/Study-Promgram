#include <iostream>

using namespace std;

int main(void)
{
  
    //声明定义变量
    int a = 1024;
    float b = 12.34;
    char  c = 'c';
    string d= "I love C++ PragramLanguage";

    //创建指针并给指针变量存放变量地址
    int *aPointer = &a;
    float *bPointer = &b;
    char *cPointer = &c;
    string *dPointer = &d;

    cout << "Ex1:\n" << *aPointer << endl;  //利用指针变量输出变量内容
    cout << *bPointer << endl;
    cout  << *cPointer << endl;
    cout << *dPointer << "\n" << endl;

    //对解引用指针重新赋值
   *aPointer = 2048;
   *bPointer = 78.9;
   *cPointer = 'C';
   *dPointer = "String Class demo";

    cout << "Ex2:\n" << a << sizeof(a) << endl; //利用指针变量覆盖的变量值输出变量内容 (变量长度)
    cout << b << endl;
    cout << c << sizeof(c) <<endl;
    cout << d << "\n 字符长度：" << d.length() << endl; //(字符串长度) 


    return 0;
}
