#include <stdio.h>

int main(){
	int num = 1024;
	int *pi = &num;
	char *ps = "FishC";
	void *pv;
	
	pv = pi;
	printf("pi-address: %p, pv-address: %p\n", pi, pv);
	printf("pi-value: %d, pv-value: %d\n", *pi,*(int *)pv);
	putchar('\n');
	pv = ps;
	printf("ps-address: %p, pv-address: %p\n", ps, pv);
	printf("ps-value: %s, pv-value: %s\n ", ps, (char *)pv);

	return 0;
}

