#include <stdio.h>
//声明定义结构体数组
struct Testarray
{
    int id;
    char name[20];
    float price;
    unsigned int date;
} tarray[3] = {
    {1,"C",88.9,20170101},
    {2,"Python",88.8,20180101},
    {3,"Go",88.6,20180311}
};  //非常注意这里的 ; 号 , 坑啊

int main(void)
{
    int i=0;
    //注意下面这里采用结构体指针指向结构体数组
    struct Testarray *pt;
    pt = tarray;  //由于结构体变量名是数组 则第一个数组地址则为该结构体的地址

    printf("结构体数组：\n");
    for(i; i < 3; i++){
        printf("id = %d, name = %s, price = %.2f, date = %d\n", tarray[i].id, tarray[i].name, tarray[i].price, tarray[i].date);
    }
    putchar('\n');
    printf("采用结构体指针指向结构体数组：\n");
    for (i = 0; i < 3; i++){
        printf("id = %d, name = %s, price = %.2f, date = %d\n", ((pt + i))->id, (pt + i)->name, (*(pt + i)).price, (*(pt + i)).date);
        //对指针变量+1,直接指向数组的下一个下标地址
    }
    return 0;
}