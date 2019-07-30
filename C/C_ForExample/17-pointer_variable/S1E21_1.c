#include <stdio.h>
#include <math.h>

int main(){
	int num,i,j,cubed,sum=0;;
	
	printf("Please input a Number:");
	scanf("%d",&num);
	
	cubed=pow(num,3);

	for(i = 1; i < cubed; i+=2){
		for(j=i;j<cubed;j+=2){
			sum += j;
               		if(sum == cubed){ 
                       		 if( j -i > 4)
			         {
					printf("%d = %d + %d + ... +%d\n",cubed,i,i+2,j);	
				}else{
					printf("%d = %d + %d + %d\n",cubed,i,i+2,i+4);
				}
				goto FINDIT;
        	          }
			
			if(sum > cubed){
				sum = 0;
				break;
			}
	
		}	
		
	}

FINDIT:

	return 0;
}
