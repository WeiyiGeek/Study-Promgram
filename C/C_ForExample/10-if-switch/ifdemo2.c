#include <stdio.h>
int main(){
    int old;
    printf("请输入你的年龄:");
    scanf("%d",&old);
    if (old >= 18){
        printf("你成年了！\n");
    }else{
        printf("你还没有成年哟！！\n");
    }
}
