#include <stdio.h>
/**����else��Ҫע�������������ifƥ��,��û��if{"������"}**/
int main(){
	char isRain,isFree;
	printf("�Ƿ��пգ���Y/N��");   //���ڻس�Ҳ���Ը��ַ� 
	scanf("%c",&isFree);

	getchar();  //"����"���س��Լ�Asciiǰ32�����ɼ��ַ� 
	 
	printf("�Ƿ����ꣿ��Y/N��");
	scanf("%c",&isRain);
	
	if(isFree == 'Y'){
		if(isRain == 'Y')
			printf("�ǵô���ɡӴ����"); 
	}else{  /**����else��Ҫע�������������ifƥ��,��û��if{"������"}**/
		printf("Ů��û��,T_T!!!");
	}
} 
