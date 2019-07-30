#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int i,length;
  char *buf;
  printf("请输入字符串的长度 ：");
  scanf("%d",&length);

  buf = (char *)malloc(length + 1);   //对于多存储的 '\0'
  if(buf == NULL){
    printf("申请内存失败....\n");
    exit(1);
  }
  printf("请输入%d个字符的字符串 ： ",length);
  getchar();  //清除上一次输入残留的'\n'字符

  for (i = 0; i < length; i++) {
    buf[i] = (char)getchar();  //直接将字符写入内存地址中更加的方便
  }
  buf[length] = '\0';
  printf("你输入的字符串是：%s\n", buf);

  printf("释放申请的内存非常重要(important)\n");
  free(buf); //释放申请的内存非常重要(important)

  return 0;
}
