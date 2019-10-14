package com.weiyigeek.Thread;
public class Demo2_ThreadClass {
	public static void main(String[] args) {
		//ʾ��1.���̳߳���ʵ�ֵķ�ʽ1
		/**
		* 1)��������̳�Thread��
		* 2)��дrun����
		* 3)�����߳�Ҫ������д��run������
		* 4)�����̶߳���
		* 5)����start()���߳��ڲ����Զ�ִ��run����
		*/
		NewThread mt = new NewThread();
		mt.start();  //����start�����������߳�;
		//�ȶԶ��߳�ִ�У����������߳�����д��һ��ѭ��
		for (int i = 0; i < 1000; i++)
			System.out.println(new Thread().getName() + " - MasterThread");  //����ֱ�ӻ�ȡ�̵߳�����
		
		
		//ʾ��2.���̳߳���ʵ�ֵķ�ʽ2:ʵ��Runnable�ӿ�
		/* 1)������ʵ��Runnable�ӿ�
		* 2)ʵ��run����
		* 3)�����߳�Ҫ������д��run������
		* 4)�����Զ����Runnable���������
		* 5)����Thread����, ����Runnable����
		* 6)����start()�������߳�, �ڲ����Զ�����Runnable��run()����
		* */
		NewRunnable nr = new NewRunnable(); //�����Զ��������
		Thread t = new Thread(nr); //ע�����ﴫ��Thread������Runnable���󣨽��䵱���������ݸ�Thread�Ĺ��캯����
		t.start();  //�Զ����÷����е�run���� 
		for (int i = 0; i < 1000; i++) 
			System.out.println(new Thread().getName() + " - MasterThread-NewRunnable");  //����ֱ�ӻ�ȡ�̵߳�����
	
	}
}

// (1)�̳�Thread��

class NewThread extends Thread {
	//2.��дRun��������Ҫִ�еĴ������run����֮��
	public void run() {
		for (int i = 0; i < 1000; i++)
			System.out.println(this.getName() + " - " + this.getClass());
	}
}


//(2)ʵ��Runnable�ӿ�
class NewRunnable implements Runnable {
	//ʵ�ֽӿ��з���
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) 
			System.out.println(i + "-" + this.getClass());
	}
}

/**
 *  #ʾ��1ִ�н��(��ѡ�˱Ƚ��ȳƵĵط�)
 *  Thread-0 - class com.weiyigeek.Thread.NewThread
	Thread-232 - MasterThread
	Thread-0 - class com.weiyigeek.Thread.NewThread
	Thread-233 - MasterThread
	Thread-0 - class com.weiyigeek.Thread.NewThread
	Thread-234 - MasterThread

	#ʾ��2ִ�н��(��ѡ�˱Ƚ��ȳƵĵط�)
	833-class com.weiyigeek.Thread.NewRunnable
	Thread-1524 - MasterThread-NewRunnable
	.....................
	Thread-1968 - MasterThread-NewRunnable
	834-class com.weiyigeek.Thread.NewRunnable
 ***/
