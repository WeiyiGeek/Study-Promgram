#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
  int i,len;
  int *ptr;

  //内存申请 8 * int(大小)
  ptr = (int *)malloc(8 * sizeof(int));    //由于系统int类型的字节长度不一样不一样所以考虑到兼容性
  if ( ptr == NULL) {
      printf("内存空间申请失败！\n");
      exit(1);
  }
  printf("正在对内存空间初始化.....为0；\n");
  //对于内存空间的初始化为0;
  memset(ptr, 0, 8 * sizeof(int));

  for (i = 0; i < 8 ; i++) {
    printf("这个是初始化第%d个数为 %d \n", i+1, ptr[i]);
  }
  //释放内存
  free(ptr);
  return 0;
}
