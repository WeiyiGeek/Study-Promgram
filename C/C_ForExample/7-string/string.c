#include <stdio.h>

int main(){
    char name[5];
    	name[0] = 'W';
	name[1] = 'e';
	name[2] = 'i';
	name[3] = 'y';
        name[4] = 'e';

	printf("第一个字母：%c,第四个字符：%c\n",name[0],name[3]);
	printf("%s\n",name);
	printf("Name THE OF END\n");

    char name1[6] = {'W','e','i','y','e','\0'};
	printf("%s\n",name1);
	printf("Name1 THE OF END\n\n\n");
	
	char a[] = {'I','L','O','V','e'};
	printf("a[char]=%s\n",a);  //有overflow 
	char c[] = {'I','L','O','V','e','\0'};
	printf("a[char]=%s\n",c);

	char a1[] = {"I'd like study C!"};
	char b[] = "Test C pragram!\n";

	printf("a[{\"string\"}]=%s\n",a1);
	printf("a[\"string\"]=%s",b);

}
