#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

/**
    ���� ������ �㷨 �ںϰ���
**/

int main(void)
{
    //��������
    std::vector<std::string> names;
    names.push_back("Michel");
    names.push_back("Chenjie");
    names.push_back("Lilei");
    names.push_back("Jotjot");
    names.push_back("Westjot");

    //�����㷨(����Χ��������ͷ����β��Ԫ��)
    std::sort(names.begin(),names.end());
    std::cout << "��������Sort����Ľ����\n";

    //��������Iterator�� - ָ������Ԫ�ؿ�ͷ
    std::vector<std::string>::iterator iter = names.begin();
    while(iter != names.end()){
        std::cout << *iter << "\n";
        iter++;
    }
    return 0;
}
