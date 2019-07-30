#include <stdio.h>

int main(){
	int i,j,k;
	printf("This is a Goto Demo:");
	for(i=1;i<10;i++){
		for(j=2;j<5;j++){
			for(k=1;k<10;k++){
					printf("i=%d,j=%d,k=%d\n",i,j,k);
					if(9 == k){
						goto prin;  //直接调到最外层循环
					}
	
			}
		}
	}
prin: printf("这里是直接goto到这里了!\n");

}
