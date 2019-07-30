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
//���ݺ���ԭ��ʵ��strtok()����
char* myStrtok_origin(char* str_arr,constchar* delimiters,char**temp_str)
{
    //����һ��ָ����ָ����ֽ⴮
    char*b_temp;
    /*
    * 1���жϲ���str_arr�Ƿ�Ϊ�գ������NULL���Դ��ݽ�����temp_str��Ϊ��ʼλ�ã�
    * ������NULL������strΪ��ʼλ�ÿ�ʼ�з֡�
    */
    if(str_arr == NULL)
    {
        str_arr =*temp_str;
    }
    //2���������ֽ��ַ���
    //ɨ��delimiters�ַ���ʼ�����зֽ��
    str_arr += strspn(str_arr, delimiters);
    //3���жϵ�ǰ���ֽ��λ���Ƿ�Ϊ'\0'�������򷵻�NULL���������
    if(*str_arr =='\0')
    {
        return NULL;
    }
    /*
    * 4�����浱ǰ�Ĵ��ֽ⴮��ָ��b_temp������strpbrk()��b_temp���ҷֽ����
    * ����Ҳ�������temp_str��ֵΪ���ֽ��ַ���ĩβ��'\0'��λ�ã�
    * b_tempû�з����仯�����ҵ��򽫷ֽ������λ�ø�ֵΪ'\0',
    * b_temp�൱�ڱ��ض��ˣ�temp_strָ��ֽ������һλ�á�
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
    //5��������󲿷�������û�ҵ��ֽ��������b_temp���ء�
    return b_temp;
}
//ʹ��myStrtok����myStrtok_origin����
char* myStrtok(char* str_arr,constchar* delimiters)
{
    staticchar*last;
    return myStrtok_origin(str_arr, delimiters,&last);
}
int main(void)
{
    char buf[]="hello@boy@this@is@heima";
    //1��ʹ��myStrtok_origin()����
    char*temp_str = NULL;
    char*str = myStrtok_origin(buf,"@",&temp_str);
    while(str)
    {
        printf("%s ",str);
        str = myStrtok_origin(NULL,"@",&temp_str);
    }
    //2��ʹ��myStrtok()����
    char*str1 = myStrtok(buf,"@");
    while(str1)
    {
        printf("%s ",str1);
        str1 = myStrtok(NULL,"@");
    }
    return0;
}
