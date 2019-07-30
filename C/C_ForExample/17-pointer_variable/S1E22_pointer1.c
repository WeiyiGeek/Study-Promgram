#include <stdio.h>

int main(){
    char a[] = {"tecent"};
    int b[5] = {1,2,3,4,5};
    float c[5] = {1.1,2.2,3.3,4.4,5.5};
    double d[5] = {1.1,2.2,3.3,4.4,5.5};
	
	char *p = a;
	int *pb = b;
	printf("*p = %c,*(p+1) = %c,*(p+2) = %c\n",*p,*(p+1),*(p+2));
	printf("*pb = %d,*(pb+1) = %d,*(pb+2) = %d\n",*pb,*(pb+1),*(pb+2));
	printf("*c = %.1f,*(c+1) = %.1f,*(c+2) = %.1f\n",*c,*(c+1),*(c+2));

	return 0;
}
