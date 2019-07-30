#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Date
{
	int year;
	int month;
	int day;
};

struct Book
{
	char name[40];
	char author[40];
	float price;
	struct Date date;
};


int main(void)
{
	FILE *fp;
	struct Book *book_for_write, *book_for_read;

	book_for_write = (struct Book *)malloc(sizeof(struct Book));
	book_for_read = (struct Book *)malloc(sizeof(struct Book));
	if(book_for_read == NULL || book_for_write == NULL){
		printf("内存写入失败！\n");
		exit(EXIT_FAILURE);
	}
	
	strcpy(book_for_write->name, "C-language");
	strcpy(book_for_write->author, "WeiyiGeek");
	book_for_write->price = 17.98;
	book_for_write->date.year = 2018;
	book_for_write->date.month = 3;
	book_for_write->date.day = 18;

	//其实二进制打开与输出影响都不大,在Linux上执行时候
	if((fp = fopen("file.txt","w")) == NULL)
	{
	                printf("文件打开失败！\n");
	                exit(EXIT_FAILURE);
	}	
	printf("正在向文件中写入数据.......\n");
	fwrite(book_for_write, sizeof(struct Book), 1, fp);
	fclose(fp);

	//验证是不是写入的成功，我们就读取

	if((fp = fopen("file.txt","r")) == NULL)
        { 
                        printf("文件打开失败！\n");
                        exit(EXIT_FAILURE);
       	}
	
	printf("\n写入数据成功, 正在打印数据......\n");

	fread(book_for_read, sizeof(struct Book), 1, fp);
	printf("书名 : %s\n", book_for_read->name);
	printf("作者 : %s\n", book_for_read->author);
        printf("价格 : %.2f\n", book_for_read->price);
        printf("出版时间 : %d-%d-%d\n", book_for_read->date.year, book_for_read->date.month, book_for_read->date.day);

	fclose(fp);
	return 0;
}

