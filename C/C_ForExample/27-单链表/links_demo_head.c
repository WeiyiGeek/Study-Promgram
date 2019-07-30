#include <stdio.h>
#include <stdlib.h>

struct Book
{
  char title[128];   //��������Ϣ��
  char author[40];   //��������Ϣ��
  struct Book *next;   //������ָ����,ָ����һ����ͬ�Ľڵ�
};

void getInput(struct Book *book)
{
    printf("������������");
    scanf("%s", book->title);
    printf("���������ߣ�");
    scanf("%s", book->author);
}

void addBook(struct Book **library)  //ע�������� ��������� ,��ָ��Book�ṹ��ָ���ָ��
{
  struct Book *book, *temp; //*tempһ����ʱ����ָ��

  book = (struct Book *)malloc(sizeof(struct Book));
  if (book == NULL) {
    printf("�ڴ����ʧ����\n");
    exit(1); //�������1
  }
  getInput(book); //����book�ĵ�ַ,�����Ϣ�������

  //�ж��ǲ��ǿ�����
  if( *library != NULL)
  {
    //�����������ԭ���Ѿ�������Ϣ������ָ�����������ɵĽڵ�,�����ǽ����Ĳ��뵽�������ͷ����
    temp = *library;
    *library = book;
    book->next = temp;

  }else{
    *library = book; //ָ�������ɵĽڵ�
    book->next = NULL;
  }

}

void printfLibrary(struct Book *library)
{
  struct Book *book;
  int count = 1;

  book = library;
  while (book != NULL) {
    //��ӡ��Ϣ��
    printf("================  Book %d  ============= \n",count);
    printf("������%s\n",book->title);
    printf("���ߣ�%s\n",book->author);
    book = book->next;
    count++;
  }
}


//�ͷ�������ڴ�ռ�
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
  struct Book *library = NULL;// == ͷָ��head ,�տ�ʼָ��NULL˵���ǿ�����
  int ch;
  while(1){
    printf("�����Ƿ������鼮��Ϣ(Y/N)��");
    do
    {
      ch = getchar();
    }while(ch != 'Y' && ch != 'N');

    if (ch == 'Y')
    {
      addBook(&library); //�������½���Ϣ��ĵ�ַ
    }
    else
    {
      break;  //�˳���ѭ��
    }
    putchar('\n');
  }
  printf("�����Ƿ���Ҫ��ӡ¼��ͼ����(Y/N):");
  do
  {
    ch = getchar();
  }while(ch != 'Y' && ch != 'N');

  if(ch == 'Y')
  {
    printfLibrary(library); //��ӡ¼���鼮��Ϣ
  }
  releaseLibrary(&library); //�ͷ�������ڴ�ռ�

  return 0;
}
