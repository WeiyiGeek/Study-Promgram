#include <stdio.h>

char *myitoa(int num, char *str);   //注意这里的指针函数,与返回的类型 这里是坑

char *myitoa(int num, char *str)
{
        int dec = 1;
        int i = 0;
        int temp;

        if (num < 0)
        {
                str[i++] = '-';  //如果是一个负数,则str'字符串第一个元素取负号"-"  (-9)
                num = -num; //得到一个正数
        }
        temp = num;
        while (temp > 9)  //判断值的位数 将 dec 进行 x 10 一直迭代(方便后面利用求余求出每一位的值)
        {
                dec *= 10;
                temp /= 10;
        }

        while (dec != 0)
        {
                str[i++] = num / dec + '0'; // 9 + '0' = 57 ascii码 = 9
                num = num % dec;  //取余进行下一次循环
                dec /= 10;
        }

        str[i] = '\0'; //字符结束符号
        return str;
}

int main(void)
{
        char str[10];

        printf("%s\n", myitoa(11, str));  // dec = 10 ,str[0] = 11/10 = (int)1, num = 1,dec = 1, str[1] = int(1)  最后输出 11
        printf("%s\n", myitoa(-9, str));  // str[0] = - ,str[1] = 9 / 1 + '0' = 9, 最后输出 -9
        return 0;
}
