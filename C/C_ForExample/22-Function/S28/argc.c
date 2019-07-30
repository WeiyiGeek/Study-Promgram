#include <stdio.h>
#include <stdlib.h>

int main(int argc,char *argv[]){
	int result = 0;
	if(argc != 0){
        for(int i = 1;i <= argc; i++){
		result += atoi(argv[i]);
			if(i == 3){
				printf("参数个数：%d\n",argc);
				goto bell;
			} 
		}
	}
bell:printf("参数之和为：%d\n",result);
	return 0;
}
