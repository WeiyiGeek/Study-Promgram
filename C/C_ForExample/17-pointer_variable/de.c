#include <stdio.h>
#define MAX 1024

int main(){
    	char str[MAX];
        char *pstr = str;
        char ch;
        int len=0;
        printf("请输入一个字符串:");
        fgets(str,MAX,stdin);  //标准输入，1024字节/字符,放入str中
        while(1){
                ch = *pstr++;
                if (ch == '\0'){
                        break;
                }
                if((int)ch < 0){  //强制转换ch看取出的值是不是负数
                        pstr += 2; // 本来pstr都加+1，在到这里+1 == 跳过两个字节
                }
                len++;
        }
	printf("你输入的字符长度是:%d\n",len-1);
        return 0;
}
