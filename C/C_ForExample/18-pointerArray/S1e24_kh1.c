#include <stdio.h>
#include <string.h>
#define MAX 1024
int main(){
	char test[MAX];
	char *pt = test;
	int len,half_len,cunt = 0;;
	char ch;
	
	printf("�������ַ�����");	
	fgets(test,MAX,stdin);

	len = strlen(test) - 1;  //��ȥ���з� 
	half_len = (int)(len / 2);
	
	while(half_len > 0){
		if( half_len * half_len <= len){
			break;
		}
		half_len--;
	}
//method 1��	
	char (*p1)[half_len] = (char (*)[half_len])&test;
	for(int i = 0; i < half_len; i++){
		for(int j = 0; j < half_len; j++){
			printf("%c",p1[i][j]);
		}
		putchar('\n');
	}		

//method 2��	
#if 1
	while(cunt < half_len * half_len){
		if((ch = *pt++) != '\0'){
			cunt += 1;
			printf("%c ",ch);
			if(cunt % half_len == 0){
				putchar('\n'); 
			}
		}else{
			break;
		} 
	}
#endif	
}


