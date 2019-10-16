package com.weiyigeek.Thread;

public class Demo4_ThreadMethod {

	public static void main(String[] args) {
		//示例1.线程的常用的方法(设置与获取名字)
		demo1();
		
		//实例2.获取当前正在执行线程对象(可以使用在Runable接口之中获取当前线程对象就能利用线程的方法了)
		new Thread(new Runnable() {
			@Override
			public void run() {
				Thread t = Thread.currentThread();//runnable子类接口便可以直接使用Thread类中的方法
				t.setName("Slave-01");  //直接给当前线程对象进行设置线程名称
				System.out.println(t.getName() + "#Runnable接口实现并获取当前线程对象-并调用其Thread类中方法");
			}
		}).start(); //必须开启线程 (重要 重要 Important!)
	}

	public static void demo1() {
		//方式1.通过构造方法进行线程名称赋值
		new Thread("Master") {
			public void run() {
				System.out.println( this.getName() + "#线程执行的代码块!");
			}
		}.start();
		
		//方式2.通过this.setName进行设置线程名称
		new Thread() {
			public void run() {
				this.setName("Master-01");
				System.out.println( this.getName() + "#线程执行的代码块!");
			}
		}.start();
				
		//方式3:通过Thread类的setName方法进行设置线程名称
		Thread th = new Thread() {
			public void run() {
				System.out.println( this.getName() + "#线程执行的代码块!");
			}
		};
		th.setName("Slave");
		th.start();
	}

}
