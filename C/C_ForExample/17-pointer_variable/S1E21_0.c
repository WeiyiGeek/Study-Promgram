#include <stdio.h>

int main(){
	int a,b,c;
	int *d, *e, *f, *g;

	printf("请输入三个数:");
	scanf("%d %d %d",&a,&b,&c);
	
	d = &a;
	e = &b;
	f = &c;
	
	if(a > b){
	
		g = d;
		d = e;
		e = g;
	
	}
	if(a > c){
		g = d;
		d = f;
		f = g;
	}
	if(b > c){
		g = e;
		e = f;
		f = g;
	}
	printf("%d <= %d <= %d \n",*d,*e,*f);
	
	return 0;
}
