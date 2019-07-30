#include <stdio.h>
#include <stdlib.h>

int main(void)
{	
	FILE *fp = NULL;
	long offset;
	char text[] = "1234567890abcdefghijklmnopqrstuvwxyz";

	if((fp = fopen("date.txt","wb")) == NULL)	
	{
		printf("打开失败！！\n");
		exit(EXIT_FAILURE);
	}
	
	//写入我们建立的数组到文件
	fputs(text, fp);
	fclose(fp);

	//注意下面是坑，不能在写入文件时候的进行读取文件，要单独进行。
	if((fp = fopen("date.txt","r")) == NULL)
        {
                printf("打开失败！！\n");
                exit(EXIT_FAILURE);
        }

	 
	fseek(fp, 9, SEEK_SET); //指向首部后第9个数的位置
	
	offset = ftell(fp);
	//注意输出的是ld占位符
	printf("当前文件指针的位置 : %ld,字符为 ：%c\n", offset, fgetc(fp)); //获取的是当前指针位置的下一个字符
	
	rewind(fp); //指向首部
	offset = ftell(fp);
        printf("当前文件指针的位置 : %ld,字符为 ：%c\n", offset, fgetc(fp));

	fseek(fp, -1, SEEK_END); //指向末尾倒数一个数的位置
	 offset = ftell(fp);
        printf("当前文件指针的位置 : %ld,字符为 : %c\n", offset, fgetc(fp));


	fclose(fp);
	return 0;
}

