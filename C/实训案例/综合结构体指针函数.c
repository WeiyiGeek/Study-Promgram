#include <stdio.h>
#include <string.h>

struct cat
{
   char name[32];
   char sex[32];
   double weight;
   double len;
   char color[32];
};
 
 void main (void)
 {

 //����        ������
   int a;
   int aa[10];//0~9

   struct cat xiaohuahua;  //�ṹ�嶨������ 
   struct cat xiaohuahua_array[10]; //�ṹ������ ���� 

   
//����       *  ָ������ 
  int        *pa = &a;
  struct cat *ptcat = &xiaohuahua;
  
  for(a=0;a<10;a++){
      aa[a]=a+1;
  }

  for(a=0;a<10;a++){
  	     printf("aa[%d]=%d \n",a,aa[a]);
  }
  
 //���ýṹ��ֱ�ӷ��ʳ�Ա 
  strcpy(xiaohuahua.name,"xiaohuahua");
  strcpy(xiaohuahua.sex,"girl"); 
  xiaohuahua.len=20;
  
  //����ָ�뷽ʽ���ʽṹ������ĳ�Ա 
  ptcat->weight=50;
  strcpy(ptcat->color,"gray");
  
	putchar('\n'); 
  printf("xiaohuahua info name:%s sex:%s len%f weight:%f color:%s\n",xiaohuahua.name,xiaohuahua.sex,xiaohuahua.len,ptcat->weight,ptcat->color);
  	putchar('\n'); 

  
  //���������ķ�����ʽ 
  for(a=0;a<10;a++){
  	strcpy(xiaohuahua_array[a].name,"xiaohuahua");
  	xiaohuahua_array[a].weight=a+50;
  } 

  for(a=0;a<10;a++){
  	  printf("xiaohuahua_array[%d] name:%s,weight:%.2f\n",a,xiaohuahua_array[a].name,xiaohuahua_array[a].weight);
  }
  

 }
  
