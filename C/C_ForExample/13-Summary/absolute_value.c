#include <stdio.h>

int main(){
	int x,y;
	printf("������һ���������߸���:");
	scanf("%d",&x);
	y = x < 0 ? -x : x;
	printf("%d����ֵΪ%d\n",x,y);
}
