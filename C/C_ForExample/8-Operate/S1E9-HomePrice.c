#include <stdio.h>
#include <math.h>

int main(){
		
	float price,area,yir,mir;
	//price���ۣ�area�����yir�����ʣ�mir������
	float interset,loan;
	//interset��Ϣ,loan�����ܶ�
	float ave_repay,down_payment;
	//ave_repay�¾�����,down_payment���ڸ���
	float total_price,total_repay;
	//total_price�����ܶ�,total�����ܶ�
	int ratio,time;
	//���Ҳ�������������

		printf("�����뷿��(Ԫ/ƽ��)��");
	scanf("%f",&price);
		printf("�����������");
	scanf("%f",&area);
		printf("�����밴�ҳ�����");
	scanf("%d",&ratio);
		printf("�����밴��������");
	scanf("%d",&time);
		printf("�����뵱ǰ�����ʣ�");
	scanf("%f",&yir);

	mir = yir / 100 / 12;
	//������ = ������ / 100 / 12���� = 
	time = time * 12;
	//�������� = ���� * 12���� = 20 * 12 = 240

	total_price = price * area;  
	//�����ܶԪ��ƽ���� = ���� * ���

	loan = total_price * ratio / 10;
	//�����ܶ� = �����ܶ� * ���Ҳ��� , ע�����ﲻ��(ratio / 10)=0,����ratio������
	
	down_payment = total_price - loan;
	//down_payment = total_price * (1 - (float)ratio / 10)  //���ｫratio��ɸ�����
	//down_payment = total_price * 0.3
	//���ڸ��� = �����ܶ� - �����ܶ�

	ave_repay = loan * mir * pow(1+mir,time)/ (pow(1+mir,time) - 1);
	//�¾����� = �����ܶ� * (������ * (1 + ������)^��������) / ((1 + ������)^�������� - 1)

	interset = time * ave_repay - loan;
	//��Ϣ = �����·� * ÿ�»��� - �����ܶ�

	total_repay = interset + loan;
	//�����ܶ� = ��Ϣ + �����ܶ�

	printf("############################# ������ ##########################\n");
	printf("�����ܶ�:%.2f\n",total_price);
	printf("�����ܶ�:%.2f\n",loan);
	printf("���ڸ���:%.2f\n",down_payment);
	printf("�¾�����:%.2f\n",ave_repay);
	printf("֧����Ϣ��%.2f\n",interset);
	printf("�����ܶ%.2f\n",total_repay);

	return 0;
}