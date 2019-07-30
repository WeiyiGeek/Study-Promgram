#if 0
#include <stdio.h>
#include <string.h>

int main(void)
{
    int i = 0;
    char *str = "This,is,a,demo";
    char *temp;
    temp = strtok(str,",");
    while(temp){
        i++;
        printf("i = %d\t",i);
        printf(",Strlen : %d \t",strlen(temp));
        printf("%s\n",temp);
        temp = strtok(NULL, ",");
    }

    return 0;
}

#include <stdio.h>
#include <string.h>
int main()
{
  char str[] = "mv a.c b.c";
  char *p;
  p = strtok(str, " ");
  while(p)
  {
    printf("%s\n", p);
    p = strtok(NULL, " ");
  }
  return 0;
}

#endif 0
#include<stdio.h>
#include<string.h>
//根据函数原型实现strtok()函数
char* myStrtok_origin(char* str_arr,constchar* delimiters,char**temp_str)
{
    //定义一个指针来指向待分解串
    char*b_temp;
    /*
    * 1、判断参数str_arr是否为空，如果是NULL就以传递进来的temp_str作为起始位置；
    * 若不是NULL，则以str为起始位置开始切分。
    */
    if(str_arr == NULL)
    {
        str_arr =*temp_str;
    }
    //2、跳过待分解字符串
    //扫描delimiters字符开始的所有分解符
    str_arr += strspn(str_arr, delimiters);
    //3、判断当前待分解的位置是否为'\0'，若是则返回NULL，否则继续
    if(*str_arr =='\0')
    {
        return NULL;
    }
    /*
    * 4、保存当前的待分解串的指针b_temp，调用strpbrk()在b_temp中找分解符，
    * 如果找不到，则将temp_str赋值为待分解字符串末尾部'\0'的位置，
    * b_temp没有发生变化；若找到则将分解符所在位置赋值为'\0',
    * b_temp相当于被截断了，temp_str指向分解符的下一位置。
    */
    b_temp = str_arr;
    str_arr = strpbrk(str_arr, delimiters);
    if(str_arr == NULL)
    {
        *temp_str = strchr(b_temp,'\0');
    }
    else
    {
        *str_arr ='\0';
        *temp_str = str_arr +1;
    }
    //5、函数最后部分无论找没找到分解符，都将b_temp返回。
    return b_temp;
}
//使用myStrtok来简化myStrtok_origin函数
char* myStrtok(char* str_arr,constchar* delimiters)
{
    staticchar*last;
    return myStrtok_origin(str_arr, delimiters,&last);
}
int main(void)
{
    char buf[]="hello@boy@this@is@heima";
    //1、使用myStrtok_origin()函数
    char*temp_str = NULL;
    char*str = myStrtok_origin(buf,"@",&temp_str);
    while(str)
    {
        printf("%s ",str);
        str = myStrtok_origin(NULL,"@",&temp_str);
    }
    //2、使用myStrtok()函数
    char*str1 = myStrtok(buf,"@");
    while(str1)
    {
        printf("%s ",str1);
        str1 = myStrtok(NULL,"@");
    }
    return0;
}
