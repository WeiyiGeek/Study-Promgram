#include <iostream>
#include <string>
#include <vector>
/**
    �������������Iterator��
**/

int main(void)
{
    std::vector<std::string> names;
    names.push_back("Weiye");
    names.push_back("Weiy_");
    names.push_back("Weiyi");
    names.push_back("WeiyiGeek");

    //���������������Iterator��������ָ��������ʼλ��
    std::vector<std::string>::iterator itera = names.begin();
    while( itera != names.end() )
    {
        std::cout << *itera << "\n";
        ++itera;  //ָ��ķ�����ֵ��ѧϰ��
    }
    return 0;
}

