#include "customs.h"
//����ʵ��
//���ܣ�ʵ�ֳ���ĳ�ʼ����ӡ
void init(std::string na,unsigned short ag){
    std::cout << "---��ʼ������---\n";
    std::cout << "�ҵ����֣�" << na << " , �ҵ����䣺" << ag << std::endl;
}

//�෽����ʵ��
//���ܣ���ʼ����˾���ֺͲ�Ʒ ��ӡ����˾���ֺͲ�Ʒ
Base::Base(std::string com, std::string pro){
    std::cout << "Enter -> Base ��������\n";
    company = com;
    product = pro;
}
Base::~Base(){
    std::cout << "Enter -> Base ��������\n";
}
void Base::print(){
    std::cout << "��˾���ƣ�" << company  << " , ��Ʒ��" << product << "\n";
}
