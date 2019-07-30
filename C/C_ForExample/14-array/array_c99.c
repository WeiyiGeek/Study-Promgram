#include <stdio.h>

int main()
{
        int n, i;

        printf("请输入字符的个数：");
        scanf("%d", &n);

        char a[n+1];   //这里的关键

        printf("请开始输入字符：");
        getchar(); // 将标准输入流中剩下的 '\n' 扔掉
        for (i = 0; i < n; i++)//进行循环我们输入数字的次数
        {
                scanf("%c", &a[i]); //接收值,字符每次一个
        }
        a[n] = '\0'; //字符串结束符
        printf("你输入的字符串是：%s\n", a); // 输出字符串

        return 0;
}
