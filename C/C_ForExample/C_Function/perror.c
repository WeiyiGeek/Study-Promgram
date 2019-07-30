#include <stdio.h>
#include <stdlib.h>

int main()
{
  FILE *fp;
  if((fp = fopen("error1.txt","r+b")) == NULL){
    perror("打开文件失败原因是:");  //并输出错误的原因
    return -1;  //注意这里是坑,如果不写会爆出分段错误
  }else{
    fprintf(stderr, "Sucessful\n");
  }
  fclose(fp);
  return 0;
}
