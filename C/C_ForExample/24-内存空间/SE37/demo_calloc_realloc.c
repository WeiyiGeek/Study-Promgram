#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int *ptr = NULL;  //ע�����ʹ�� realloc ���� ����� ptr ��Ҫ��ʼ��ΪNULL ������ģ�
  //int *num = 123;
 // ptr = (int *)realloc(ptr,1 * sizeof(int));  //����������·����ڴ�ռ亯��
    ptr = (int *)calloc(1,sizeof(int));
  if( ptr == NULL)
  {
    printf("�����ڴ�ʧ�ܣ�\n");
    exit(1);
  }
  printf("��ʼ����ֵ ��%d\n", *ptr);
  printf("������һ���� ��");
  scanf("%d",ptr);

  printf("��������ֵ ��%d\n", *ptr);
  
  //ptr = &num;
  //printf("����������¸���ֵ ��%d\n", *ptr);

  free(ptr); //����һ���ֲ�����,�ᵼ�³���ִ���쳣
  return 0;
}
