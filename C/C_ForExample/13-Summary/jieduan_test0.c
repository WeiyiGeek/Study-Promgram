#include <stdio.h>

int main(){
	int i,sum=0;
	for(i=1;i<1000;i++){
		//if( !(i % 3) || !(i % 5))
		if( i % 3 == 0 || i % 5 ==0){
			sum += i;
		}
	}

	printf("1000���ڵ�3��5�ı���֮��Ϊ:%d\n",sum);
}