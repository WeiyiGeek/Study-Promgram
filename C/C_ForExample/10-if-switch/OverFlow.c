#include <stdio.h>

int main()
{
        char ch[6] = "FishC";
        int i;

        printf("������������ʵ��ַ����(0~5)��");
        scanf("%d", &i);
        if(i >=0 && i<=5){  //��ֹ������� 
       	 printf("%c\n", ch[i]);
		}else{
			printf("�������,����������"); 
		}
        return 0;
}
