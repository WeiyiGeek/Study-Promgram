#include <stdio.h>
void quick_sort(int array[], int left, int right);  //注意接收的数组参数
void quick_sort(int array[], int left, int right){
    int i = left, j = right;  // 7 8 9
    int temp;
    int pivot;

    pivot = array[(left + right)/2];
    while(i <= j){
        //从左到右找到 大于等于 基准点的元素
        while(array[i] < pivot){
            i++;  //左边进行下标的递增;
        }
        //从右到左找到 小于等于 基准点的元素
        while(array[j] > pivot){
            j--; //右边进行下标的递减
        }
        //如果坐标的下标 i <= j,则互换元素
        if(i<=j){
            temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
    }
   if(left < j){
       quick_sort(array,left,j);  //left为0,j为7; (5,2,1,"4",0,3,6)  == > i=4 // j=3 (3,2,1,0, (4,5,6)舍弃 ) 
   } 
   if(right > i){
       quick_sort(array,i,right); //i为7,right为9; (8,"7",9)  ==> j = 7 // i = 8  ( 直接舍弃 )
   }
}

int main(void){
    int array[]={5,2,9,4,7,8,6,3,0,1};
    int i, length;

    length=sizeof(array) / sizeof(array[0]);
    
    quick_sort(array,0,length-1);  //注意传递数组名
    printf("快速排序后的结果是：");
    for(i = 0; i < 10; i++){
        printf("%d ",array[i]);
    }
    putchar('\n');
    return 0;
}