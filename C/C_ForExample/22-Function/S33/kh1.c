#include <stdio.h>
#include <string.h>

void createMatrix(int n);

void createMatrix(int n)
{
        int i, j, oi, oj, num, max;

        // 创建一个存放矩阵的二维数组
        int matrix[n][n];

        // 填充为内存为0
        max = n * n;
        memset(matrix, 0, max * sizeof(int));

        // 将1存放到第0行的中间位置
        matrix[0][n/2] = 1;

        // 记录当前的行号和列号
        i = 0;
        j = n / 2;

        for (num = 2; num <= max; num++)
        {
                // 记住当前位置
                oi = i;
                oj = j;

                // 向右上角走一步
                i = i - 1;  //line - 1
                j = j + 1;  //row  + 1

                if (i < 0) //当i = 0 时候 减去 -1 = -1  （从下到上）
                {
                        i = n - 1; // i = 4
                }

                if (j > n - 1) // j > 4 时候 到第一列 （从左到右）
                {
                        j = 0;
                }

                if (matrix[i][j] != 0)
                {
                        i = oi + 1; //行数+1,可以即是存在数的前一个数字的位置的正下方
                        j = oj;   //列数不变
                }

                matrix[i][j] = num;
        }

        // 打印结果
        for (i = 0; i < n; i++)
        {
                for (j = 0; j < n; j++)
                {
                        printf("%2d   ", matrix[i][j]);
                }
                putchar('\n');
        }
}

int main(void)
{
        int n;

        printf("请输入一个奇数：");
        scanf("%d", &n);
        while (!(n % 2) || n < 3)
        {
                printf("输入错误，必须是一个大于2的奇数！\n");
                printf("请重新输入：");
                scanf("%d", &n);
        }

        createMatrix(n);

        return 0;
}
