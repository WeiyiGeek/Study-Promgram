#include <stdio.h>

char *getWord(char);
#if 1
char *getWord(char c)
{
	switch(c)
	{
		case 'A': return "Apple";  //返回字符串A的地址
		case 'B': return "Banana";
		case 'C': return "Cat";
		case 'D': return "Dog";
		default: return "None";
	}
}

#endif

//不要返回局部变量的指针,无任何返回值
#if 0
char *getWord(char c)
{
	char str1[] = "Apple";
	char str2[] = "Banana";
	char str3[] = "Cat";
	char str4[] = "Dog";
	char str5[] = "None";

	switch(c)
	{
		case 'A': return str1;  //返回字符串A的地址
		case 'B': return str2;
		case 'C': return str3;
		case 'D': return str4;
		default: return str5;
	}
}
#endif

int main(void)
{
	char input;
	printf("请输入一个字母：");
	scanf("%c",&input);

	printf("%s\n",getWord(input));
	return 0;
}
