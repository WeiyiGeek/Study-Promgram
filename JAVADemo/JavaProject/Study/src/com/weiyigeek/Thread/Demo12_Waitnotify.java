package com.weiyigeek.Thread;
public class Demo12_Waitnotify {
	public static void main(String[] args) {
		//JDK5之前无法唤醒指定的一个线程（而是随机唤醒）,多个线程之间通信需要使用notifyAll()通知所有线程,用while来反复判断条件;
		//三个线程通信实例:
		final Waitnofity wn = new Waitnofity(); //注意必须采用final修饰才能在匿名内部类中使用
		//线程1
		new Thread() {
			public void run() {
				//匿名内部类中的子类自能自己处理异常
				while(true) {
					try {
						wn.print1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//线程2
		new Thread() {
			public void run() {
				//匿名内部类中的子类自能自己处理异常
				while(true){
					try {
						wn.print2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//线程3
		new Thread() {
			public void run() {
				while(true) {
					//匿名内部类中的子类自能自己处理异常
					try {
						wn.print3();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}


//声明一个类3个方法一个属性;
class Waitnofity {
	private int flag = 1;
	public void print1() throws InterruptedException {
		//同步锁对象
		synchronized (this) {
			while(flag != 1){ //线程1在次等待,while()循环是循环判断每次都会判断标记
				this.wait();
			}
			System.out.print(Thread.currentThread().getName() + " - Print1()");
			System.out.println(" ");
			flag=2;
			this.notifyAll(); // 唤醒所有的线程(但还是随机选项线程，当满足条件就行执行)
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this) {
			//如果采用if它会在哪里等待哪里就起来
			while(flag != 2){ //线程2在次等待
				this.wait();
			}
			System.out.print(Thread.currentThread().getName() + " - Print2()");
			System.out.println(" ");
			flag=3;
			this.notifyAll(); // 唤醒所有的线程
		}
	}
	
	public void print3() throws InterruptedException {
		synchronized(this) {
			while(flag != 3){ //线程3在次等待记
				this.wait();
			}
			System.out.print(Thread.currentThread().getName() + " - Print3()");
			System.out.println(" ");
			flag=1;
			this.notifyAll(); // 唤醒所有的线程
		}
	}
}