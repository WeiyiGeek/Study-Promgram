/**ʹ�õ�����������ͨѶ¼����ɾ�Ĳ�,����ʹ���ڴ�ص���ؼ���**/
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

//�еĻ�ֱ�Ӵ��ڴ��ȡ,�ڴ��Ϊ�յĻ�ֱ������malloc���������ڴ�ռ�
struct Info *pool = NULL;
int count;

void getInput(struct Info *person);  //��add�е���
void printPerson(struct Info *person);  //��disp�е���
void addPerson(struct Info **contacts);
void delPerson(struct Info **contacts);  //ʹ���ڴ��
struct Info *findPerson(struct Info *contacts); //��del��change�е���
void changePerson(struct Info *contacts);
void displayPerson(struct Info *contacts);
void release(struct Info **contacts);  //ʹ���ڴ��

void getInput(struct Info *person) {
  printf("���������� ��");
  scanf("%s", person->name);
  printf("������绰 ��");
  scanf("%s", person->phone);
}
void addPerson(struct Info **contacts)
{
  struct Info *person;
  struct Info *temp;

  //if�ڴ�� ���ǿա�,��ֱ�Ӵ������ȡ�ռ�
  if( pool != NULL){
      person = pool;  //ȡ������,�ظ�����
      pool = pool->next;
      count--;

  }else{
    //if�ڴ��Ϊ��,�����malloc���������µ��ڴ�ռ�
    person = (struct Info *)malloc(sizeof(struct Info));
    if (person == NULL)
    {
      /* code */
      printf("�����ڴ�ʧ��\n");
      exit(0);
    }
  }
  //���������ϵ����Ϣ
  getInput(person);
  //����ͷ���뷨����Ϣ��ӵ�ͨѶ¼��
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
  printf("��ϵ�� : %s\n", person->name);
  printf("�� ��  : %s\n", person->phone);
}

struct Info *findPerson(struct Info *contacts)
{
  struct Info *current;
  char input[40];

  printf("��������ϵ�� ��");
  scanf("%s", input);

  current = contacts; //ͷָ��
  //��current����NULL����strcmp�ҵ�ƥ����ַ����˳�whileѭ��
  while(current != NULL && strcmp(current->name, input))
  {
      current = current->next;
  }
  return current;  //���ظ�person
}
void changePerson(struct Info *contacts)
{
  struct Info *person;
  //�����ҵ�ƥ���ַ��Ľṹ�嵥�����еĽڵ�ָ��
  person = findPerson(contacts);
  if(person == NULL){
    printf("�Ҳ�����ϵ��");
  }else{
    printf("�������µĵ绰���� ��");
    scanf("%s", person->phone);
  }
}

void delPerson(struct Info **contacts)
{
  struct Info *temp;
  struct Info *person;
  struct Info *current;

  struct Info *pervious;
  //�ҵ�Ҫɾ���Ľڵ�ָ��
  person = findPerson(*contacts);
  if(person == NULL)
  {
    printf("�Ҳ�������ϵ��\n");
  }
  else
  {
    current = *contacts; //ͷָ��
    pervious = NULL;
    while(current != NULL && current != person)
    {
      pervious = current;
      current = current->next;
    }
    if(pervious == NULL)
    {
      //�ҵ���ɾ���ĵ�һ���ڵ�
      *contacts = current->next;
    }else{
      //��ɾ���Ľڵ㲻�ǵ�һ���ڵ�;
      pervious->next = current->next;
    }

    //�ж��ڴ���ǲ����п�λ,���ǵĻ������ͷ������ͷžͺܺķ��ڴ�
    if(count < MAX)
    {
      //�����ڴ��ͬ������ͷ�巨
      if(pool != NULL)
      {
          temp = pool;
          pool = person; //(��һ����Ϣ��)
          person->next = temp;
      }else{
          pool = person;
          person->next = NULL;
      }
      count++;  //ʹ�ÿռ�

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
    printPerson(current);  //���ô�ӡ
    current = current->next;
  }
}

//����6����
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

//�ͷ��ڴ��
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
  struct Info *contacts = NULL; //ͷָ��
  struct Info *person;

  printf(" ===== ͨѶ¼�������ѡ�� =====\n");
  printf(" 1 - �����µ���ϵ��\n");
  printf(" 2 - ����������ϵ��\n");
  printf(" 3 - ����������ϵ��\n");
  printf(" 4 - ɾ��������ϵ��\n");
  printf(" 5 - ��ʾ��ǰͨѶ¼\n");
  printf(" 6 - �˳�ͨѶ¼\n");
  do {
    printf("����������Ĳ���ѡ���� : ");
    scanf("%d", &taskId);
    switch (taskId) {
      case 1: addPerson(&contacts);break;
      case 2: person = findPerson(contacts);
              if(person == NULL){
                printf("δ�ҵ�ָ�����ַ���\n\n");
              }else{
                printPerson(person);
              }
              break;
      case 3: changePerson(contacts);break;
      case 4: delPerson(&contacts);break;
      case 5: displayPerson(contacts);break;
      case 6: goto release;
      default : printf("��,��������ȷ�����������ţ�������\n");
    }
	putchar('\n');
  } while(1);

release:printf("�����ͷŶ�������ڴ�\n");
        release(&contacts);
        releasePool();

  return 0;
}
