package com.weiyigeek.Thread;

public class Demo4_ThreadMethod {

	public static void main(String[] args) {
		//ʾ��1.�̵߳ĳ��õķ���(�������ȡ����)
		demo1();
		
		//ʵ��2.��ȡ��ǰ����ִ���̶߳���(����ʹ����Runable�ӿ�֮�л�ȡ��ǰ�̶߳�����������̵߳ķ�����)
		new Thread(new Runnable() {
			@Override
			public void run() {
				Thread t = Thread.currentThread();//runnable����ӿڱ����ֱ��ʹ��Thread���еķ���
				t.setName("Slave-01");  //ֱ�Ӹ���ǰ�̶߳�����������߳�����
				System.out.println(t.getName() + "#Runnable�ӿ�ʵ�ֲ���ȡ��ǰ�̶߳���-��������Thread���з���");
			}
		}).start(); //���뿪���߳� (��Ҫ ��Ҫ Important!)
	}

	public static void demo1() {
		//��ʽ1.ͨ�����췽�������߳����Ƹ�ֵ
		new Thread("Master") {
			public void run() {
				System.out.println( this.getName() + "#�߳�ִ�еĴ����!");
			}
		}.start();
		
		//��ʽ2.ͨ��this.setName���������߳�����
		new Thread() {
			public void run() {
				this.setName("Master-01");
				System.out.println( this.getName() + "#�߳�ִ�еĴ����!");
			}
		}.start();
				
		//��ʽ3:ͨ��Thread���setName�������������߳�����
		Thread th = new Thread() {
			public void run() {
				System.out.println( this.getName() + "#�߳�ִ�еĴ����!");
			}
		};
		th.setName("Slave");
		th.start();
	}

}
