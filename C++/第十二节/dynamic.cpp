
#include <iostream>
#include <string>
/** 动态对象强制类型转换demo
    dynamic_cast <Class *> (value)
 **/

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
    void printInfo(){
        std::cout << name << "公司大量生产了 " << product << "这款产品!\n";
    }
};

int main()
{

    Company *company = new Company("APPLE", "Iphone");  //申请一个存放Company对象内存块
    TechCompany *tecCompany = (TechCompany *)company;  //可以将不同对象进行混合使用()
    tecCompany->printInfo();
    delete company;  //注意这里只需delete 一次，虽然还有tecCompany指针变量，但都是指向同一块内存；（不要重复删除内存块）
    company = NULL;   //并且将指针变量设置为NULL，以便下次使用
    tecCompany = NULL;

    std::cout << "\n----动态对象（相同对象）强制转换-----\n";
    company = new TechCompany("APPLE", "Iphone");  //申请TeacCompany对象的内存块
    tecCompany = dynamic_cast<TechCompany *>(company);  //转换错误将返回NULL指针
    tecCompany->printInfo(); //如果这时引用里面的方法是没有任何问题的；
    if( tecCompany != NULL ){
        std::cout << "成功!\n";
    }else{
        std::cout << "悲催!\n";
    }
    delete company;
    company = NULL;
    tecCompany = NULL;

    std::cout << "\n----动态对象（不同对象）强制转换-----\n";
    company = new Company("APPLE", "Iphone");  //申请TeacCompany对象的内存块
    tecCompany = dynamic_cast<TechCompany *>(company);  //转换错误将返回NULL指针 （不同的对象是不能混合在一起的）虽然是完全继承
    //tecCompany->printInfo(); //如果这时进行引用里面的方法 将会报错
    if( tecCompany != NULL )
    {
        std::cout << "成功!\n";
    }else{
        std::cout << "悲催!\n";
    }
    delete company;
    company = NULL;
    tecCompany = NULL;
    return 0;
}


