
#include <iostream>
#include <string>
/** ��̬����ǿ������ת��demo **/

class Company
{
public:
    Company(std::string theName, std::string product){
        name = theName;
        this->product = product;
    }
    virtual void printInfo(){
        std::cout << "�����˾�����ֽУ�" << name <<"��������" << product << "\n";
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
    //�麯��
     virtual void printInfo(){
        std::cout << name << "��˾���������� " << product << "����Ʒ!\n";
    }
};

int main()
{
    //����һ�����TechCompany�����ڴ��
    Company *company = new TechCompany("APPLE", "Iphone");
    TechCompany *tecCompany = (TechCompany *)company;   //��̬����ǿ������ת�� ��Ҫ��company����ǿ��ת����ΪTechCompany����

    tecCompany->printInfo();

    delete company;  //ע������ֻ��delete һ�Σ���Ȼ����tecCompanyָ�������������ָ��ͬһ���ڴ棻����Ҫ�ظ�ɾ���ڴ�飩
    company = NULL;   //���ҽ�ָ���������ΪNULL���Ա��´�ʹ��
    tecCompany = NULL;

    return 0;
}

