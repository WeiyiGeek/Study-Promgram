package com.weiyigeek.Thread;
public class Demo3_AnonmouseThread {
	public static void main(String[] args) {
		//1.采用匿名内部类直接实现，精简代码但是流程是与实现线程的两种方式大致相同;、
		//方法1：new 类(){}继承这个类
		new Thread() {
			public void run() { //重写run方法
				for (int i = 0; i < 1000; i++) { //将要执行的代码,写在run方法中
					System.out.println(this.getName() + " - Thread Anonymous Inner Class");
				}
			}
		}.start(); //注意调用start()方法开启线程
		
		//方法2：将Runable的子类对象传递给Thread的构造方法（值得注意）
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++)
					System.out.println(new Thread().getName() + " - Runnable Anonymous Inner Class");
			}
		}).start(); //同样是开启线程
	}
}
