#include <stdio.h>
#define MAX 1024

int main(){
	char str1[2 * MAX];
	char str2[MAX];

	char *tastr1 = str1;
	char *tastr2 = str2;

	int ch,n;
	int index = 1;

	printf("Please input String First:");
	fgets(str1,MAX,stdin);

	printf("Please input String Seconde:");
	fgets(str2,MAX,stdin);

	printf("对比字符的个数:");
	scanf("%d",&n);

	while (n && *tastr1 != '\0' && *tastr2 != '\0'){  //重点短路求助
                ch = *tastr1;
                if (ch < 0) {
                        if (*tastr1++ != *tastr2++ || *tastr1++ != *tastr2++){ //判断中文字符 注意中文状态下是执行一次
                                break;
                        }
                }
                if (*tastr1++ != *tastr2++){ //判断两个指向一样的下标的地址 里面数据是否相同
                       break;
                }
                index++;
                n--;
        }

	if ((n == 0) || (*tastr1 == '\0' && *tastr2 == '\0')){  //判断 n 是不是等于0 可以判断是不是在n对比完了
                printf("两个字符串的前 %d 个字符完全相同！\n", index-1); //消除回车的影响
        }
        else{
                printf("两个字符串不完全相同，第 %d 个字符出现不同！\n", index);
        }
}
