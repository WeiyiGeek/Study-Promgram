#include <stdio.h>
#include <math.h>

int main(){
 	float lottery,surplus;
 	int i;
 	
 	lottery=4000000;
 	
 	for(i=1;i>0;i++){
 		
 			surplus=lottery - 500000;
		 	lottery=surplus * (1 + 0.08);
			if(lottery <= 0){
				printf("最多%d年就恢复一贫如洗!\n",i);
				break;
			}
	}
	
	return 0; 
}




