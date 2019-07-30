#include <stdio.h>
#define MAX 1024

int main(){
        char str1[MAX];
        char str2[MAX];

        char *target1 = str1;
        char *target2 = str2;

        int index = 1;

        printf("请输入第一个字符串：");
        fgets(str1, MAX, stdin);

        printf("请输入第二个字符串：");
        fgets(str2, MAX, stdin);

        while (*target1 != '\0' && *target2 != '\0'){  //短路求值 对比在两个字符串非 '\0',在进行比较
                if (*target1++ != *target2++){  //同时看同一索引的地址里面的值是不是相同
                       break;
                }
                index++; //字符位置递增
        }

        if (*target1 == '\0' && *target2 == '\0'){  //匹配数组末尾是否相同
                printf("两个字符串完全一致！\n");
        }
        else{
                printf("两个字符串不完全相同，第 %d 个字符出现不同！\n", index);
        }
        return 0;
}
