#include <stdio.h>
#include <string.h>
#include <stdarg.h>

int myprintf(char *format, ...); //可变参数

int countInt(int num);
void printInt(int num);
void printStr(char *str);

// 这里我们使用迭代的方式打印整数
// 等后面学了递归，用递归会更方便呢
void printInt(int num)
{
        int dec = 1;
        int temp;

        if (num < 0)
        {
                putchar('-');
                num = -num;
        }
        temp = num;
        while (temp > 9)
        {
                dec *= 10;
                temp /= 10;
        }
        while (dec != 0)
        {
                putchar(num / dec + '0'); //输出其值
                num = num % dec;
                dec /= 10;
        }
}

// 计算整数占多少个字符
int countInt(int num)
{
        int count = 0;

        if (num < 0)
        {
                count++;
                num = -num;
        }

        do
        {
                count++;  //主要是单个数 0 ~ 9
        } while (num /= 10);

        return count;
}

// 打印字符串
void printStr(char *str)
{
        int i = 0;

        while (str[i] != '\0')
        {
                putchar(str[i]);
                i++;
        }
}

int myprintf(char *format, ...)
{
        int i = 0;
        int count = 0;

        int darg;
        char carg;
        char *sarg;

        va_list vap;  //参数列表
        va_start(vap, format);

        while (format[i] != '\0')
        {
                // 如果不是格式化占位符，直接打印字符串
                if (format[i] != '%')
                {
                        putchar(format[i]);//占位符之前之后
                        i++;
                        count++; //个数字符
                }
                // 如果是格式化占位符...
                else
                {
                        switch (format[i+1])  //%后面的字符来表示不同的类型
                        {
                                case 'c':
                                        {
                                                carg = va_arg(vap, int);  //接收
                                                putchar(carg);
                                                count++;
                                                break;
                                        }
                                case 'd':
                                        {
                                                darg = va_arg(vap, int);
                                                printInt(darg);
                                                count += countInt(darg);  //直接加入整数长度
                                                break;
                                        }
                                case 's':
                                        {
                                                sarg = va_arg(vap, char *);
                                                printStr(sarg);
                                                count += strlen(sarg);  //前面的字符串 + 占位符表示字符串的长度
                                                break;
                                        }
                        }
                        i += 2; //占位符字母 + \n
                }
        }
        va_end(vap);  //可变参数结束宏

        return count;//返回长度值
}

int main(void)
{
        int i;

        i = myprintf("Hello %s\n", "FishC");
        myprintf("共打印了%d个字符(包含\\n)\n", i);

        i = myprintf("int: %d, char: %c\n", -520, 'H');
        myprintf("共打印了%d个字符(包含\\n)\n", i);

        return 0;
}
