#include <iostream>
#include <climits>

/**
    ���õ� C++���ͳ����Լ�ȡֵ��Χ
**/

int main(){
    std::cout << "| C++��������ȡֵ��Χ |" << std::endl;
    //CHAR_BIT
    std::cout << "CHAR_BIT:" << CHAR_BIT << std::endl;

    //char
    std::cout << "char��Χ��" << CHAR_MIN  << " - " << CHAR_MAX << "  | �޷������ȡֵ��" << UCHAR_MAX << " | bit���ȣ�" << sizeof(char) <<std::endl;

    //Short
    std::cout << "short��Χ��" << SHRT_MIN  << " - " << SHRT_MAX << "  | �޷������ȡֵ��" << USHRT_MAX <<" | bit���ȣ�" << sizeof(short) <<std::endl;

    //int
    std::cout << "int��Χ��" << INT_MIN  << " - " << INT_MAX << "  | �޷������ȡֵ��" << UINT_MAX <<" | bit���ȣ�" << sizeof(int) <<std::endl;;

    //long
    std::cout << "long��Χ��" << LONG_MIN  << " - " << LONG_MAX << "  | �޷������ȡֵ��" << ULONG_MAX <<" | bit���ȣ�" << sizeof(long) <<std::endl;;

    //long long
    std::cout << "LONG LONG��Χ��" << LONG_LONG_MIN  << " - " << LONG_LONG_MAX << "\n        | �޷������ȡֵ��" << ULONG_LONG_MAX <<" | bit���ȣ�" << sizeof(long long) <<std::endl;;
    std::cout << "LLONG��Χ��" << LLONG_MIN  << " - " << LLONG_MAX << "\n        | �޷������ȡֵ��" << ULLONG_MAX <<" | bit���ȣ�" << sizeof(long long) <<std::endl;;


    return 0;
}

