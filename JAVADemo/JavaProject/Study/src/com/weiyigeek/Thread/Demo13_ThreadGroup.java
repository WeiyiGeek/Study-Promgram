package com.weiyigeek.Thread;

public class Demo13_ThreadGroup {

	public static void main(String[] args) {
		//1.线程组的使用案例
		// 线程默认情况下属于main线程组
		// 通过下面的测试，你应该能够看到，默任情况下，所有的线程都属于同一个组
		System.out.println("默认线程组: "+Thread.currentThread().getThreadGroup().getName());
				
		// 声明使用线程对象，创建Runable的子类对象;
		Mrunnable mr = new Mrunnable();
		
		//创建两个线程
		Thread t1 = new Thread(mr,"One");
		Thread t2 = new Thread(mr,"Two");
		
		ThreadGroup tg1 = t1.getThreadGroup();
		ThreadGroup tg2 = t2.getThreadGroup();
		
		System.out.println("+ 默认都是主线程组:" + tg1.getName()); //输出线程组名称
		System.out.println("+ 默认都是主线程组:" + tg2.getName());
		
		//设置创建新的线程组名称
		ThreadGroup tg = new ThreadGroup("NewThreadGroup");
		Thread t3 = new Thread(tg,mr,"Group");
		ThreadGroup tg3 =  t3.getThreadGroup(); //获取进程组对象
		System.out.println("+ 设置的线程组:" + tg3.getName());
		
		//通过组名称设置后台线程，表示该组的线程都是后台线程
		tg.setDaemon(true);
	}
}

//线程对象类 (ctrl+1 => 错误提示添加)
class Mrunnable implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + "...." + i);
		}
	}
}
