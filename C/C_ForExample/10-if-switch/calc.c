#include <stdio.h>
#include <math.h>
int main(){
	float a,b;
	char str;
	printf("请输入式子:");
	scanf("%f%c%f",&a,&str,&b);
	switch(str){
		case '+': printf("结果是:%.2f\n",a+b);break;   //也可以将值付给一个float类型的变量，在后面就行switch语句后进行printf就行
		case '-': printf("结果是:%.2f\n",a-b);break;
		case '*': printf("结果是:%.2f\n",a*b);break;
		case '/': if( 0 == b ){
				printf("很遗憾,除数不能为零!\n");
								break;
			   }else{
				printf("结果是:%.2f\n",a/b);
							break;
				 }
		default: printf("输入错误请重新输入:\n");
	}

	return 0;
}
