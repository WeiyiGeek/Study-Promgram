#include <stdio.h>
/*
#include <stdlib.h>
int main(){
	char str[100];
	while(1){
		printf("������һ���ַ���");
		scanf("%s",&str);
		printf("ת�����:%d\n",atoi(str));
	}
	
}*/
int main(){
        int ch;
        int num = 0;
        printf("�������ת�����ַ�����");
        do{
                ch = getchar();
                if (ch >= '0' && ch <= '9'){
                        num = 10 * num + (ch - '0'); //������� ��10+ 1 -��110 + 1
                }
                else{
                        if (num){
                                break; // ����������֣����˳�ѭ��
                        }
                }
        }
        while (ch != '\n');
        printf("����ǣ�%d\n", num);
        return 0;
}
