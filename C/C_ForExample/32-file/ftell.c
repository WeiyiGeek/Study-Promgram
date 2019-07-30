#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  FILE *fp;
  if((fp = fopen("hello.txt","w")) == NULL)
  {
    printf("文件打开失败！\n");
    exit(EXIT_FAILURE);
  }
  printf("当前文件中指针位置 : %ld\n",ftell(fp));  //获取当前文件指针
  fputc('W',fp);
  printf("当前文件中指针位置 : %ld\n",ftell(fp));
  fputs("eiyiGeek",fp);
  printf("当前文件中指针位置 : %ld\n",ftell(fp));

  rewind(fp); //初始化文件指针到首部
  fputs("Hello Weiyi!\n",fp); //直接覆盖后面的字符
  fclose(fp);
  return 0;
}
