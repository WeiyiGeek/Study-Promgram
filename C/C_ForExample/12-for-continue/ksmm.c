#include <stdio.h>

int main()
{
        int ch;

        printf("请输入明文：");

        while ((ch = getchar()) != '\n')
        {
                if (ch >= 'a' && ch <= 'z')
                {
                        putchar('a' + (ch - 'a' + 3) % 26);
                        continue;
                }

                if (ch >= 'A' && ch <= 'Z')
                {
                        putchar('A' + (ch - 'A' + 3) % 26);
                        continue;
                }

                putchar(ch);
        }

        putchar('\n');

        return 0;
}
