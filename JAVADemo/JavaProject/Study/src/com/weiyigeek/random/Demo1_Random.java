package com.weiyigeek.random;
import java.util.Random;
public class Demo1_Random {
	public static void main(String[] args) {
		//ʾ��1.Random���ʹ��
		//��ʽ1:α������ײ�����Ĭ�ϲ���ϵͳ��ǰʱ�������
		Random ra = new Random();
		System.out.println("α��� = " + ra.nextInt());
		System.out.println("α��� = " + ra.nextInt());

		//��ʽ2
		System.out.println("��ͬ��seed������,���ɵ��������һ�µ�:");
		Random r = new Random(1024); //����new Random(seed)��r.setSeed(seed)�ǵȼ۵ģ�
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		
		//��ʽ3
		Random r1 = new Random();
		r1.setSeed(1024);
		System.out.println(r1.nextInt());
		System.out.println(r1.nextInt());
		
		//ʾ��2.����һ����Χ�ڵ������
		Random r2 = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.print(r.nextInt(100) + " "); //����ʮ�� 0 ~ 99 �������(ע�����ﲻ��100)
		}	
	}
}
