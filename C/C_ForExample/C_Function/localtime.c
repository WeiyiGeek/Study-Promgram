#include <stdio.h>
#include <time.h>

#define SUN 0
#define MON 1
#define TUE 2
#define WEN 3
#define THU 4
#define FRI 5
#define SAT 6

int main(void)
{
  struct tm *p;
  time_t t; //声明一个time_t类型的变量t
  time(&t); //将变量t的地址放入在time函数中返回表示当前时间
  p = localtime(&t);

  printf("当前时间 ：%d-%d-%d %02d:%02d:%02d\n",p->tm_year + 1900, p->tm_mon + 1, p->tm_mday, p->tm_hour, p->tm_min, p->tm_sec);
  switch (p->tm_wday) {
    case MON:
    case TUE:
    case WEN:
    case THU:
    case FRI:
            printf("| 工作日 |\n");
            break;
    case SAT:
    case SUN:
            printf("| 放假 |\n");
            break;
    default:printf("Error\n");
  }

  return 0;
}
