#include <stdio.h>

void haoni(int n,char x, char y,char z);
void haoni(int n,char x, char y,char z){

    if( n == 1){
        printf("1%c --->>> %c\n",x,z);
    }else{
        haoni(n-1,x,z,y);  //�ؼ���1,����ʾ�ݹ���
        printf("2%c --->>> %c\n", x, z);
        haoni(n-1,y,x,z); //�ؼ���2,����˳����ʾ
    }
}
int main(void){
    int n;
    printf("�����뺺ŵ����������");
    scanf("%d",&n);
    haoni(n, 'x', 'y', 'z');
    return 0;
}