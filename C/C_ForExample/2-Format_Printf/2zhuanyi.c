#include <stdio.h>
/**转义字符的Demo**/ 
int main(){
	
	printf("\a");  //响铃声
	printf("Test \bBackspsche\n");   //删除前一个退格BS，换行 FF
	printf("Test \fchange Line\n");  //换页符号FF-LF
	printf("Test\renter\n");    //回车CR 
	printf("水平制表符：\tshuiping\n");  //HT
	printf("垂直制表符号：\vCHUIZHI\n");  //VT
	printf("输出转义的反斜杠\\\n"); 
	printf("表示输出单引号\'与双\"与\?\n");
	printf("输出空字符\0\n");
	printf("输出八进制的字符:\060\n");  //ASCII之间的转换 
	printf("输出十六进制的字符:\x61\n"); 
	return 0;
}
