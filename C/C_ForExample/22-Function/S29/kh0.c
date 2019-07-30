#include <stdio.h>

char *myitoa(int num, char *str);   //ע�������ָ�뺯��,�뷵�ص����� �����ǿ�

char *myitoa(int num, char *str)
{
        int dec = 1;
        int i = 0;
        int temp;

        if (num < 0)
        {
                str[i++] = '-';  //�����һ������,��str'�ַ�����һ��Ԫ��ȡ����"-"  (-9)
                num = -num; //�õ�һ������
        }
        temp = num;
        while (temp > 9)  //�ж�ֵ��λ�� �� dec ���� x 10 һֱ����(������������������ÿһλ��ֵ)
        {
                dec *= 10;
                temp /= 10;
        }

        while (dec != 0)
        {
                str[i++] = num / dec + '0'; // 9 + '0' = 57 ascii�� = 9
                num = num % dec;  //ȡ�������һ��ѭ��
                dec /= 10;
        }

        str[i] = '\0'; //�ַ���������
        return str;
}

int main(void)
{
        char str[10];

        printf("%s\n", myitoa(11, str));  // dec = 10 ,str[0] = 11/10 = (int)1, num = 1,dec = 1, str[1] = int(1)  ������ 11
        printf("%s\n", myitoa(-9, str));  // str[0] = - ,str[1] = 9 / 1 + '0' = 9, ������ -9
        return 0;
}
