#include <stdio.h>
#define MAX 1024

int main(){
	char str1[2 * MAX];
	char str2[MAX];

	char *tastr1 = str1;
	char *tastr2 = str2;

	int ch,n;
	int index = 1;

	printf("Please input String First:");
	fgets(str1,MAX,stdin);

	printf("Please input String Seconde:");
	fgets(str2,MAX,stdin);

	printf("�Ա��ַ��ĸ���:");
	scanf("%d",&n);

	while (n && *tastr1 != '\0' && *tastr2 != '\0'){  //�ص��·����
                ch = *tastr1;
                if (ch < 0) {
                        if (*tastr1++ != *tastr2++ || *tastr1++ != *tastr2++){ //�ж������ַ� ע������״̬����ִ��һ��
                                break;
                        }
                }
                if (*tastr1++ != *tastr2++){ //�ж�����ָ��һ�����±�ĵ�ַ ���������Ƿ���ͬ
                       break;
                }
                index++;
                n--;
        }

	if ((n == 0) || (*tastr1 == '\0' && *tastr2 == '\0')){  //�ж� n �ǲ��ǵ���0 �����ж��ǲ�����n�Ա�����
                printf("�����ַ�����ǰ %d ���ַ���ȫ��ͬ��\n", index-1); //�����س���Ӱ��
        }
        else{
                printf("�����ַ�������ȫ��ͬ���� %d ���ַ����ֲ�ͬ��\n", index);
        }
}
