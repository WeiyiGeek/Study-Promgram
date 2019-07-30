#include <stdio.h>
#include <time.h>
/**使用枚举类型**/

int main(void)
{
  enum Week {sun, mon, tue, wed, thu, fri, sat}; //声明枚举变量名称
  enum Week today; //根据枚举类型定义若干的枚举变量
  struct tm *p;
  time_t t; //声明一个time_t类型的变量t
  time(&t); //将变量t的地址放入在time函数中返回表示当前时间
  p = localtime(&t); //返回值为指向tm的指针
  today = p->tm_wday;
  printf("当前时间 ：%d-%d-%d %02d:%02d:%02d\n",p->tm_year + 1900, p->tm_mon + 1, p->tm_mday, p->tm_hour, p->tm_min, p->tm_sec);
  switch (today) {
    case mon:
    case tue:
    case wed:
    case thu:
    case fri:
            printf("| 工作日 |\n");
            break;
    case sat:
    case sun:
            printf("| 放假 |\n");
            break;
    default:printf("Error\n");
  }

  return 0;
}
