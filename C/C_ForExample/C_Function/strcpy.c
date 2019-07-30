#include <stdio.h>
#include <string.h>

int main(){
	char dest[] = "Original String1";
	char src[] = "Source String2";
	char str[100];

	strcpy(dest,src);
	strcpy(str,"Copy Successful");
	
	printf("dest:%s\n",dest);
	printf("src:%s\n",src);
	printf("str:%s\n",str);

	return 0;
}
