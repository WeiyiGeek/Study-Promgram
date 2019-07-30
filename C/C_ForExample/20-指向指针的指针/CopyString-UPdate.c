#include <stdio.h>
#include <string.h>
#define MAX 1024

int main(){
	char str1[MAX];
	char str2[MAX];
	
	char *target1 = str1;
	char *target2 = str2;
	
	int ch;
	int n;  //输入截取的字符个数
	
	printf("请输入str1的字符串：");
		fgets(str1,MAX,stdin);
	printf("请输入要截取字符的个数：");
		scanf("%d",&n);
	printf("\n------正在Copy字符串------\n");
	 	while(n--){
	 		ch = *target2++ = *target1++;
	 		if(ch == '\0'){
	 			break;
			 } 
			if((int)ch < 0){  //由于汉字在linux占3字节，进行地址+2  
				*target2++ = *target1++;  //从右到左  但由于这里是Windows汉字占用两个字节，所以注释下一行表达式 
			//	*target2++ = *target1++; 
			}
		}
	*target2 = '\0'; //跨越到数组末尾指向的地址并进行赋值 '\0' 结束符 
	printf("正在打印STR2的字符串:%s, strlen长度：%d, sizeof()长度：%d",str2,strlen(str2),sizeof(str2));
	return 0; 
}
