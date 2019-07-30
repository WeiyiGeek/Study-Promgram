#include <stdio.h>
#include <string.h>
#include <stdarg.h>

int myprintf(char *format, ...); //�ɱ����

int countInt(int num);
void printInt(int num);
void printStr(char *str);

// ��������ʹ�õ����ķ�ʽ��ӡ����
// �Ⱥ���ѧ�˵ݹ飬�õݹ���������
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
                putchar(num / dec + '0'); //�����ֵ
                num = num % dec;
                dec /= 10;
        }
}

// ��������ռ���ٸ��ַ�
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
                count++;  //��Ҫ�ǵ����� 0 ~ 9
        } while (num /= 10);

        return count;
}

// ��ӡ�ַ���
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

        va_list vap;  //�����б�
        va_start(vap, format);

        while (format[i] != '\0')
        {
                // ������Ǹ�ʽ��ռλ����ֱ�Ӵ�ӡ�ַ���
                if (format[i] != '%')
                {
                        putchar(format[i]);//ռλ��֮ǰ֮��
                        i++;
                        count++; //�����ַ�
                }
                // ����Ǹ�ʽ��ռλ��...
                else
                {
                        switch (format[i+1])  //%������ַ�����ʾ��ͬ������
                        {
                                case 'c':
                                        {
                                                carg = va_arg(vap, int);  //����
                                                putchar(carg);
                                                count++;
                                                break;
                                        }
                                case 'd':
                                        {
                                                darg = va_arg(vap, int);
                                                printInt(darg);
                                                count += countInt(darg);  //ֱ�Ӽ�����������
                                                break;
                                        }
                                case 's':
                                        {
                                                sarg = va_arg(vap, char *);
                                                printStr(sarg);
                                                count += strlen(sarg);  //ǰ����ַ��� + ռλ����ʾ�ַ����ĳ���
                                                break;
                                        }
                        }
                        i += 2; //ռλ����ĸ + \n
                }
        }
        va_end(vap);  //�ɱ����������

        return count;//���س���ֵ
}

int main(void)
{
        int i;

        i = myprintf("Hello %s\n", "FishC");
        myprintf("����ӡ��%d���ַ�(����\\n)\n", i);

        i = myprintf("int: %d, char: %c\n", -520, 'H');
        myprintf("����ӡ��%d���ַ�(����\\n)\n", i);

        return 0;
}
