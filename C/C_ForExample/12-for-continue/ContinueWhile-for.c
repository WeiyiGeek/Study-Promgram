#include <stdio.h>

int main(){
	
	int i;
	for(i=1;i<10;i++)
	{
		if(5 == i)
		{
			continue;
		}
		printf("���ǵ�%d��ѭ��\n",i);
	}
	/**BUG**
	int i=0;
	while(i<10)
	{
	1	if(5 == i)
		{
			continue;
		}
		printf("����һ����ѭ��BUG!!\n");
		i++;
	}
	
	**/
	
	return 0;
}
