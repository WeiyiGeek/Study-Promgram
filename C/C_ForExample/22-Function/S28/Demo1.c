#include <stdio.h>

void Cprintf();  //空类型,就是无返还值

int main(){  //默认整型
  Cprintf();
  printf("\n");
  Cprintf();
  
  return 0;
}

void Cprintf(/* arguments */) {
  /* code */
  printf(" ####### \n");
  printf("##     ## \n");
  printf("## \n");
  printf("## \n");
  printf("## \n");
  printf("##     ## \n");
  printf(" ####### \n");
}
