
#include <iostream>
#include <string>
/** 静态对象强制类型转换demo **/

class Company
{
public:
    Company(std::string theName, std::string product){
        name = theName;
        this->product = product;
    }
    virtual void printInfo(){
        std::cout << "这个公司的名字叫：" << name <<"正在生产" << product << "\n";
    }

protected:
    std::string name;
    std::string product;
};

class TechCompany : public Company
{
public:
    TechCompany(std::string theName, std::string product):Company(theName, product){
    }
    //虚函数
     virtual void printInfo(){
        std::cout << name << "公司大量生产了 " << product << "这款产品!\n";
    }
};

int main()
{
    //申请一个存放TechCompany对象内存块
    Company *company = new TechCompany("APPLE", "Iphone");
    TechCompany *tecCompany = (TechCompany *)company;   //静态对象强制类型转换 需要将company对象强制转换成为TechCompany对象

    tecCompany->printInfo();

    delete company;  //注意这里只需delete 一次，虽然还有tecCompany指针变量，但都是指向同一块内存；（不要重复删除内存块）
    company = NULL;   //并且将指针变量设置为NULL，以便下次使用
    tecCompany = NULL;

    return 0;
}

