#include <stdio.h>
#define YEAR (year - 2014)
#define MONTH (month - 1)

int main()
{
  int year,month;
  float pm[3][12] = {
    {0,0,0,0,0,0,0,31.3,35.5,58.7,49.6,55.5},
    {59.8,54.9,33.1,38.2,26.6,20.5,27.8,38.5,41.5,44.7,38.1,41.5},
    {34.9,36.4,47.5,37.9,30.6,23.4,26.6,34.3,0,0,0,0}
  };
  printf("请输入查询的月份(year-month):");
  scanf("%d-%d",&year,&month);
#if 1
  if((int)pm[YEAR][MONTH] == 0){
    printf("抱歉该月份未查询到收录的数据\n");
  }else{
    printf("%4d年%d月的PM2.5值为:%3.1f\n",year,month,pm[YEAR][MONTH]);
  }
#endif
}
