#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    int *ptr;
    ptr = (int *)malloc(sizeof(int));
	
    if( ptr == NULL)
    {
      printf("�����ڴ�ʧ��\n");
      exit(1);
    }
	memset(ptr,0,sizeof(int));  //ע���������malloc������ڴ�ռ���г�ʼ��,�ǽ�ָ�������ַ
	printf("�����ڴ�ռ���ʼ��ֵΪ��%d\n",*ptr);
	
    printf("������һ������ ��");
    scanf("%d", ptr);

    printf("������������� ��%d\n",*ptr);
    free(ptr);
    printf("\n�ͷ��ڴ���ֵΪ��%d\n",*ptr);  //������
    return 0;
}
