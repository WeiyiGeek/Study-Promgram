#include <stdio.h>
int main(){
        void *a;
        printf("%d\n", sizeof(a));   //输出4,由于输出站位符来决定通用指针类型,从而确定大小
        printf("%d\n", sizeof(void *));          
        return 0;
}
