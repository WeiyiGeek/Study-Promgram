#include <stdio.h>

int main(){
	int a=4,b=2;
	printf("Please input seconde number\n");
	a -= 2;
	printf("a=%d\n",a);
	
	b +=3;
	printf("b=%d\n",b);

	a /= 2;
	printf("a=%d\n",a);

	b %= 4;  // ע����������� �������(%d) �� b��������Ҳ��Ϊint
	printf("b=%d\n",b);

	return 0;
}
