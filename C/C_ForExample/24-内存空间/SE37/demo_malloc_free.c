#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    int *ptr;
    ptr = (int *)malloc(sizeof(int));
	
    if( ptr == NULL)
    {
      printf("分配内存失败\n");
      exit(1);
    }
	memset(ptr,0,sizeof(int));  //注意如果不对malloc申请的内存空间进行初始化,那将指向随机地址
	printf("申请内存空间后初始化值为：%d\n",*ptr);
	
    printf("请输入一个数字 ：");
    scanf("%d", ptr);

    printf("你输入的数字是 ：%d\n",*ptr);
    free(ptr);
    printf("\n释放内存后的值为：%d\n",*ptr);  //无意义
    return 0;
}
