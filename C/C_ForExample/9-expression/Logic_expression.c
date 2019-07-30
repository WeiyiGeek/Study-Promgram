#include <stdio.h>

int main(){
	int a = 5, b = 3;
	printf("%d\n", 3 > 1 && 1 < 2);
	printf("%d\n", 3 + 1 || 2 == 0); //任何非0的数都是为真的
	printf("%d\n", !(a + b));
	printf("%d\n", !0 + 1 < 1 || !(3 + 4));
	printf("%d\n", 'a' - 'b' && 'c');

	return 0;
}
