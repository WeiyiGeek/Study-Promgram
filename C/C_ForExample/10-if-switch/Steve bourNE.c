#include <stdio.h>

#define INT int
#define BEGIN {
#define END }

#define IF if(
#define THEN ){
#define ELSE }else{
#define FI ;}

INT main()
BEGIN
	INT i;
	printf("请输入你的年龄：");
	scanf("%d",&i);
	
	IF i < 18 THEN
		printf("你未满18周数！！");
	ELSE 
		printf("您已经满了18周数！！") 
	FI
END
