#include <stdio.h>

int main(){
	int n,i,j;
	printf("Array number:");
	scanf("%d",&n);
	int a[n+1];
	for(i=0;i<n;i++){
		a[i]=i;
	}
	a[n]=10;
	for(j=0;j<=n;j++){
		printf("a[j]=%d\n",a[j]);
	}
	
	
}
