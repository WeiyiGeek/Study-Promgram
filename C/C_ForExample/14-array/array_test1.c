#include <stdio.h>

int main(){
	int a[6]={0};
	int b[6]={0,1,2,3};
	int c[6]={1,2,3,4,5,6};
	int d[]={1,3,5,7,9};
	int e[6]={[1]=1,[3]=3,[5]=5};
	int i;
	for(i=0;i<6;i++){
		printf("a[%d]=%d,",i,a[i]);
	}
	putchar('\n');
		for(i=0;i<6;i++){
                printf("b[%d]=%d,",i,b[i]);
        }
	putchar('\n');
	for(i=0;i<6;i++){
                printf("c[%d]=%d,",i,c[i]);
        }
	putchar('\n');
	for(i=0;i<6;i++){
                printf("d[%d]=%d,",i,d[i]);
        }
	putchar('\n');
		for(i=0;i<6;i++){
                printf("e[%d]=%d,",i,e[i]);
        }

	putchar('\n');
}
