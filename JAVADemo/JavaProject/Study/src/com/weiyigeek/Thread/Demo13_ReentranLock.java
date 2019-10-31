package com.weiyigeek.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo13_ReentranLock {
	public static void main(String[] args) {
		// (1)1.5�����Ի�����ʵ�֣�����Ҫ��ÿ���̶߳����ѣ�ֻ�ǻ���ָ���̣߳�
		final Reentran rt = new Reentran();
		new Thread() {
			@Override
			public void run() {
				//�߳�1��ִ�еĴ���
				while(true)
				{
					try {
						rt.p1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				//�߳�2��ִ�еĴ���
				while(true) {
					try {
						rt.p2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				//��3��ִ�еĴ���
				while(true){
					try {
						rt.p3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}

class Reentran {
	private ReentrantLock r = new ReentrantLock(); //����������
	//��������������
	private Condition c1 = r.newCondition(); //����Condition����
	private Condition c2 = r.newCondition(); //����Condition����
	private Condition c3 = r.newCondition(); //����Condition����
	private int flag = 1;
	public void p1() throws InterruptedException {
		r.lock();//��ȡ��->�����滻��synchronziedͬ����
		if(flag != 1)
			c1.await();  //ʹ�߳�1�ȴ�
		System.out.println("Wei");
		flag = 2;  //���֮����
		c2.signal(); //�����߳�2
		r.unlock(); //�ͷ���
		
	}
	public void p2() throws InterruptedException {
		r.lock();//��ȡ��->�����滻��synchronziedͬ����
		if(flag != 2)
			c2.await();  //ʹ�߳�2�ȴ�
		System.out.println("Geek");
		flag = 3;  //���֮����
		c3.signal(); //�����߳�3
		r.unlock(); //�ͷ���
	}
	public void p3() throws InterruptedException {
		r.lock();//��ȡ��->�����滻��synchronziedͬ����
		if(flag != 3)
			c3.await();  //ʹ�߳�3�ȴ�
		System.out.println("Hacker");
		flag = 1;  //���֮����
		c1.signal(); //�����߳�1
		r.unlock(); //�ͷ���
	}
}

/**
ִ�н��:
Wei
Geek
Hacker
Wei
Geek
Hacker
***/