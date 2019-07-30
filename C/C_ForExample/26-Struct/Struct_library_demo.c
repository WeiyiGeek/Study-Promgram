#include <stdio.h>
#include <stdlib.h>

struct Date
{
  int year;
  int month;
  int day;
};

struct Book
{
  char title[128];
  char author[40];
  float price;
  struct Date date;
  char publisher[100];
};

void *getInput(struct Book *book); //声明：*book指向这个结构体变量的指针,返回值实质也是一个地址
void showBook(struct Book *book);  //不需要返回值

void *getInput(struct Book *book)
{
  printf("请输入书名：");
  scanf("%s", book->title);  //利用指针访问它的成员
  printf("请输入作者：");
  scanf("%s", book->author);
  printf("请输入售价：");
  scanf("%f", &book->price);
  printf("请输入日期：");
  scanf("%d-%d-%d", &book->date.year, &book->date.month, &book->date.day);
  printf("请输入出版社：");
  scanf("%s", book->publisher);
};

void showBook(struct Book *book)
{
  printf("书名 ：%s\n", book->title);
  printf("作者 ：%s\n", book->author);
  printf("价格 ：%.2f\n", book->price);
  printf("日期 ：%d-%d-%d\n", book->date.year, book->date.month, book->date.day);
  printf("出版社 ：%s\n", book->publisher);
}

int main(void)
{
  int flag = 1,count=1; //flag 用于判断是否继续录入书籍
  struct Book *book = NULL; //对结构体指针初始化为NULL

  printf("欢迎光临图书馆！\n");
  while(flag){
    printf("请输入第%d本书的信息：\n", count);
    book = (struct Book *)realloc(book, count * sizeof(struct Book));  //这里进行重新分配内存空间
    if (book==NULL) exit(1);
    getInput(book+count-1);  //指针变量 + 1 , 进行递增 book , book + 1;
    count++;
    printf("是否继续输入书本信息(1 = Yes, 0 = NO):");
    scanf("%d", &flag);  //判断 1 还是 0
    putchar('\n');
  }

  printf("\n=========== 打印结果 ============ \n");
  for (int i = 0; i < count - 1; i++)
  {
    printf("第%d本书的信息：\n", i+1);
    showBook(book+i);
    putchar('\n');
  }

  free(book);
  return 0;
}
