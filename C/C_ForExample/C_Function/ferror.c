#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE *fp;
	int ch;
	if(( fp = fopen("text.txt","w")) == NULL)
	{
		printf("���ļ�ʧ�ܣ�..\n");
		exit(EXIT_FAILURE);
	}
	
	ch = getc(fp);
	if(ferror(fp))
	{
		perror("ԭ���ǣ�");
		printf("��ȡ�ļ�text.txtʧ�ܣ�..\n");
	} 
		
	fclose(fp);
	
	return 0;
	
}
