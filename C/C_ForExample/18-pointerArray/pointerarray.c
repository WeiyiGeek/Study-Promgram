#include <stdio.h>

int main(){
	char *p1[5] = {  //����һ��ָ������ 
		"��̸ı�����",
		"Just do it --- NIKE",
		"һ�н��п���",
		"����ֹ��",
		"one more thing" 
	};
	
	int i;
	
	for(i = 0;i < 5;i++){
		printf("%s\n", p1[i]);	 //�ӣ�ע������û��ȡֵ�����*������ָ�����鱾���ȡ�±�Ϊ0���ַ��� 
	}
	return 0;
} 

