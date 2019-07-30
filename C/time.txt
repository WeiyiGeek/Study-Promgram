#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <math.h>

/**算法**/
void arithmeticfun(){
	unsigned int i,j;
	double y;
	for(i = 0; i < 100; i++)
	{
		for(j = 0; j < 100; j++){
			usleep(1000);
			y++;
		}
	}
	printf("Value:%f\n",y);
}

int main(){
	struct timeval startTime,endTime;
	float execUse;
	
	gettimeofday(&startTime,NULL);
	arithmeticfun();
	gettimeofday(&endTime,NULL);
	/*计算程序执行花费的时间*/
	execUse = 1000000 * (endTime.tv_sec - startTime.tv_sec) + endTime.tv_usec - startTime.tv_usec;
	execUse /= 1000000;
	printf("Use Time:%f sec\n",execUse);
	exit(0);
}
