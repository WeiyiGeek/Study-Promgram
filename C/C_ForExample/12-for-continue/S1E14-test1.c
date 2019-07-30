#include <stdio.h>

int main(){
	int kilo,spend,cg=14;
	printf("公斤 -- 花费\n");
	for(kilo=1;kilo<=20;kilo++)
	{
		spend=23+(kilo-1)*cg;
		printf("%d  --  %d\n",kilo,spend);
	}
	return 0;
}
