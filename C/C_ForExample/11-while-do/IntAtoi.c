#include <stdio.h>
/*
#include <stdlib.h>
int main(){
	char str[100];
	while(1){
		printf("请输入一串字符：");
		scanf("%s",&str);
		printf("转换结果:%d\n",atoi(str));
	}
	
}*/
int main(){
        int ch;
        int num = 0;
        printf("请输入待转换的字符串：");
        do{
                ch = getchar();
                if (ch >= '0' && ch <= '9'){
                        num = 10 * num + (ch - '0'); //灵魂所在 ，10+ 1 -》110 + 1
                }
                else{
                        if (num){
                                break; // 如果已有数字，则退出循环
                        }
                }
        }
        while (ch != '\n');
        printf("结果是：%d\n", num);
        return 0;
}
