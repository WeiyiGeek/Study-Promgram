#include <stdio.h>
#include <stdlib.h>

struct Book
{
  char title[128];   //单链表信息域
  char author[40];   //单链表信息域
  struct Book *next;   //单链表指针域,指向下一个相同的节点
};

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

void printfLibrary(struct Book *library)
{
  struct Book *book;
  int count = 1;

  book = library;
  while (book != NULL) {
    //打印信息域
    printf("================  Book %d  ============= \n",count);
    printf("书名：%s\n",book->title);
    printf("作者：%s\n",book->author);
    book = book->next;
    count++;
  }
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
  int ch;
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
  printf("请问是否需要打印录入图书结果(Y/N):");
  do
  {
    ch = getchar();
  }while(ch != 'Y' && ch != 'N');

  if(ch == 'Y')
  {
    printfLibrary(library); //打印录入书籍信息
  }
  releaseLibrary(&library); //释放申请的内存空间

  return 0;
}
