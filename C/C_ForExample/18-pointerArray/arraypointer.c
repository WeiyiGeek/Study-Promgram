#include <stdio.h>

int main(){
	int temp[5] = {1,2,3,4,5}; //��ʼ��һ���������� 
	int (*p1)[5] = &temp;    //��Ҫȡtemp����ĵ�ַ ,��ü���&ȡ��ַ����� 
	int i;
	for(i=0;i<5;i++){
		printf("(*p1)[%d]=%d\n",i,*(*p1+i));
	}
	return 0;
}

