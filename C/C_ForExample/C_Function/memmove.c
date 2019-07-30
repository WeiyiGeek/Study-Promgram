#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{   
    int num[] = {1,2,3,4,5,6};
    int len = sizeof(num),i;  // 数组占用的空间为24B(字节)
    int *ptr;

    ptr = (int *)malloc(len);
    if( ptr == NULL)
    {
        printf("分配内存失败~");
        exit(1);
    } 

    memset(ptr,0,len);  //对于申请的内存空间初始化为0
    memmove(ptr,num,len);  //返回的内存地址是ptr的地址 

	printf("整型num[6] 数组的占用了空间大小 ：%d 字节\n",len);

	for(i = 0; i < (len/sizeof(int)); i++)
	{
		printf("memcpy 函数拷贝内存空间的第%d个值为 ：%d\n", i+1, ptr[i]);
	}
    
    free(ptr);
    return 0;
}