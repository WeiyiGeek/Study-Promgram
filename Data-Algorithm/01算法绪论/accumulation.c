#include <stdio.h>
/**从1加到100的算法进行比较学习*/

int normaldate();
int gaosidate();

/*常规算法*/
int normaldate(){
	int i,result=0;
	for( i=1; i <= 100; i++)
	{
		result += i;  //需要循环100次
	}
	return result;
}

/*高斯算法*/
int gaosidate(){
	int i = 100,result;
	result = ( 1 + i) * i / 2; //执行一次即可,高效
	return result;
}

int main(void)
{
	printf("从1+2+3+....+100的两种算法VS：\n");
	printf("普通算法 ：%d\n", normaldate());
	printf("高斯算法 ：%d\n", gaosidate());
	return 0;
}
