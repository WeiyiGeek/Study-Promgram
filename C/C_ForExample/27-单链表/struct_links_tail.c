/**链表之尾插法**/
#include <stdio.h>
#include <stdlib.h>

struct Book
{
  char title[128];   //单链表信息域
  char author[40];   //单链表信息域
  struct Book *next;   //单链表指针域,指向下一个相同的节点
};

void getInput(struct Book *book);
void addBook(struct Book **library);
void printfLibrary(struct Book *library);
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
  struct Book *book;
  //struct Book *temp; //*temp一个临时变量指针
  static struct Book *tail;  //建立一个静态变量(全局变量),保存上一次的值,在程序结束时候释放

  book = (struct Book *)malloc(sizeof(struct Book));
  if (book == NULL) {
    printf("内存分配失败了\n");
    exit(1); //错误代码1
  }
  getInput(book); //传入book的地址,填充信息域的内容

    #if 0
    //判断是不是空链表
    if( *library != NULL)
    {
      temp = *library;
    //每次执行都需要遍历到单链表的尾部位置
    while( temp->next != NULL)
    {
      temp = temp->next;
    }
    //到了NULL,就插入指向节点的地址
      temp->next = book;
      book->next = NULL;
    }else{
    //如果是空链表直接插入到尾部 , 指向新生成的节点的地址
      *library = book;
      book->next = NULL;
    }
    #endif

    #if 1
    //建立的节点直接插入到末尾而不需要遍历整个链表了
    if( *library != NULL)
    {
      tail->next = book;
      book->next = NULL;
    }
    else
    {
      *library = book;
      book->next = NULL;
    }
    tail = book;
    #endif
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
  struct Book *temp;  //创建一个临时变量指针
  while (*library != NULL) {
    temp = *library;
    *library = (*library)->next; //将头指针指向下一个指针
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
  releaseLibrary(&library); //释放申请的内存空间,注意要传入library地址

  return 0;
}
