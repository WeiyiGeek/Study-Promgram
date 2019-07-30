#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int i,length,result=0;
    int *ptr;

    printf("请输入将要相数的个数 ：");
    scanf("%d",&length);
    ptr = (int *)calloc(length,sizeof(int));
	printf("\n内存空间地址及其初始化值：\n");
	for(i = 0; i < length; i++){
		printf("空间内存地址:%p , 值为 %d \n", &ptr[i], ptr[i]);
	}
	putchar('\n');
    for(i = 0; i < length; i++){
        printf("第%d个数是为：", i+1);
        scanf("%d",&ptr[i]);
        result += ptr[i];
    }

    printf("所有数之和为 ：%d \n",result);

    free(ptr);
    return 0;
}
