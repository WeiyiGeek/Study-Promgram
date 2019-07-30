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
  struct Book b1, b2; //设置两个结构体变量,在后面进行取值传递
  printf("请输入第一本书的信息....\n");
  getInput(&b1);   //直接传递一个地址进行修改, 就不用赋值了

  putchar('\n');

  printf("请输入第二本书的信息....\n");
  getInput(&b2);

  printf("\n\n========== 录入完毕现在进行打印验证 =========\n\n");
  printf("打印第一本书的信息....\n");
  showBook(&b1); //打印也是给一个地址,然后让他打印结构体Book里面的结构体成员

  putchar('\n');

  printf("打印第一本书的信息....\n");
  showBook(&b2);
  return 0;
}
