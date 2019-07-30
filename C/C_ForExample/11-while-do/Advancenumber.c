#include <stdio.h>
#include <math.h>

int main()
{
        int ch;
        long long num = 0;
        long long temp; // 临时变量，用于测试是否超出范围
        int is_overflow = 0;

        const int max_int = pow(2, sizeof(int) * 8) / 2 - 1;
        const int min_int = pow(2, sizeof(int) * 8) / 2 * (-1);
    
        printf("请输入待转换的字符串：");
        do {
                ch = getchar();

                if (ch >= '0' && ch <= '9'){
                        temp = 10 * num + (ch - '0');
                        if (temp > max_int || temp < min_int){
                                is_overflow = 1;
                                break;
                        }
                        else{
                                num = temp;  //将值赋给变量num
                        }
                }
                else{
                        if (num) {
                                break; // 如果已有数字，则退出循环
                        }
                }
        }
        while (ch != '\n');

        if (is_overflow){
                printf("数值超出范围，结果未定义！\n");
        }
        else
        {
                if (!num){
                        printf("并未找到任何数值！\n");
                }
                else{
                        printf("结果是：%d\n", num);
                }
        }

        return 0;
}
