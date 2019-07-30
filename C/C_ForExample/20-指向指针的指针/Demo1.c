#include <stdio.h>

int main(){
	char *cBooks[] = {
	"<C程序设计语言>",
	"<C编程专家>",
	"<C和指针>",
	"<C陷阱与缺陷>",
	"<C primer Plus>",
	"<xiaojiayu Works>"
	};

	int i;
	printf("Test:%s\t",cBooks[4]);
	char **byFishc;
	char **cLove[4];

	byFishc = &cBooks[5];
	cLove[0] = &cBooks[0];
	cLove[1] = &cBooks[1];
	cLove[2] = &cBooks[2];
	cLove[3] = &cBooks[3];

	printf("C小甲鱼：%s\n",*byFishc);
	for(i = 0; i < 4;i++){
		printf("%s\n",*cLove[i]); //*cLove[] = cBooks[];
	}	

	return 0;
}
