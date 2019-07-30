#include <stdio.h>

struct Birdate  //非常注意这里是声明结构的而不是定义结构体的
{
    unsigned int years;
    unsigned int month;
    unsigned int day;
}; //非常注意这里的 ; 号

struct Birthinfo
{
    char name[40];
    char sex;
    struct Birdate date;
} birinfo = {"Weiyi",'x',{2018,3,11}};

int main(void)
{
    printf("名字：%s\n", birinfo.name);
    if (birinfo.sex == 'x'){
        printf("性别：%s\n", "男");
    }else{
        printf("性别：%s\n", "女");
    }
    printf("出生日期：%u-%u-%u\n", birinfo.date.years, birinfo.date.month, birinfo.date.day);  //向结构体最底层推进
   return 0;
}