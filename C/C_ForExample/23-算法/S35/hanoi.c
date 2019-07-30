#include <stdio.h>

void haoni(int n,char x, char y,char z);
void haoni(int n,char x, char y,char z){

    if( n == 1){
        printf("1%c --->>> %c\n",x,z);
    }else{
        haoni(n-1,x,z,y);  //关键点1,先显示递归的深处
        printf("2%c --->>> %c\n", x, z);
        haoni(n-1,y,x,z); //关键点2,按照顺序显示
    }
}
int main(void){
    int n;
    printf("请输入汉诺塔的数量：");
    scanf("%d",&n);
    haoni(n, 'x', 'y', 'z');
    return 0;
}