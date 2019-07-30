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

 //类型        变量名
   int a;
   int aa[10];//0~9

   struct cat xiaohuahua;  //结构体定义引用 
   struct cat xiaohuahua_array[10]; //结构体数组 定义 

   
//类型       *  指针名， 
  int        *pa = &a;
  struct cat *ptcat = &xiaohuahua;
  
  for(a=0;a<10;a++){
      aa[a]=a+1;
  }

  for(a=0;a<10;a++){
  	     printf("aa[%d]=%d \n",a,aa[a]);
  }
  
 //采用结构体直接访问成员 
  strcpy(xiaohuahua.name,"xiaohuahua");
  strcpy(xiaohuahua.sex,"girl"); 
  xiaohuahua.len=20;
  
  //采用指针方式访问结构体里面的成员 
  ptcat->weight=50;
  strcpy(ptcat->color,"gray");
  
	putchar('\n'); 
  printf("xiaohuahua info name:%s sex:%s len%f weight:%f color:%s\n",xiaohuahua.name,xiaohuahua.sex,xiaohuahua.len,ptcat->weight,ptcat->color);
  	putchar('\n'); 

  
  //借给有数组的访问形式 
  for(a=0;a<10;a++){
  	strcpy(xiaohuahua_array[a].name,"xiaohuahua");
  	xiaohuahua_array[a].weight=a+50;
  } 

  for(a=0;a<10;a++){
  	  printf("xiaohuahua_array[%d] name:%s,weight:%.2f\n",a,xiaohuahua_array[a].name,xiaohuahua_array[a].weight);
  }
  

 }
  
