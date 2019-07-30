#include <iostream>
#include <climits>

/**
    常用的 C++类型长度以及取值范围
**/

int main(){
    std::cout << "| C++各种类型取值范围 |" << std::endl;
    //CHAR_BIT
    std::cout << "CHAR_BIT:" << CHAR_BIT << std::endl;

    //char
    std::cout << "char范围：" << CHAR_MIN  << " - " << CHAR_MAX << "  | 无符号最大取值：" << UCHAR_MAX << " | bit长度：" << sizeof(char) <<std::endl;

    //Short
    std::cout << "short范围：" << SHRT_MIN  << " - " << SHRT_MAX << "  | 无符号最大取值：" << USHRT_MAX <<" | bit长度：" << sizeof(short) <<std::endl;

    //int
    std::cout << "int范围：" << INT_MIN  << " - " << INT_MAX << "  | 无符号最大取值：" << UINT_MAX <<" | bit长度：" << sizeof(int) <<std::endl;;

    //long
    std::cout << "long范围：" << LONG_MIN  << " - " << LONG_MAX << "  | 无符号最大取值：" << ULONG_MAX <<" | bit长度：" << sizeof(long) <<std::endl;;

    //long long
    std::cout << "LONG LONG范围：" << LONG_LONG_MIN  << " - " << LONG_LONG_MAX << "\n        | 无符号最大取值：" << ULONG_LONG_MAX <<" | bit长度：" << sizeof(long long) <<std::endl;;
    std::cout << "LLONG范围：" << LLONG_MIN  << " - " << LLONG_MAX << "\n        | 无符号最大取值：" << ULLONG_MAX <<" | bit长度：" << sizeof(long long) <<std::endl;;


    return 0;
}

