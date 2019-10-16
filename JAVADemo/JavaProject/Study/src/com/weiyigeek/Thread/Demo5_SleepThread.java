package com.weiyigeek.Thread;

public class Demo5_SleepThread {

	public static void main(String[] args) throws InterruptedException {
		// 实例1.休眠线程 Thread.sleep(毫秒,纳秒)
		// (1)这里主要以main主线程进行测试
		for(int i = 10; i > 0; i--)
		{
			Thread.sleep(1000); //线程休眠中断1s,需要加入一个中断异常处理
			System.out.println("倒计时"+i+"s");
		}
		
		// (2)采用Thread创建两个线程进行体现进程休眠
		demo1();
	}

	//实例1：构建方法
	public static void demo1() {
		new Thread("Thread1") {
			public void run() {
				for(int i = 0; i < 10; i++)
				{
					//这里不是抛异常，由于父类在写run方法的时候没有抛异常，所有子类重写也不能抛(自能自己进行处理try...catch)
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					System.out.println(this.getName() + " - " + i);  //输出线程名称查看执行效果
				}
			}
		}.start();
		
		new Thread("Thread2" ) {
			public void run() {
				for(int i = 0; i < 10; i++)
				{
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(this.getName() + " - " + i);
				}
			}
		}.start();
	}
}
