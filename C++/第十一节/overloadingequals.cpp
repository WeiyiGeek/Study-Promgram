#include <iostream>
#include <string>
/** 重载 = 案例 复制对象 **/

class MyClass
{
public:
    //构造器
    MyClass(int *p){
          ptr = p;
    }
    //析取器
    ~MyClass(){
        delete ptr;
    }

    //重载赋值运算符号
    MyClass &operator=(const MyClass &rhs){
        // a = b;
    if( this != &rhs )
    {
        delete ptr;  //实际删除了指针指向的地址的内存块
        ptr = NULL;  //清空了指针指向的地址
        ptr = new int;
        *ptr = *rhs.ptr; //传入对象的ptr的指针，存入 左边对象的指针中
    }
    else
    {
        std::cout << "赋值号两边为同个对象，不做处理！\n"; // obj1 = obj1;
    }
        return *this;  //返回对象
    }

    void print(){
        std::cout << this << "  |  " << *ptr << std::endl;
    }
private:
    int *ptr;  //声明一个指针
};

int main()
{
    MyClass obj1(new int(1024));
    MyClass obj2(new int(512));

    obj1.print();
    obj2.print();

    obj2 = obj1;  //将obj1 对象地址 存放给 对象obj2的指针中 （重载）

    obj1.print();
    obj2.print();

    return 0;
}
