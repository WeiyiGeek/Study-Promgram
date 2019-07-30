#include <stdio.h>
int count;
int bin_search(int array[], int low, int high, int target);
int bin_search(int array[], int low, int high, int target)
{
        int mid;
		count++;
        if (low > high)
        {
                return -1;
        }
        else
        {
                mid = (low + high) / 2; //设置中间小标的数组值

                if (array[mid] == target)
                {
                        return mid;
                }
                if (target > array[mid]) //值得学习之处,大于则在右边搜寻,否则左边
                {
                        return bin_search(array, mid + 1, high, target);
                }
                else
                {
                        return bin_search(array, low, mid - 1, target);
                }
        }
}

int main(void)
{
        int target, index;
        int array[10] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        printf("请输入待查找的整数：");
        scanf("%d", &target);
        index = bin_search(array, 0, 9, target); //判断输入的值比中间值大还是下,大就在右边数组进行查找,否则在左边数据进行继续查找。
        if (index != -1)
        {
                printf("%d在数组中的下标是：%d\n", target, index);
        }
        else
        {
                printf("找不到！\n");
        }
		printf("执行了%d次bin_search函数",count);
        return 0;
}