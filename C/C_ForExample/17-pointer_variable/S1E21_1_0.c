#include <stdio.h>
#include <stdbool.h>  
//由于这里没有用C99的_Bool，所以需要引用stdbool头文件。

int main()
{
        int i, j, n, count, cubed, sum = 0;
        bool result = true; // 用于存放验证结果
        char answer;

        printf("请输入一个整数：");
        scanf("%d", &count);

        int array[count][4];  //4存当打印的四个值，cubed ， i，i+2，j；
        // 变长数组无法再定义是初始化，只能手动了...
        for (n = 3; n <= count; n++)
        {
               // 初始化第一列，因为后边用于验证 
               array[n][0] = 0;  
        }

        for (n = 3; n <= count; n++)  //循环多次
        {
                cubed = n * n * n;
                for (i = 1; i < cubed; i += 2)
                {
                        for (j = i; j < cubed; j += 2)
                        {
                                sum += j;
                                if (sum == cubed)
                                {
                                        array[n][0] = cubed;
                                        array[n][1] = i;
                                        array[n][2] = i + 2;
                                        array[n][3] = j;
                                        
                                        goto FINDIT;
                                }

                                if (sum > cubed)
                                {
                                        sum = 0;
                                        break;
                                }
                        }
                }

        FINDIT:
                ; // 空语句
        }

        // 检查
        for (n = 3; n <= count; n++)
        {
                if (array[n][0] == 0)  //cubed 是不是为 0，只要有一个cubed为0 则不存在连续的 尼科彻斯定理
                {
                        result = false;
                        break;
                }
        }
        
        if (result)
        {
                printf("经验证，3 ~ %d 之间所有的整数均符合尼科彻斯定理！\n\n", count);
                printf("是否打印所有式子(y/n)：");
                getchar(); //过滤掉换行符
                scanf("%c", &answer);  //进行选择 y /n
        }
        else
        {
                printf("验证失败：整数 %d 无法找到对应的连续奇数！\n");
        }

        if (answer == 'y')
        {
                // 打印
                for (n = 3; n <= count; n++)
                {
                        if (array[n][3] - array[n][1] > 4) //同样进行长度判断，判断输出的位数的格式
                        {
                                printf("%d^3 == %d == %d + %d +... + %d\n", n, array[n][0], array[n][1], array[n][2], array[n][3]);
                        }
                        else
                        {
                                printf("%d^3 == %d == %d + %d + %d\n", n, array[n][0], array[n][1], array[n][2], array[n][3]);
                        }
                }
        }

        return 0;
}
