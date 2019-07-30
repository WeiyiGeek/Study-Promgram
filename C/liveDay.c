#include <stdio.h>

int main(){

	int biryears,birmonths,birdays;
	int nowyears,nowmonths,nowdays;
	int j;
	unsigned int sumday=0,sumbir=0,sumnow=0,sum80=0;
	int a[12] ={31,28,31,30,31,30,31,31,30,31,30,31};

	printf("请输入你的Birthday日期(1970-01-01):");
	scanf("%d-%d-%d",&biryears,&birmonths,&birdays);

	printf("请输入你的Current 日期(2020-01-01):");
	scanf("%d-%d-%d",&nowyears,&nowmonths,&nowdays);

	/*计算的你出生年份+1到你当前年份-1之间的天数*/
	for(j=biryears+1;j<biryears+70;j++){

		if(j == nowyears){
			sumday = sum80;
		}

		if(!(j % 400) || !(j % 4) && (j % 100 !=0)){
			sum80 += 366;
		}
		sum80 += 365;
	}

	/*计算你出生那年的天数*/
	for(;birmonths+1<13;birmonths++){

		if(birmonths<2){
			if(!(biryears % 400) || !(biryears % 4) && (biryears % 100 !=0))
			{
			   a[1] = 29;
			}

		}
		sumbir += a[birmonths-1];
	}
	sumbir += a[birmonths-1]-birdays+1;

/*计算你当前年的生活的天数*/
	for(j=0;j<nowmonths;j++)
	{
		if(!(nowyears % 400) || !(nowyears % 4) && (nowyears % 100 !=0))
		{
	  	   a[1] = 29;
		}else{
		   a[1] = 28;
		}
		if(1 == nowmonths){
			sumnow = nowdays;
			goto end;
		}
		sumnow += a[j];
	}
	sumnow += nowdays-1;
end:printf("\n******************你出生到现在生活的天数计算完毕!*********************\n");
	sumday += sumbir + sumnow;
	printf("You have lived %d days since you were born!\n\n",sumday);
	printf("如果能活到70岁,你还剩下%d天.\n\n",sum80-sumday);
	printf("If you live to be 70, your life is already up to %.2f\%% .\n",(float)sumday/(float)sum80 * 100) ;
}
