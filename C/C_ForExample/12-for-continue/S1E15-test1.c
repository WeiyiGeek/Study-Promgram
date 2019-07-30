
#include <stdio.h>

int main(){
		int a=0,e=0,i=0,o=0,u=0,sum=0;
		int ch;
		printf("请输入一个英语句子:");		
		while((ch = getchar()) != '\n'){
				
				if(ch == 'A' || ch == 'a'){
								a+=1;
								sum+=1;
					}
				if(ch == 'E' || ch == 'e'){
								e+=1;
								sum+=1;
					}
				if(ch == 'I' || ch == 'i'){
								i+=1;
								sum+=1;
					}
				if(ch == 'O' || ch == 'o'){
								o+=1;
								sum+=1;
					}
				if(ch == 'U' || ch == 'u'){
								u+=1;
								sum+=1;
					}
			}
			printf("你输入的句子中，包含元音字母是%d个\n",sum);
			printf("其中：a(%d),e(%d),i(%d),o(%d),u(%d)\n",a,e,i,o,u);
			return 0;
	}
