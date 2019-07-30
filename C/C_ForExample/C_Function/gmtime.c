#include <stdio.h>
#include <time.h>

#define BST (+1)
#define CCT (+8)

int main(){
	time_t raw;
	struct tm *info;  //结构体指针
	raw = time(&raw);  //获取当前秒数
	info = gmtime(&raw); //info指针传入当前秒数到gmtime函数中
	
	printf("当前世界时钟：%3d:%02d\n",info->tm_hour,info->tm_min);
	printf("当前伦敦时钟：%2d:%02d\n",(info->tm_hour + BST)%24,info->tm_min);
	printf("当前北京时钟：%2d:%02d\n",(info->tm_hour + CCT)%24,info->tm_min);
	
}
