#include <stdio.h>
#define MAX 1024

int main(){
	char str1[2 * MAX];   // ȷ�����Ӻ�Խ�� ���������λ��С
	char str2[MAX];
	
	char *chstr1 = str1;
	char *chstr2 = str2;
	
	printf("String first:");
	fgets(str1,MAX,stdin);
	
	printf("String seconde:");
	fgets(str2,MAX,stdin);
	
	printf("\n------------����ƴ���ַ���--------------\n");
	
	while (*chstr1++ != '\0')  // ��ָ��ָ�� str1 ��ĩβ�� ,targetָ�� '\0' �ĵ�ַ
		;
	chstr1 -= 2;    // ����ϣ�� str1 ���ߵ� '\0' �� '\n' �������ǵ�
	
	while ((*chstr1++ = *chstr2++) != '\0')  // ��str1 ȥ��'\0','\n'���������ַ���str1
		;
		
	printf("�����ƴ���ַ�����%s",str1);
	return 0;
}


