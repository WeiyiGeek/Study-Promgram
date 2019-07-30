#include <stdio.h>

struct Bdate //非常注意这里是声明结构的而不是定义结构体的
{
    unsigned int years;
    unsigned int month;
    unsigned int day;
}; //非常注意这里的 ; 号

struct Birthinfo
{
    char name[40];
    char sex;
    struct Bdate date; //嵌套使用机构
    char address[60];
} birinfo = {"Weiyi", 'x', {2018, 3, 11}, "重庆大学城->重庆大学"};

int main(void)
{
    struct Birthinfo *pt; //这里就是声明 指向Birthinfo结构体的指针变量pt , *pt叫结构体指针
    pt = &birinfo;  //将结构体地址(对结构体变量进行取地址)赋值给pt指针变量

    printf("姓名 ：%s\n", (*pt).name);
    printf("性别 ：%s\n",((pt->sex) == 'x')?"男":"女");
    printf("出生日期 ： %u-%u-%u\n", (*pt).date.years, (*pt).date.month, (*pt).date.day);
    printf("出生地址 ：%s\n", pt->address); //最好 “->”左右无空格
    return 0;
}