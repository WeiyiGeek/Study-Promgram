#include <stdio.h>
#include <math.h>

int main(){
		
	float price,area,yir,mir;
	//price单价，area面积，yir年利率，mir月利率
	float interset,loan;
	//interset利息,loan贷款总额
	float ave_repay,down_payment;
	//ave_repay月均还款,down_payment首期付款
	float total_price,total_repay;
	//total_price房款总额,total还款总额
	int ratio,time;
	//按揭层数，按揭年数

		printf("请输入房价(元/平方)：");
	scanf("%f",&price);
		printf("请输入面积：");
	scanf("%f",&area);
		printf("请输入按揭成数：");
	scanf("%d",&ratio);
		printf("请输入按揭年数：");
	scanf("%d",&time);
		printf("请输入当前年利率：");
	scanf("%f",&yir);

	mir = yir / 100 / 12;
	//月利率 = 年利率 / 100 / 12个月 = 
	time = time * 12;
	//还款月数 = 年数 * 12个月 = 20 * 12 = 240

	total_price = price * area;  
	//房款总额（元、平方） = 单价 * 面积

	loan = total_price * ratio / 10;
	//贷款总额 = 房价总额 * 按揭层数 , 注意这里不能(ratio / 10)=0,由于ratio是整形
	
	down_payment = total_price - loan;
	//down_payment = total_price * (1 - (float)ratio / 10)  //这里将ratio变成浮点型
	//down_payment = total_price * 0.3
	//首期付款 = 房价总额 - 贷款总额

	ave_repay = loan * mir * pow(1+mir,time)/ (pow(1+mir,time) - 1);
	//月均还款 = 贷款总额 * (月利率 * (1 + 月利率)^还款月数) / ((1 + 月利率)^还款月数 - 1)

	interset = time * ave_repay - loan;
	//利息 = 还款月份 * 每月还款 - 贷款总额

	total_repay = interset + loan;
	//还款总额 = 利息 + 贷款总额

	printf("############################# 输出结果 ##########################\n");
	printf("房款总额:%.2f\n",total_price);
	printf("贷款总额:%.2f\n",loan);
	printf("首期付款:%.2f\n",down_payment);
	printf("月均还款:%.2f\n",ave_repay);
	printf("支付利息：%.2f\n",interset);
	printf("还款总额：%.2f\n",total_repay);

	return 0;
}