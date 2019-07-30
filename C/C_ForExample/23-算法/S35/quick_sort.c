#include <stdio.h>
void quick_sort(int array[], int left, int right);  //ע����յ��������
void quick_sort(int array[], int left, int right){
    int i = left, j = right;  // 7 8 9
    int temp;
    int pivot;

    pivot = array[(left + right)/2];
    while(i <= j){
        //�������ҵ� ���ڵ��� ��׼���Ԫ��
        while(array[i] < pivot){
            i++;  //��߽����±�ĵ���;
        }
        //���ҵ����ҵ� С�ڵ��� ��׼���Ԫ��
        while(array[j] > pivot){
            j--; //�ұ߽����±�ĵݼ�
        }
        //���������±� i <= j,�򻥻�Ԫ��
        if(i<=j){
            temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
    }
   if(left < j){
       quick_sort(array,left,j);  //leftΪ0,jΪ7; (5,2,1,"4",0,3,6)  == > i=4 // j=3 (3,2,1,0, (4,5,6)���� ) 
   } 
   if(right > i){
       quick_sort(array,i,right); //iΪ7,rightΪ9; (8,"7",9)  ==> j = 7 // i = 8  ( ֱ������ )
   }
}

int main(void){
    int array[]={5,2,9,4,7,8,6,3,0,1};
    int i, length;

    length=sizeof(array) / sizeof(array[0]);
    
    quick_sort(array,0,length-1);  //ע�⴫��������
    printf("���������Ľ���ǣ�");
    for(i = 0; i < 10; i++){
        printf("%d ",array[i]);
    }
    putchar('\n');
    return 0;
}