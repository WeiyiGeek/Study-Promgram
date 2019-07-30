#include <stdio.h>
int bin_search(int array[], int n, int target);
int bin_search(int array[], int n, int target)
{
        int low, high, mid;  //设置最小数组下标,和最大数组下标

        low = 0;
        high = n - 1;

        while (low <= high)
        {
                mid = (low + high) / 2;
                if (array[mid] == target)
                {
                        return mid;
                }

                if (array[mid] < target)
                {
                        low = mid + 1;  //进行中值的判断是否小于目标值,如果是则在右方数据进行查找,并进行下一次循环。
                }

                if (array[mid] > target)
                {
                        high = mid - 1;
                }
        }

        return -1;
}

int main(void)
{
        int target, index;
        int array[10] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        printf("请输入待查找的整数：");
        scanf("%d", &target);
        index = bin_search(array, 10, target);
        if (index != -1)
        {
                printf("%d在数组中的下标是：%d\n", target, index);
        }
        else
        {
                printf("找不到！\n");
        }

        return 0;
}