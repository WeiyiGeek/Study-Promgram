#include <stdio.h>
/**��ͬ��ϵͳ,����ռ�õ��ֽڲ�ͬ**/ 

int main(){
	//�������ݳ��� 
	short int a;
	int b;
	long int c;
	long long int d;
	
	printf("/******�������ݳ���********/\n"); 
	printf("shor int ռ�õ��ֽڣ�%d B\n",sizeof(a));
	printf("int ռ�õ��ֽڣ�%d B\n",sizeof(b));
	printf("long int ռ�õ��ֽڣ�%d B\n",sizeof(c));
	printf("long long int ռ�õ��ֽڣ�%d B\n\n",sizeof(d));

	//�����������ݳ���
	float f;
	double db;
	long double ldb;
	
	printf("/******�����͵����ݳ���********/\n"); 
	printf("float ռ�õ��ֽڣ�%d B\n",sizeof(f));
	printf("double ռ�õ��ֽڣ�%d B\n",sizeof(db)); 
	printf("long double ռ�õ��ֽڣ�%d B\n\n",sizeof(ldb));  
	
	//�ַ��͵����ݳ��� 
	char ar;
	printf("/******�ַ��͵����ݳ���********/\n"); 
	printf("char ռ�õ��ֽڣ�%d B\n\n",sizeof(ar));
	
	printf("/******�����͵����ݳ���********/\n"); 
	printf("_Bool ռ�õ��ֽڣ�%d B\n",sizeof(_Bool));

	
	return 0;	
}

