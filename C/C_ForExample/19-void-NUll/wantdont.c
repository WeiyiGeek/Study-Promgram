#include <stdio.h>

int main(){
        int array[5] = {1, 2, 3, 4, 5};
        int *pi = &array[2];
        void *pv;

        pv = pi;
        pv++;    //*(pi)+ 1 明线以及跨越数组的长度
        pi = pv;  //随机地址

        printf("%d\n", *pi);

        return 0;
}
