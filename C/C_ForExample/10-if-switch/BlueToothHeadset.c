#include <stdio.h>
#include "ssebtr1.h"

int main(){
	int age,BPM,maxheart,nowheart;
	printf("������������䣺");
	scanf("%d"��&age);
	
	maxheart = 220 - age;
	BPM = 150;
	nowheart = getHeartRate(); 
 	playSound(BPM);

	if(nowheart > maxheart){
		printf("Please ��Stop Run��\n");
	}else if(nowheart > (maxheart * 0.85)){
		printf("������Ų���\n");
		BPM -=20;
		playSound(BPM); // �㲻�������ﴫ��bpm-20 
	}else if(nowheart < (maxheart * 0.75)){
		printf("Come on��,��ӿ����ɣ�");
		BPM+=20;
		playSound(BPM); // �㲻�������ﴫ��bpm+20 
	}else{
		playSound(BPM); // �㲻�������ﴫ��bpm-20 
	}
}

