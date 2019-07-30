#include <stdio.h>
#include <stdlib.h>

struct Node
{
  int value;
  struct Node *next;
};

void insertHead(struct Node **head, int value);  //指向Node结构体的指针的指针,及插入值
void printHead(struct Node *head); //打印链表

void insertHead(struct Node **head, int value)
{
  struct Node *previous;  //记住插入新节点的上一个节点的指针(原本指向current)
  struct Node *new1;
  struct Node *current;  //让新建立的节点的指针域指向的 previous 记住上一个节点的指针

  current = *head;
  previous =  NULL;

  while (current != NULL && current->value < value) {
    previous = current;        //记录Current的上一个地址
    current = current->next;   //current 指向下一个节点
  }

  new1 = (struct Node *)malloc(sizeof(struct Node));
  if( new1 == NULL)
  {
    printf("申请内存空间失败！\n");
    exit(1);
  }

  new1->value = value;
  new1->next = current;
  //当WHILE循环不被执行的时候,时间就是current本身一进来就为NULL
  if( previous == NULL)
  {
    *head = new1; //插入到头指针,就是第一个节点的位置、
  }
  else
  {
    previous->next = new1; //否则就将new的指针给上一个节点
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
  struct Node *head = NULL; //表示空链表
  int num;
  while (1) {
    printf("请输入要插入的数字(-1)结束：");
    scanf("%d", &num);
    if (num == -1) {
      break;
    }
    insertHead(&head, num);
    printHead(head);
  }

  return 0;
}
