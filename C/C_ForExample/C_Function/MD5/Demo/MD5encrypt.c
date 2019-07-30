#include <stdio.h>
#include <string.h>
#include "md5.h"
void md5(unsigned char *dest, unsigned char *src);
void md5(unsigned char *dest, unsigned char *src)
{
  MD5_CTX md5;  //*context
  MD5Init(&md5);
  MD5Update(&md5, src, strlen((char *)src));
  MD5Final(&md5, dest);
  for(int i = 0; i < 16; i++){
    printf("%02x",dest[i]);
  }
}

int main()
{
  FILE *fp;
  int ch = 1;
  unsigned char src[128];
  unsigned char dest[16];
  if((fp = fopen("MD5decode.txt","rb+")) == NULL){
    perror("读取文件失败：");
    return -1;
  }
	while(!feof(fp)){
    fgets(src,7,fp);
    getc(fp);
  	printf("%s:",src);
  	md5(dest,src);
    putchar('\n');
	}
  fclose(fp);
  return 0;
}
