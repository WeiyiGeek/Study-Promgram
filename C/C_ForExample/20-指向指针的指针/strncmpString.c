#include <stdio.h>
#define MAX 1024

int main(){
        char str1[MAX];
        char str2[MAX];

        char *target1 = str1;
        char *target2 = str2;

        int index = 1;

        printf("�������һ���ַ�����");
        fgets(str1, MAX, stdin);

        printf("������ڶ����ַ�����");
        fgets(str2, MAX, stdin);

        while (*target1 != '\0' && *target2 != '\0'){  //��·��ֵ �Ա��������ַ����� '\0',�ڽ��бȽ�
                if (*target1++ != *target2++){  //ͬʱ��ͬһ�����ĵ�ַ�����ֵ�ǲ�����ͬ
                       break;
                }
                index++; //�ַ�λ�õ���
        }

        if (*target1 == '\0' && *target2 == '\0'){  //ƥ������ĩβ�Ƿ���ͬ
                printf("�����ַ�����ȫһ�£�\n");
        }
        else{
                printf("�����ַ�������ȫ��ͬ���� %d ���ַ����ֲ�ͬ��\n", index);
        }
        return 0;
}
