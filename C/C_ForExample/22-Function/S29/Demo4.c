#include <stdio.h>
#include <stdarg.h>

int sum(int n, ...);

int sum(int n, ...) // 三个小点是占位符，表示参数个数不确定
{
        int i, sum = 0;
        va_list vap; // 定义参数列表

        va_start(vap, n); // 初始化参数列表，如果是 int sum(int gg, ...); 则这里应该是 va_start(vap, gg);
        for (i = 0; i < n; i++)
        {
                sum += va_arg(vap, int); // 获取参数值
        }
        va_end(vap); // 首尾工作，关闭参数列表

        return sum;
}

int main()
{
        int result;

        result = sum(3, 1, 2, 3);

        printf("result = %d\n", result);

        return 0;
}
