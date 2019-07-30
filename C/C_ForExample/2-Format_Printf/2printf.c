#include <stdio.h>
/**Printf函数的Demo**/ 
int main(){
	int a = 520;
	char b = 'F';
	float c = 3.14;
	double d = 3.141592653;
	
	printf("我非常的喜欢C语言，再%d年的时候\n",a);
	printf("我要输出一个字母，%c\n",b);
	printf("圆周率数值是:%.2f\n",c);
	printf("精确到小数点后9位的圆周率是:%10.9f\n",d);
    printf("***************************************************************************\n");
    
    printf("测试符号:% f\n",d); 
    printf("测试符号:%+f\n",d);   // 可以添加正负数 

    printf("***************************************************************************\n");
	printf("%s\n","Hello World");   //"hello",一个字符串存储在内存中
	printf("8的八进制是:%o\n",8);
	printf("10的十进制是:%u\n",10);
	printf("15的十六进制是:%x\n",15);	
	return 0;	
	
} 
