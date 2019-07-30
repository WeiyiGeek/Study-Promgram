#include <stdio.h>

void getInput();
void getInput(){
    int ch;
    if ((ch = getchar()) != '!'){  //精妙之处,递归
        getInput();
    }
    else{
        printf("反向输出：");
    }
    putchar(ch);
}

int main(void)
{
    printf("请输入一句以感叹号结尾的英文句子：");
    getInput();
    putchar('\n');
    return 0;
}