#include <stdio.h>
#define NUM 10

int main(){
	int a[NUM];
	int i,sum=0;
	for(i=0;i<10;i++){
		printf("请输入第%d位同学的成绩:",i+1);
		scanf("%d",&a[i]);
		sum += a[i];
	}
	printf("这十位Students的成绩为%.2f\n",(float)sum / 10);
	return 0;
}
