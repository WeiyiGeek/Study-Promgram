#include <stdio.h>
#include <math.h>

int main(){
  float max = 0,min = 1024;
  float pm[3][12] = {
    {0,0,0,0,0,0,0,31.3,35.5,58.7,49.6,55.5},
    {59.8,54.9,33.1,38.2,26.6,20.5,27.8,38.5,41.5,44.7,38.1,41.5},
    {34.9,36.4,47.5,37.9,30.6,23.4,26.6,34.3,0,0,0,0}
  };
  
  char phys = '*'; 
  int phycnt; 
  for(int i = 0; i < 3; i++){
  	for(int j = 0; j < 12; j++){
  		if(max < pm[i][j]){
  			max = pm[i][j];

		  }
		if(pm[i][j] != 0 && min > pm[i][j]){
			min = pm[i][j];
		}
	  }
  }
    printf("PM2.5最小值:%.2f , PM2.5最大值:%.2f\n",min,max);
#if 1  
  for(int i = 0; i < 3; i++)
  {
  	for(int j = 0; j < 12; j++)
	{
  		if(pm[i][j] != 0){
  			printf("%4d年%2d月：",2014+i,j+1);
  			phycnt = (int)round(pm[i][j]) - (int)min;
  			while(phycnt--){
  				printf("%c",phys);
			}
			putchar('\n'); 
		}
  	}
  } 
#endif 
	return 0;
}

