#include <stdio.h>
int main(){
	char hasBF;
	
	printf("小花你有男朋友吗？(y/n)\n");
	scanf("%c",&hasBF);
	
//	if(hasBF = 'Y')  注意这里,是将一个常量Y赋值给一个 hasBF变量,if经过关系表达式来判断只要非0就为真 
	if('y' == hasBF)   //对于 判断是否 值相等“建议把常量写在前面 ，变量写在后面,减少由于 = 出现的BUG” 
	{ 
		printf ("祝福你们！，T_T!!"); 
	} else{
		printf("我们在一起把！！"); 
	}
	
	return 0; 
}
