#include <stdio.h>
#include <string.h>
int main(){
        char str1[20] = "I ";
        char str2[20] = "love ";
        char str3[20] = "FishC.com!";

        strncat(str1, str2, 5); //截取str2中前5个字符进行加入到str1末尾.
            printf("First--str1: %s\n", str1);

        strncat(str1, str3, 10);	//同上
            printf("Second--str1: %s\n", str1);

        return 0;
}
