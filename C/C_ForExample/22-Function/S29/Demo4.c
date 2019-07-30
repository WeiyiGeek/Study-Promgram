#include <stdio.h>
#include <stdarg.h>

int sum(int n, ...);

int sum(int n, ...) // ����С����ռλ������ʾ����������ȷ��
{
        int i, sum = 0;
        va_list vap; // ��������б�

        va_start(vap, n); // ��ʼ�������б������ int sum(int gg, ...); ������Ӧ���� va_start(vap, gg);
        for (i = 0; i < n; i++)
        {
                sum += va_arg(vap, int); // ��ȡ����ֵ
        }
        va_end(vap); // ��β�������رղ����б�

        return sum;
}

int main()
{
        int result;

        result = sum(3, 1, 2, 3);

        printf("result = %d\n", result);

        return 0;
}
