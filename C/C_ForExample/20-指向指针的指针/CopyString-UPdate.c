#include <stdio.h>
#include <string.h>
#define MAX 1024

int main(){
	char str1[MAX];
	char str2[MAX];
	
	char *target1 = str1;
	char *target2 = str2;
	
	int ch;
	int n;  //�����ȡ���ַ�����
	
	printf("������str1���ַ�����");
		fgets(str1,MAX,stdin);
	printf("������Ҫ��ȡ�ַ��ĸ�����");
		scanf("%d",&n);
	printf("\n------����Copy�ַ���------\n");
	 	while(n--){
	 		ch = *target2++ = *target1++;
	 		if(ch == '\0'){
	 			break;
			 } 
			if((int)ch < 0){  //���ں�����linuxռ3�ֽڣ����е�ַ+2  
				*target2++ = *target1++;  //���ҵ���  ������������Windows����ռ�������ֽڣ�����ע����һ�б��ʽ 
			//	*target2++ = *target1++; 
			}
		}
	*target2 = '\0'; //��Խ������ĩβָ��ĵ�ַ�����и�ֵ '\0' ������ 
	printf("���ڴ�ӡSTR2���ַ���:%s, strlen���ȣ�%d, sizeof()���ȣ�%d",str2,strlen(str2),sizeof(str2));
	return 0; 
}
