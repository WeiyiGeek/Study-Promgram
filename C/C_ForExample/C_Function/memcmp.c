#include <stdio.h>
#include <string.h>

int main(void)
{
    char str1[10],str2[10];
    int result;
    printf("�����������ַ�����ֵ��\n");
    printf("�ַ��� str1 �� ");
    scanf("%s",str1);
    printf("�ַ��� str2 �� ");
    scanf("%s",str2);
	  result = memcmp(str1, str2, 10);  //�Ա��������ַ�����ǰ10���ֽ�(��ǰ10���ַ�)
    if(result == 0){
        printf("str1 �� str2 ���ڴ����ȵ�\n");
    } else {
        printf("str1 �� str2 ���ڴ�ռ��ǲ�ͬ\n");
    }

    return 0;
}
