#include <stdio.h>

int main(){
	int num = 0x12345678;
	unsigned char *p = (unsigned char *)&num;
	if(*p == 0x78){
		printf("��ǰ���õ���\"С��\"���ֽ���!\n");
	}else{
		printf("��ǰ���õ���\"���\"���ֽ���!\n");
	}
	
	printf("0x%X ���ڴ��еĴ洢˳��:\n",num);
	printf("Method1����:0x%x 0x%x 0x%x 0x%x\nMethod2:ָ��",p[0],p[1],p[2],p[3]);
	
	for(int i=0;i<sizeof(p);i++){
		printf("0x%x ",*(p+i));   //char 8λbit һ���ֽ� 
	}
}



