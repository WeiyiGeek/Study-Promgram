#include <stdio.h>
#include <string.h>

int main()
{
        char str1[20] = "ZFishC.com";
        char str2[20] = "ZFishC.com";

        if (!strcmp(str1, str2)) //返回值为 0 
        {
                printf("两个字符串完全一致！\n");
        }
        else if( strcmp(str1, str2) > 0) // < 0(String-A < String-B) ，> 0 (A>B)
        {
                printf("Str1字符串 > Str2字符串！\n");
        }else{
		printf("Str1字符串 < Str2字符串！\n");
	}

        return 0;
}
