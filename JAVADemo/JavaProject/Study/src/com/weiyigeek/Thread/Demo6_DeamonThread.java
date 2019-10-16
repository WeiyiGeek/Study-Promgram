package com.weiyigeek.Thread;

public class Demo6_DeamonThread {

	public static void main(String[] args) {
		//1.守护线程案例
		demo2();
	}

	public static void demo2() {
		Thread t1 = new Thread("Master") {
			public void run() {
				for(int i = 0; i < 2;i++)
				{
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(getName() + " - " + i); //注意这里由于采用了匿名内部类的方法可以直接调用Thread中的方法
				}
			}
		};
		
		//假设是作为守护线程查看效果;
		Thread t2 = new Thread("SetDeamon") {
			public void run() {
				for(int i = 0; i < 50;i++)
				{
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(getName() + " - " + i); //注意这里由于采用了匿名内部类的方法可以直接调用Thread中的方法
				}
			}
		};
		
		t2.setDaemon(true); //将t1设置为守护线程(当Master线程执行两次结束后setDeamon线程也跟着结束)
		t1.start();
		t2.start();
	}
}
