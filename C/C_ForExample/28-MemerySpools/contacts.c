/**使用单链表来进行通讯录的增删改查,并且使用内存池等相关技术**/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1024

struct Info
{
    char name[40];
    char phone[20];
    struct Info *next;
};

//有的话直接从内存池取,内存池为空的话直接利用malloc函数申请内存空间
struct Info *pool = NULL;
int count;

void getInput(struct Info *person);  //在add中调用
void printPerson(struct Info *person);  //在disp中调用
void addPerson(struct Info **contacts);
void delPerson(struct Info **contacts);  //使用内存池
struct Info *findPerson(struct Info *contacts); //在del和change中调用
void changePerson(struct Info *contacts);
void displayPerson(struct Info *contacts);
void release(struct Info **contacts);  //使用内存池

void getInput(struct Info *person) {
  printf("请输入姓名 ：");
  scanf("%s", person->name);
  printf("请输入电话 ：");
  scanf("%s", person->phone);
}
void addPerson(struct Info **contacts)
{
  struct Info *person;
  struct Info *temp;

  //if内存池 “非空”,则直接从里面获取空间
  if( pool != NULL){
      person = pool;  //取出垃圾,重复利用
      pool = pool->next;
      count--;

  }else{
    //if内存池为空,则调用malloc函数申请新的内存空间
    person = (struct Info *)malloc(sizeof(struct Info));
    if (person == NULL)
    {
      /* code */
      printf("申请内存失败\n");
      exit(0);
    }
  }
  //进行添加联系人信息
  getInput(person);
  //利用头插入法将信息添加到通讯录中
  if( *contacts != NULL)
  {
    temp = *contacts;
    *contacts = person;
    person->next = temp;
  }else{
    *contacts = person;
    person->next = NULL;
  }
}

void printPerson(struct Info *person)
{
  printf("联系人 : %s\n", person->name);
  printf("电 话  : %s\n", person->phone);
}

struct Info *findPerson(struct Info *contacts)
{
  struct Info *current;
  char input[40];

  printf("请输入联系人 ：");
  scanf("%s", input);

  current = contacts; //头指针
  //当current等于NULL或者strcmp找到匹配的字符则退出while循环
  while(current != NULL && strcmp(current->name, input))
  {
      current = current->next;
  }
  return current;  //返回给person
}
void changePerson(struct Info *contacts)
{
  struct Info *person;
  //返回找到匹配字符的结构体单链表中的节点指针
  person = findPerson(contacts);
  if(person == NULL){
    printf("找不到联系人");
  }else{
    printf("请输入新的电话号码 ：");
    scanf("%s", person->phone);
  }
}

void delPerson(struct Info **contacts)
{
  struct Info *temp;
  struct Info *person;
  struct Info *current;

  struct Info *pervious;
  //找到要删除的节点指针
  person = findPerson(*contacts);
  if(person == NULL)
  {
    printf("找不到该联系人\n");
  }
  else
  {
    current = *contacts; //头指针
    pervious = NULL;
    while(current != NULL && current != person)
    {
      pervious = current;
      current = current->next;
    }
    if(pervious == NULL)
    {
      //找到待删除的第一个节点
      *contacts = current->next;
    }else{
      //待删除的节点不是第一个节点;
      pervious->next = current->next;
    }

    //判断内存池是不是有空位,不是的话申请释放申请释放就很耗费内存
    if(count < MAX)
    {
      //存入内存池同样采用头插法
      if(pool != NULL)
      {
          temp = pool;
          pool = person; //(第一个信息域)
          person->next = temp;
      }else{
          pool = person;
          person->next = NULL;
      }
      count++;  //使用空间

    }else{
      free(person);
	  return ;
    }

  }
}

void displayPerson(struct Info *contacts)
{
  struct Info *current;
  current = contacts;
  while (current != NULL) {
    printPerson(current);  //调用打印
    current = current->next;
  }
}

//按键6功能
void release(struct Info **contacts)
{
  struct Info *temp;
  while( *contacts != NULL)
  {
      temp = *contacts;
      *contacts = (*contacts)->next;
      free(temp);
  }
}

//释放内存池
void releasePool(void)
{
  struct Info *temp;
  while(pool != NULL)
  {
    temp = pool;
    pool= pool->next;
    free(temp);
  }
}


int main(void)
{
  int taskId;
  struct Info *contacts = NULL; //头指针
  struct Info *person;

  printf(" ===== 通讯录程序操作选择 =====\n");
  printf(" 1 - 插入新的联系人\n");
  printf(" 2 - 查找已有联系人\n");
  printf(" 3 - 更改已有联系人\n");
  printf(" 4 - 删除已有联系人\n");
  printf(" 5 - 显示当前通讯录\n");
  printf(" 6 - 退出通讯录\n");
  do {
    printf("请输入上面的操作选择编号 : ");
    scanf("%d", &taskId);
    switch (taskId) {
      case 1: addPerson(&contacts);break;
      case 2: person = findPerson(contacts);
              if(person == NULL){
                printf("未找到指定的字符串\n\n");
              }else{
                printPerson(person);
              }
              break;
      case 3: changePerson(contacts);break;
      case 4: delPerson(&contacts);break;
      case 5: displayPerson(contacts);break;
      case 6: goto release;
      default : printf("亲,请输入正确的任务操作编号！！！！\n");
    }
	putchar('\n');
  } while(1);

release:printf("正在释放堆里面的内存\n");
        release(&contacts);
        releasePool();

  return 0;
}
