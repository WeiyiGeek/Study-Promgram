#include <stdio.h>
/**��1�ӵ�100���㷨���бȽ�ѧϰ*/

int normaldate();
int gaosidate();

/*�����㷨*/
int normaldate(){
	int i,result=0;
	for( i=1; i <= 100; i++)
	{
		result += i;  //��Ҫѭ��100��
	}
	return result;
}

/*��˹�㷨*/
int gaosidate(){
	int i = 100,result;
	result = ( 1 + i) * i / 2; //ִ��һ�μ���,��Ч
	return result;
}

int main(void)
{
	printf("��1+2+3+....+100�������㷨VS��\n");
	printf("��ͨ�㷨 ��%d\n", normaldate());
	printf("��˹�㷨 ��%d\n", gaosidate());
	return 0;
}
