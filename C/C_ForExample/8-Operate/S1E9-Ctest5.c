#include <stdio.h>
int main()
{
        float fah, cel;

        printf("请输入摄氏度：");
        scanf("%f", &cel);
       // fah = 9 / 5 * cel + 32; //(fah-32) * 5 /9 这是错误的 由于优先级不同
        fah = cel * 9 / 5 + 32;  //这是正确的摄氏温度计算华氏温度
        printf("转换为华摄度是：%.2f\n", fah);
        return 0;
}
