#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){

  int i,count=0,number;
  int *ptr = NULL;  //ע����������ʼ��ΪNULL
  do {
	count++;
    printf("�������%d��ֵ(ֱ������-1����) ��",count);
    scanf("%d",&number);
    ptr = (int *)realloc(ptr,count * sizeof(int));  //ע�������countΪ0��������ֵҲ������ NULL��Ҳ���ܷ���һ��ָ��ֵ
	
    if( ptr == NULL)
    {
      printf("������չ�ڴ�ռ�ʧ��\n");
      exit(1);
    }

	ptr[count - 1] = number;

  } while(number != -1);

  printf("�������ֵ �ǣ�");
  for (i = 0; i < count; i++) {
      printf("%d  ", ptr[i]);
  }
  putchar('\n');
  free(ptr);

  return 0;
}
