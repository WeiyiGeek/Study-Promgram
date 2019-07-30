#include <stdio.h>
#include <stdlib.h>
/**typedef 与 struct 好基友连用**/

//在给结构体取别名的时候还能定义指针的(通用方法)
typedef struct Date
{
  int year;
  int month;
  int day;
} DATE, *PTRDATE;

int main(void)
{
  struct Date *date;
  //下面可以直接采用typedef别名替换
  //date = (struct Date *)malloc(sizeof(struct Date));
  date = (DATE *)malloc(sizeof(DATE));  //方案一：
  date = (PTRDATE)malloc(sizeof(DATE));   //方案二：

  if(date == NULL)
  {
      printf("申请内存失败\n");
      exit(1);
  }
  date->year = 2018;
  date->month = 03;
  (*date).day = 16;
  printf("当前的 年 - 月 - 日 ：%d - %d - %d \n", date->year, date->month ,date->day);
  return 0;
}
