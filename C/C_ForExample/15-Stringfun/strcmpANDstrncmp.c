#include <stdio.h>
#include <string.h>

int main(){
	char dest[40] = "www.cque.edu.cn";	
	char src1[40] = "www.cque.edu.cn";


	if(strcmp(dest, src1) == 0){
		printf("dest = src1\n");
	}
	
	char src2[20] = "www.cquE"; // A 65

	if(strncmp(src1, src2,8) > 0){
		printf("src1 > src2\n");
	}
	
	char src3[20] = "WWW";  // A 65
	if(strncmp(src3, src2,4) < 0){
		printf("src3 < src2\n");
	}
	
	return 0;
}
