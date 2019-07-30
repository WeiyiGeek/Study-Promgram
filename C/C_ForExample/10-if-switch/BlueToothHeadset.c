#include <stdio.h>
#include "ssebtr1.h"

int main(){
	int age,BPM,maxheart,nowheart;
	printf("请输入你的年龄：");
	scanf("%d"，&age);
	
	maxheart = 220 - age;
	BPM = 150;
	nowheart = getHeartRate(); 
 	playSound(BPM);

	if(nowheart > maxheart){
		printf("Please ，Stop Run！\n");
	}else if(nowheart > (maxheart * 0.85)){
		printf("请放慢脚步！\n");
		BPM -=20;
		playSound(BPM); // 你不能在这里传入bpm-20 
	}else if(nowheart < (maxheart * 0.75)){
		printf("Come on！,请加快节奏吧！");
		BPM+=20;
		playSound(BPM); // 你不能在这里传入bpm+20 
	}else{
		playSound(BPM); // 你不能在这里传入bpm-20 
	}
}

