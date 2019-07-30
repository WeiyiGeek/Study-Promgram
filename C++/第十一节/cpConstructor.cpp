#include <iostream>

/**副本构造器 -- demo **/

//基类
class Bcopy{
public:
    Bcopy(int *p){
        pt = p;
    }
    //副本构造器 - 传引用 (重要) 当在 Base demo3 = demo2; 的时候才调用副本构造器;
    Bcopy(const Bcopy &rhs){
        std::cout << "！Enter 副构器 - \n";
        *this = rhs; //复制对象给当前对象（重载后的= 起了作用）
        std::cout << "！Leave 副构器 ~ \n";
    }
    ~Bcopy(){
        std::cout << "@Enter/Leave 析取器 @ \n";
        delete pt;
        pt = NULL;
    }
    //重载 = 进行对象属性值复制 (重要)
    Bcopy &operator=(const Bcopy &rhs){
        std::cout << "#Enter = 重载 - \n";
        if(this != &rhs){
            delete pt;
            pt = NULL;
            pt = new int;
            *pt = *rhs.pt;  //传入对象的pt的地址里面的值
        }else{
            std::cout << "对象相同.无需Copy！\n";
        }
        std::cout << "#Leave = 重载 - \n";
        return *this;  //这里值得注意
    }
    void print(){
        std::cout << "pt：" << *pt << "\n";
    }
protected:
    int *pt;
};

int main(void){
    //方式1：
    Bcopy demo(new int(1024));
    Bcopy demo1(new int(512));
    demo1 = demo;
    demo.print();

    std::cout << "\n----------------------------------------\n\n";

    //方式2：
    Bcopy demo2(new int(2048));
    Bcopy demo3 = demo2;
    demo3.print();

    //方式3：
    std::cout << "\n----------------------------------------\n\n";
    Bcopy demo4(new int(2048));
    demo4 = demo4;
    demo4.print();

    return 0;
}
