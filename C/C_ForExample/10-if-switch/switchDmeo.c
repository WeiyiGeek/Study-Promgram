#include <stdio.h>
int main(){
	int ch;
	printf("������ɼ�����(A-E):");
	scanf("%c",&ch);
	
	switch(ch){
		case 'A': printf("��ĳɼ���Χ��90�����ϣ�\n");break;
		case 'B': printf("��ĳɼ���Χ��80������,90������\n");break;
		case 'C': printf("��ĳɼ���Χ��70������,80������\n");break;
		case 'D': printf("��ĳɼ���Χ��60������,70������\n");break;
		case 'E': printf("��ĳɼ���Χ��60������\n");break;
		default : printf("��������ȷ�ĳɼ�����!!\n");
	}
	
	return 0;
}
