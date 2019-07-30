#include <stdio.h>
#include <stdlib.h>
/**采用Malloc动态的申请内存空间**/

struct Date
{
    unsigned year;
    unsigned month;
    unsigned day;
};

struct Info
{
    char name[40];
    unsigned short int sex;
    unsigned short int age;
    struct Date date;
};

void *getInput(struct Info *info);
void showInput(struct Info *info);

void *getInput(struct Info *info)
{
    printf("请输入姓名 ：");
    scanf("%s", info->name);
    printf("请输入性别(1 = 男, 0 = 女) ：");
    scanf("%u", &info->sex);
    printf("请输入年龄 ：");
    scanf("%d", &info->age);
    printf("请输入出生日期(如：2018-01-01) ：");
    scanf("%d-%d-%d", &info->date.year, &info->date.month, &info->date.day);
}

void showInput(struct Info *info)
{
  printf("姓名 ：%s\n", info->name);
  printf("性别 ：%s\n", ((info->sex) == 1)?"男":"女"); //注意这里是坑啊,字符串是"",''会报错warning: multi-character character constant
  printf("年龄 ：%d\n", info->age);
  printf("出生日期 ：%d-%d-%d\n",  info->date.year,  info->date.month,  info->date.day);
}

int main(void)
{
  struct Info *b1, *b2; //结构体变量指针
  b1 = (struct Info *)malloc(sizeof(struct Info)); //申请内存空间
  b2 = (struct Info *)malloc(sizeof(struct Info));
  if( b1 == NULL || b2 == NULL){
    printf("申请内存空间失败\n");
    exit(1);
  }
  printf("请输入第一个人的信息....\n");
  getInput(b1);   //直接传递一个地址进行修改, 就不用赋值了
  putchar('\n');
  printf("请输入第二个人的信息....\n");
  getInput(b2);

  printf("\n\n========== 录入完毕现在进行打印验证 =========\n\n");
  printf("打印第一个人的信息....\n");
  showInput(b1); //打印也是给一个地址,然后让他打印结构体Book里面的结构体成员
  putchar('\n');
  printf("打印第二个人的信息....\n");
  showInput(b2);

  //由于我们申请的内存空间在堆里;所以我们要将他释放掉
  free(b1);
  free(b2);

  return 0;
}
