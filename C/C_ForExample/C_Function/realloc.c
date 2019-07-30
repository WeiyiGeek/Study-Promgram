#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){

  int i,count=0,number;
  int *ptr = NULL;  //注意这里必须初始化为NULL
  do {
	count++;
    printf("请输入第%d个值(直到输入-1结束) ：",count);
    scanf("%d",&number);
    ptr = (int *)realloc(ptr,count * sizeof(int));  //注意这里的count为0话，返回值也可能是 NULL，也可能返回一个指针值
	
    if( ptr == NULL)
    {
      printf("建立扩展内存空间失败\n");
      exit(1);
    }

	ptr[count - 1] = number;

  } while(number != -1);

  printf("输入的数值 是：");
  for (i = 0; i < count; i++) {
      printf("%d  ", ptr[i]);
  }
  putchar('\n');
  free(ptr);

  return 0;
}
