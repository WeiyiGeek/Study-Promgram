#include <stdio.h>

int main()
{
        char ch[6] = "FishC";
        int i;

        printf("请输入你想访问的字符序号(0~5)：");
        scanf("%d", &i);
        if(i >=0 && i<=5){  //防止数据溢出 
       	 printf("%c\n", ch[i]);
		}else{
			printf("输入错误,请重新输入"); 
		}
        return 0;
}
