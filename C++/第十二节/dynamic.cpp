
#include <iostream>
#include <string>
/** ��̬����ǿ������ת��demo
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
    void printInfo(){
        std::cout << name << "��˾���������� " << product << "����Ʒ!\n";
    }
};

int main()
{

    Company *company = new Company("APPLE", "Iphone");  //����һ�����Company�����ڴ��
    TechCompany *tecCompany = (TechCompany *)company;  //���Խ���ͬ������л��ʹ��()
    tecCompany->printInfo();
    delete company;  //ע������ֻ��delete һ�Σ���Ȼ����tecCompanyָ�������������ָ��ͬһ���ڴ棻����Ҫ�ظ�ɾ���ڴ�飩
    company = NULL;   //���ҽ�ָ���������ΪNULL���Ա��´�ʹ��
    tecCompany = NULL;

    std::cout << "\n----��̬������ͬ����ǿ��ת��-----\n";
    company = new TechCompany("APPLE", "Iphone");  //����TeacCompany������ڴ��
    tecCompany = dynamic_cast<TechCompany *>(company);  //ת�����󽫷���NULLָ��
    tecCompany->printInfo(); //�����ʱ��������ķ�����û���κ�����ģ�
    if( tecCompany != NULL ){
        std::cout << "�ɹ�!\n";
    }else{
        std::cout << "����!\n";
    }
    delete company;
    company = NULL;
    tecCompany = NULL;

    std::cout << "\n----��̬���󣨲�ͬ����ǿ��ת��-----\n";
    company = new Company("APPLE", "Iphone");  //����TeacCompany������ڴ��
    tecCompany = dynamic_cast<TechCompany *>(company);  //ת�����󽫷���NULLָ�� ����ͬ�Ķ����ǲ��ܻ����һ��ģ���Ȼ����ȫ�̳�
    //tecCompany->printInfo(); //�����ʱ������������ķ��� ���ᱨ��
    if( tecCompany != NULL )
    {
        std::cout << "�ɹ�!\n";
    }else{
        std::cout << "����!\n";
    }
    delete company;
    company = NULL;
    tecCompany = NULL;
    return 0;
}


