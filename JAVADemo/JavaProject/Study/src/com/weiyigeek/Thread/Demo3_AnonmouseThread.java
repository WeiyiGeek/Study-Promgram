package com.weiyigeek.Thread;
public class Demo3_AnonmouseThread {
	public static void main(String[] args) {
		//1.���������ڲ���ֱ��ʵ�֣�������뵫����������ʵ���̵߳����ַ�ʽ������ͬ;��
		//����1��new ��(){}�̳������
		new Thread() {
			public void run() { //��дrun����
				for (int i = 0; i < 1000; i++) { //��Ҫִ�еĴ���,д��run������
					System.out.println(this.getName() + " - Thread Anonymous Inner Class");
				}
			}
		}.start(); //ע�����start()���������߳�
		
		//����2����Runable��������󴫵ݸ�Thread�Ĺ��췽����ֵ��ע�⣩
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++)
					System.out.println(new Thread().getName() + " - Runnable Anonymous Inner Class");
			}
		}).start(); //ͬ���ǿ����߳�
	}
}
