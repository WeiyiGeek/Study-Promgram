#include <stdio.h>
#include <string.h>  //依赖的头文件
#include <errno.h>   //同上

void main()
{
	int errnum;
	for(errnum = 1; errnum < 43; errnum++){
    printf("error %d : %s\n", errnum, strerror(errnum));
  }
	printf("\n");
}
