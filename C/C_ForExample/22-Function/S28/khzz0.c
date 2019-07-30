#include <stdio.h>

void printf_F();
void printf_I();
void printf_S();
void printf_C();
void printf_H();

void printf_F(){
  printf("########\n");
  printf("##\n");
  printf("##\n");
  printf("########\n");
  printf("##\n");
  printf("##\n");
  printf("##\n");
  
}

void printf_I(){
  printf("########\n");
  printf("   ##   \n");
  printf("   ##   \n");
  printf("   ##   \n");
  printf("   ##   \n");
  printf("   ##   \n");
  printf("########\n");
}

void printf_S(){
  printf(" #####\n");
  printf("##   ##\n");
  printf("##\n");
  printf(" #####\n");
  printf("     ##\n");
  printf("##   ##\n");
  printf(" #####\n");
}

void printf_C(){
  printf(" ######\n");
  printf("##     ##\n");
  printf("##\n");
  printf("##\n");
  printf("##\n");
  printf("##     ##\n");
  printf(" ######\n");
}

void printf_H(){
  printf("##    ##\n");
  printf("##    ##\n");
  printf("##    ##\n");
  printf("########\n");
  printf("##    ##\n");
  printf("##    ##\n");
  printf("##    ##\n");
}

int main()
{
  printf_F();
  putchar('\n');
  printf_I();
  putchar('\n');
  printf_S();
  putchar('\n');
  printf_C();
  putchar('\n');
  printf_H();
  return 0;
}
