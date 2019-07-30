#include <stdio.h>

int main(){
	int x,y;
	printf("请输入一个正数或者负数:");
	scanf("%d",&x);
	y = x < 0 ? -x : x;
	printf("%d绝对值为%d\n",x,y);
}
