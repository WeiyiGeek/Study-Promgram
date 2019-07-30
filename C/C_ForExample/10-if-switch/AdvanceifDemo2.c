#include <stdio.h>
/**悬挂else需要注意它总是与最近if匹配,在没有if{"中括号"}**/
int main(){
	char isRain,isFree;
	printf("是否有空？（Y/N）");   //由于回车也是以个字符 
	scanf("%c",&isFree);

	getchar();  //"过滤"掉回车以及Ascii前32个不可见字符 
	 
	printf("是否下雨？（Y/N）");
	scanf("%c",&isRain);
	
	if(isFree == 'Y'){
		if(isRain == 'Y')
			printf("记得带上伞哟！！"); 
	}else{  /**悬挂else需要注意它总是与最近if匹配,在没有if{"中括号"}**/
		printf("女神没空,T_T!!!");
	}
} 
