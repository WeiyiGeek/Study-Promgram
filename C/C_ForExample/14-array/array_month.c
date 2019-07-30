#include <stdio.h>

int main(){
	int month[12];
	int year,day,i;
	printf("请输入年数:");
	scanf("%d",&year);
	if((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0 )){
		month[1]=29;
	}else{
		month[1]=28;
	}

	for(i=0;i<12;i++){
		if(i != 1){
			if(i == 3 || i == 5 || i == 8 || i == 10){
				month[i]=30;
			}else{
				month[i]=31;
			}
		}
	}	

	for(i=0;i<12;i++){
		printf("第%2d月份:%d天\n",i+1,month[i]);
	}
	return 0;
	
}