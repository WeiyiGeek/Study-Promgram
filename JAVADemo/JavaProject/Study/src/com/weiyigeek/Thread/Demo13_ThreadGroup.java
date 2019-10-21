package com.weiyigeek.Thread;

public class Demo13_ThreadGroup {

	public static void main(String[] args) {
		//1.�߳����ʹ�ð���
		// �߳�Ĭ�����������main�߳���
		// ͨ������Ĳ��ԣ���Ӧ���ܹ�������Ĭ������£����е��̶߳�����ͬһ����
		System.out.println("Ĭ���߳���: "+Thread.currentThread().getThreadGroup().getName());
				
		// ����ʹ���̶߳��󣬴���Runable���������;
		Mrunnable mr = new Mrunnable();
		
		//���������߳�
		Thread t1 = new Thread(mr,"One");
		Thread t2 = new Thread(mr,"Two");
		
		ThreadGroup tg1 = t1.getThreadGroup();
		ThreadGroup tg2 = t2.getThreadGroup();
		
		System.out.println("+ Ĭ�϶������߳���:" + tg1.getName()); //����߳�������
		System.out.println("+ Ĭ�϶������߳���:" + tg2.getName());
		
		//���ô����µ��߳�������
		ThreadGroup tg = new ThreadGroup("NewThreadGroup");
		Thread t3 = new Thread(tg,mr,"Group");
		ThreadGroup tg3 =  t3.getThreadGroup(); //��ȡ���������
		System.out.println("+ ���õ��߳���:" + tg3.getName());
		
		//ͨ�����������ú�̨�̣߳���ʾ������̶߳��Ǻ�̨�߳�
		tg.setDaemon(true);
	}
}

//�̶߳����� (ctrl+1 => ������ʾ���)
class Mrunnable implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + "...." + i);
		}
	}
}
