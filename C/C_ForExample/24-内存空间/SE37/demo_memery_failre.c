#include <stdio.h>
#include <stdlib.h>
#if 0
int main()
{
    //�ᵼ��CPU/memery�ռ䱬��
    while (1) {
      malloc(1024);  //���벢��ʹ��
    }
    return 0;
}
#endif

int main(void)
{
  int *ptr = NULL;
  int *num = 123;
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
  
  ptr = &num;
	printf("����������¸���ֵ ��%d\n", *ptr);

  free(ptr); //����һ���ֲ�����,�ᵼ�³���ִ���쳣

  return 0;
}
