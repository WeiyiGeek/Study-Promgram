#include <stdio.h>
#include <stdlib.h>

struct Node
{
  int value;
  struct Node *next;
};

void insertHead(struct Node **head, int value);  //ָ��Node�ṹ���ָ���ָ��,������ֵ������
void printHead(struct Node *head); //��ӡ����
void deletetHead(struct Node **head, int value);

void insertHead(struct Node **head, int value)
{
  struct Node *previous;  //��ס�����½ڵ����һ���ڵ��ָ��(ԭ��ָ��current)
  struct Node *new1;
  struct Node *current;  //���½����Ľڵ��ָ����ָ��� previous ��ס��һ���ڵ��ָ��

  current = *head;
  previous =  NULL;

  while (current != NULL && current->value < value) {
    previous = current;        //��¼Current����һ����ַ
    current = current->next;   //current ָ����һ���ڵ�
  }

  new1 = (struct Node *)malloc(sizeof(struct Node));
  if( new1 == NULL)
  {
    printf("�����ڴ�ռ�ʧ�ܣ�\n");
    exit(1);
  }
  new1->value = value;
  new1->next = current;
  //��WHILEѭ������ִ�е�ʱ��,ʱ�����current����һ������ΪNULL
  if( previous == NULL)
  {
    *head = new1; //���뵽ͷָ��,���ǵ�һ���ڵ��λ�á�
  }
  else
  {
    previous->next = new1; //����ͽ�new��ָ�����һ���ڵ�
  }

}

void deletetHead(struct Node **head, int value)
{
    struct Node *previous;
    struct Node *current;

    current = *head;  //ͷָ��
    previous = NULL;

    while (current != NULL && current->value != value) {
      previous = current;
      current = current->next;
    }

    if(current == NULL){
      printf("û���ҵ�Ҫɾ�����ַ���\n");
      return ;
    }else{

        if(previous == NULL){
          *head = current;
        }else{
          previous->next = current->next;
        }
		return ;
    }
}


void printHead(struct Node *head)
{
  struct Node *current;
  current = head;
  while( current != NULL)
  {
      printf("%d  ", current->value);
      current = current->next;
  }
  putchar('\n');
}


int main(void)
{
  struct Node *head = NULL; //��ʾ������
  int num;
  printf("�����������֣�\n");
  while (1) {
    printf("������Ҫ���������(-1)������");
    scanf("%d", &num);
    if (num == -1) {
      break;
    }
    insertHead(&head, num);
    printHead(head);
  }
  printf("����Ҫɾ�������֣�\n");
  while (1) {
    printf("������Ҫɾ��������(-1)������");
    scanf("%d", &num);
    if (num == -1)
    {
      break;
    }
    deletetHead(&head, num);
    printHead(head);
  }

  return 0;
}
