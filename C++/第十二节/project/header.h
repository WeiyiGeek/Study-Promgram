#ifndef HEADER_H
#define HEADER_H
    extern unsigned short thatNum;   //声明的外链接（extern）
    unsigned long returnFactorial(unsigned short num);  //声明的that.cpp中的函数
    static const unsigned short headerNum = 5;   //特别需要注意这里 不加static const 会报错提示main与that多次定义（所以不建议在头文件中定义）
#endif
