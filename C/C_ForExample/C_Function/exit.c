#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int a, b,result;
	printf("��������ֵ��");
	scanf("%d %d",&a,&b);
	result = a + b;
	printf("������\n");
	printf("a+b=%d\n",result);
	if(result > 0){
		exit(EXIT_SUCCESS);	
	}else{
		exit(EXIT_FAILURE); 
	}
	 
	printf("�������\n -- ��Զ����ʾ");
	return 0;	
}



