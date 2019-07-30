#include <stdio.h>
#include <stdlib.h>

#define N 4

struct Stu
{
	char name[24];
	int num;
	float score;

} stu[N], sb;

int main(void)
{
	FILE *fp;
	int i;
	
	//以二进制模式打开写入模式打开
	if((fp = fopen("socre.txt","wb")) == NULL)
	{
		printf("打开文件失败！");
		exit(EXIT_FAILURE);
	}
	printf("请录入成绩(格式 ：name ID score):\n");
	for(i = 0; i < N; i++)
	{
		scanf("%s %d %f",stu[i].name, &stu[i].num, &stu[i].score);
	}	
	
	fwrite(stu, sizeof(struct Stu), N, fp);  //二进制写入
	fclose(fp);	

	//读取文件
	if((fp = fopen("socre.txt","rb")) == NULL)
        { 
                printf("打开文件失败！");
                exit(EXIT_FAILURE);
       	}
	
	fseek(fp,sizeof(struct Stu),SEEK_SET); //偏移到第一个结构体大小后，及下标为1的结构体数组首部为指针位置
	fread(&sb, sizeof(struct Stu), 1, fp); //实际读取第二行

	printf("\n打印第二个学生的成绩：\n你好 %s ,学号 %d ,成绩 %.2f\n",sb.name, sb.num, sb.score);
	fclose(fp);

	return 0;
}
