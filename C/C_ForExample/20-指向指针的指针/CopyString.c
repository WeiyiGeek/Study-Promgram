#include <stdio.h>

#define MAX 1024

int main(){
	
	char str1[MAX];
	char str2[MAX];
	
	char *target1 = str1;
	char *target2 = str2;

	printf("Please input String:");
	fgets(str1,MAX,stdin);
	
	printf("--------ÕıÔÚ¿½±´×Ö·û´®---------\n");
	while((*target2++ = *target1++) != '\0'){
		;
	}	
	
	printf("´òÓ¡³ö¿½±´µÄ×Ö·û´®£º%s\n",str2);
}

