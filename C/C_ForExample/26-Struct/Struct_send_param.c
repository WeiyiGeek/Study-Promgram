#include <stdio.h>

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

struct Book getInput(struct Book book); //注意好的习惯, 结构体函数getInput(形参)
struct Book getInput(struct Book book)  //这里的book是个形参
{
  printf("请输入书名：");
  scanf("%s", book.title);
  printf("请输入作者：");
  scanf("%s", book.author);
  printf("请输入售价：");
  scanf("%f", &book.price);
  printf("请输入日期：");
  scanf("%d-%d-%d", &book.date.year, &book.date.month, &book.date.day);
  printf("请输入出版社：");
  scanf("%s", book.publisher);
  return book;
};

struct Book showBook(struct Book book);
struct Book showBook(struct Book book)
{
  printf("书名 ：%s\n", book.title);
  printf("作者 ：%s\n", book.author);
  printf("价格 ：%.2f\n", book.price);
  printf("日期 ：%d-%d-%d\n", book.date.year, book.date.month, book.date.day);
  printf("出版社 ：%s\n", book.publisher);
}

int main(void)
{
  struct Book b1, b2; //设置两个结构体变量 , 在后面进行值传递
  printf("请输入第一本书的信息....\n");
  b1 = getInput(b1); //b1 是个实参 , 传递后将结构体给结构体变量b1
  putchar('\n');
  printf("请输入第二本书的信息....\n");
  b2 = getInput(b2); //b1 是个实参 , 传递后将结构体给结构体变量b1
  printf("\n\n========== 录入完毕现在进行打印验证 =========\n\n");
  printf("打印第一本书的信息....\n");
  showBook(b1);
  putchar('\n');
  printf("打印第一本书的信息....\n");
  showBook(b2);
  return 0;
}
