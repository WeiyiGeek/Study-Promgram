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
	printf("������������䣺");
	scanf("%d",&i);
	
	IF i < 18 THEN
		printf("��δ��18��������");
	ELSE 
		printf("���Ѿ�����18��������") 
	FI
END
