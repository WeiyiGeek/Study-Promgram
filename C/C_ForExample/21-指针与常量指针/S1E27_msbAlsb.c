#include <stdio.h>

int main(){
	int num = 0x12345678;
	unsigned char *p = (unsigned char *)&num;
	if(*p == 0x78){
		printf("当前运用的是\"小端\"的字节序!\n");
	}else{
		printf("当前运用的是\"大端\"的字节序!\n");
	}
	
	printf("0x%X 在内存中的存储顺序:\n",num);
	printf("Method1数组:0x%x 0x%x 0x%x 0x%x\nMethod2:指针",p[0],p[1],p[2],p[3]);
	
	for(int i=0;i<sizeof(p);i++){
		printf("0x%x ",*(p+i));   //char 8位bit 一个字节 
	}
}



