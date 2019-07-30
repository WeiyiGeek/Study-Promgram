#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Book
{
  char title[128];   //单链表信息域
  char author[40];
  struct Book *next;   //单链表指针域,指向下一个相同的节点
};

void getInput(struct Book *book);
void addBook(struct Book **library);
void printfBook(struct Book *book);
struct Book *searchBook(struct Book *library, char *target);
void releaseLibrary(struct Book **library);

void getInput(struct Book *book)
{
    printf("请输入书名：");
    scanf("%s", book->title);
    printf("请输入作者：");
    scanf("%s", book->author);
}

void addBook(struct Book **library)  //注意这里是 两层解引用 ,是指向Book结构的指针的指针
{
  struct Book *book, *temp; //*temp一个临时变量指针

  book = (struct Book *)malloc(sizeof(struct Book));
  if (book == NULL) {
    printf("内存分配失败了\n");
    exit(1); //错误代码1
  }
  getInput(book); //传入book的地址,填充信息域的内容

  //判断是不是空链表
  if( *library != NULL)
  {
    //这里是针对于原本已经存在信息域，重新指向我们新生成的节点,将我们建立的插入到单链表的头部。
    temp = *library;
    *library = book;
    book->next = temp;

  }else{
    *library = book; //指向新生成的节点
    book->next = NULL;
  }

}

//搜索链表中相匹配的字符串
struct Book *searchBook(struct Book *library, char *target)
{
  struct Book *book;
  book = library;
  while(book != NULL)
  {
    //匹配链表中的字符串,完全匹配输出0
    if(!strcmp(book->title,target) || !strcmp(book->author,target))
    {
      break;
    }
    book = book->next;
  }
  return book;
}

//打印出搜索结果
void printfBook(struct Book *book)
{
  printf("书名 ： %s\n", book->title);
  printf("作者 ： %s\n", book->author);
}

//释放申请的内存空间
void releaseLibrary(struct Book **library)
{
  struct Book *temp;
  while (*library != NULL) {
    temp = *library;
    *library = (*library)->next;
    free(temp);
  }

}

int main(void)
{
  struct Book *library = NULL;// == 头指针head ,刚开始指向NULL说明是空链表
  struct Book *book; //建立一个结构体指针存放返回的地址
  int ch;
  char input[128];

  while(1){
    printf("请问是否输入书籍信息(Y/N)：");
    do
    {
      ch = getchar();
    }while(ch != 'Y' && ch != 'N');

    if (ch == 'Y')
    {
      addBook(&library); //给的是新建信息域的地址
    }
    else
    {
      break;  //退出死循环
    }
    putchar('\n');
  }

  printf("请输入书名/作者后进行搜索:......");
  scanf("%s", input);
  book =searchBook(library, input);
  if( book == NULL)
  {
    printf("很抱歉,没找到你输入的信息\n");
  }
  else
  {
    do {
      printf("已找到符合条件的结果了\n");
      printfBook(book);
    } while((book = searchBook(book->next, input)) != NULL);  //继续找直到来到单链表的末端
  }

  //返回值是指向book结构体的指针
  releaseLibrary(&library); //释放申请的内存空间
  return 0;
}
