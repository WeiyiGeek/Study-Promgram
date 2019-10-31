package com.weiyigeek.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo13_ReentranLock {
	public static void main(String[] args) {
		// (1)1.5新特性互斥锁实现：不需要将每个线程都唤醒，只是唤醒指定线程；
		final Reentran rt = new Reentran();
		new Thread() {
			@Override
			public void run() {
				//线程1中执行的代码
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
				//线程2中执行的代码
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
				//线3中执行的代码
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
	private ReentrantLock r = new ReentrantLock(); //互斥锁对象
	//创建三个监听器
	private Condition c1 = r.newCondition(); //返回Condition对象
	private Condition c2 = r.newCondition(); //返回Condition对象
	private Condition c3 = r.newCondition(); //返回Condition对象
	private int flag = 1;
	public void p1() throws InterruptedException {
		r.lock();//获取锁->这里替换了synchronzied同步锁
		if(flag != 1)
			c1.await();  //使线程1等待
		System.out.println("Wei");
		flag = 2;  //灵魂之所在
		c2.signal(); //唤醒线程2
		r.unlock(); //释放锁
		
	}
	public void p2() throws InterruptedException {
		r.lock();//获取锁->这里替换了synchronzied同步锁
		if(flag != 2)
			c2.await();  //使线程2等待
		System.out.println("Geek");
		flag = 3;  //灵魂之所在
		c3.signal(); //唤醒线程3
		r.unlock(); //释放锁
	}
	public void p3() throws InterruptedException {
		r.lock();//获取锁->这里替换了synchronzied同步锁
		if(flag != 3)
			c3.await();  //使线程3等待
		System.out.println("Hacker");
		flag = 1;  //灵魂之所在
		c1.signal(); //唤醒线程1
		r.unlock(); //释放锁
	}
}

/**
执行结果:
Wei
Geek
Hacker
Wei
Geek
Hacker
***/