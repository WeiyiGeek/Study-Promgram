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
                mid = (low + high) / 2; //�����м�С�������ֵ

                if (array[mid] == target)
                {
                        return mid;
                }
                if (target > array[mid]) //ֵ��ѧϰ֮��,���������ұ���Ѱ,�������
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
        printf("����������ҵ�������");
        scanf("%d", &target);
        index = bin_search(array, 0, 9, target); //�ж������ֵ���м�ֵ������,������ұ�������в���,������������ݽ��м������ҡ�
        if (index != -1)
        {
                printf("%d�������е��±��ǣ�%d\n", target, index);
        }
        else
        {
                printf("�Ҳ�����\n");
        }
		printf("ִ����%d��bin_search����",count);
        return 0;
}