#include <stdio.h>

long fact(int nun);  //采用循环的方式
long factup(int nun);  //采用递归的方式

long fact(int num){
    long result; //由于递归出来的数较大,所以建议用long数据类型
    for(result = 1;num > 1;num--){
        result *= num;
    }
    return result;
}
long factup(int num){
    long result;
    if(num > 0){
        result = num * factup(num-1);  //非常注意这里,这里是将返回值给factup函数在进行num值相乘,类似于 1 * 2 * 3 * 4 *5 = 120;
        printf("num : %d , result= %ld\n", num, result);
    }else{
        result = 1;
    }
    return result;
}

int main(void){
    int num;
    printf("请输入一个正整数：");
    scanf("%d",&num);
    printf("利用For循环实现的%d的阶乘是：%ld\n", num, fact(num));
    printf("利用递归循环实现的%d的阶乘是：%ld\n", num, factup(num));
    return 0;
}
