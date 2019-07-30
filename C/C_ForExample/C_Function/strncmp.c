#include <stdio.h>
#include <string.h>

int main()
{
        char str1[40] = "FishCA";
        char str2[40] = "FishC.com";

        if (!strncmp(str1, str2, 6)){
                printf("str1和str2前5个字符相同！\n");
        }
        else if(strncmp(str1, str2,6) > 0){
                printf("str1 > str2 \n");
        }else{
                printf("str1 < str2 \n");
        }
        return 0;
}
