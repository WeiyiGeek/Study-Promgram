#include <stdio.h>

int main()
{
        int m, p, n;
        int i, j, k, row;

        // 定义第一个矩阵
        printf("请输入第一个矩阵的尺寸(M * P)：");
        scanf("%d * %d", &m, &p);
        int matrix_in_1[m][p];

        // 定义第二个矩阵
        printf("请输入第一个矩阵的尺寸(P * N)：");
        scanf("%d * %d", &p, &n);
        int matrix_in_2[p][n];

        // 初始化存放乘积的二维数组
        // VAL数组不支持直接初始化操作
        int matrix_out[m][n];
        for (i = 0; i < m; i++)
        {
                for (j = 0; j < n; j++)
                {
                        matrix_out[i][j] = 0;
                }
        }

        // 让用户输入第一个矩阵
        printf("请输入第一个矩阵的值：\n");
        for (i = 0; i < m; i++)
        {
                for (j = 0; j < p; j++)
                {
                        scanf("%d", &matrix_in_1[i][j]);
                }
        }

        // 让用户输入第二个矩阵
        printf("请输入第二个矩阵的值：\n");
        for (i = 0; i < p; i++)
        {
                for (j = 0; j < n; j++)
                {
                        scanf("%d", &matrix_in_2[i][j]);
                }
        }

        // 计算乘积并保存
        for (i = 0; i < m; i++)
        {
                for (j = 0; j < n; j++)
                {
                        for (k = 0; k < p; k++)
                        {
                                matrix_out[i][j] += matrix_in_1[i][k] * matrix_in_2[k][j];
                        }
                }
        }

        printf("计算结果如下：\n");

        // row 取行数最大值
        row = m > p ? m : p;

        for (i = 0; i < row; i++)  // 5
        {
                printf("|  ");
                // 打印 matrix_in_1
                for (j = 0; j < p; j++) //5
                {
                        if (i < m)  //4
                        {
                                printf("\b%d ", matrix_in_1[i][j]);  //\b这里表示退格键会覆盖前一个字符 "|"
                                printf("|");
                        }
                        else
                        {
                                printf("\b\b\b     ");
                        }
                }
                // 打印 * 号
                if (i == row / 2)
                {
                        printf(" * ");
                }
                else
                {
                        printf("   ");
                }
                printf("|  ");

                // 打印 matrix_in_2
                for (j = 0; j < n; j++) //8
                {
                        if (i < p)
                        {
                                printf("\b%d ", matrix_in_2[i][j]);
                                printf("|");
                        }
                        else
                        {
                                printf("\b\b\b     ");
                        }
                }
                // 打印 = 号
                if (i == row / 2)
                {
                        printf(" = ");
                }
                else
                {
                        printf("   ");
                }
                // 打印 matrix_out
                printf("|  ");
                for (j = 0; j < n; j++) // 8
                {
                        if (i < m)
                        {
                                printf("\b%d ", matrix_out[i][j]);
                                printf("|");
                        }
                        else
                        {
                                printf("\b\b\b      ");
                        }
                }
                printf("\n");
        }

        return 0;
}
