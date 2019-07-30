#include <stdio.h>

int main()
{
        int num = 0;
        long sum = 0L; // 0L表示类型为long的0
        int status;

        do
        {
                printf("请输入合法的数字：");
                sum = sum + num;
                status = scanf("%d", &num); //用status来判断scanf是不正确输入占位符代表的值，是则返回为1，不是则返回0; 
		printf("%d\n",status);
        } while(status == 1);

        printf("结果是：%ld\n", sum);

        return 0;
}
