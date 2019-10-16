package com.weiyigeek.Thread;

public class Demo9_SyncTest {

	public static void main(String[] args) {
		//ʾ��1.����Threadʵ�ֻ�վ��Ʊ(һ��30�ţ�4������ͬʱ��)�����߳�;
//		new Tickets().start(); //ע��ÿһ���������Լ��ĳ�Ա���������ǿ��Բ���static�������Ա������������ͬ��������������ֹ�̴߳�����
//		new Tickets().start();
//		new Tickets().start();
//		new Tickets().start();

		//ʾ��2.ֻ������һ�ζ�������run�в���synchronizedͬ�������Ҵ���thisָ�����ǵ���һ��Thread����
		NewTickets nr = new NewTickets(); 
		new Thread(nr).start();
		new Thread(nr).start();
		new Thread(nr).start();
		new Thread(nr).start();
	}
}

//��վ����Ʊ��
class Tickets extends Thread{
	private static int ticket = 30; //���ĸ�����Աһ��������ʮ��Ʊ,Ϊ�����̲߳���ͬһ�����ݲ������������ͬ�������
	private static Object obj = new Object(); //����һ����̬��Obj�������Ϊͬ����;(����������������ͳ�Ա��������������������Ǿ�̬��)
	public void run() {
			//��Ʊû������һֱ������Ʊ״̬
			while(true)
			{
				//ͬ����(Ϊ�˹�ͬ����30ͬһ��synchronized(obj),���������������ķ�ʽ
				synchronized (Tickets.class) {
					if(ticket <= 0)
						break;
					try {
						Thread.sleep(10);  //�߳�1˯,�߳�2˯,�߳�3˯,�߳�4˯(��������߳�)
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println( getName()+ " | ������"  + ticket-- + "��Ʊ");
				}
			}
	}
}

//����runnable�ӿ�ʵ��������Ʊ
class NewTickets implements Runnable{
	private static int ticket = 30;
	private static Object obj = new Object(); //������:�ǳ�ע���Ǿ�̬��Ӵ!
	@Override
	public void run() {
		while(true)
		{
			//ͬ��������ֹ�̲߳���ͬһ������ʱ�����; ������Ҳ������NewTickets.class
			synchronized (obj) {
				if(ticket <= 0)
					break;
				
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				//ע��������Thread����ӿ�ʵ�ֲ���ֱ�ӵ������ڲ���������Ҫ�Ȼ�ȡ��ǰִ���߳�.Thread�෽��
				System.out.println( Thread.currentThread().getName()+ " | ������"  + ticket-- + "��Ʊ");
			}
		}
	}
}
