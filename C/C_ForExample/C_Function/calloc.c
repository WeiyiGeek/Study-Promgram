#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int i,length,result=0;
    int *ptr;

    printf("�����뽫Ҫ�����ĸ��� ��");
    scanf("%d",&length);
    ptr = (int *)calloc(length,sizeof(int));
	printf("\n�ڴ�ռ��ַ�����ʼ��ֵ��\n");
	for(i = 0; i < length; i++){
		printf("�ռ��ڴ��ַ:%p , ֵΪ %d \n", &ptr[i], ptr[i]);
	}
	putchar('\n');
    for(i = 0; i < length; i++){
        printf("��%d������Ϊ��", i+1);
        scanf("%d",&ptr[i]);
        result += ptr[i];
    }

    printf("������֮��Ϊ ��%d \n",result);

    free(ptr);
    return 0;
}
