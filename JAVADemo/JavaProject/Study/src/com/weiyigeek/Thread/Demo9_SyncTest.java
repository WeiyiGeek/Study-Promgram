package com.weiyigeek.Thread;

public class Demo9_SyncTest {

	public static void main(String[] args) {
		//示例1.利用Thread实现火车站购票(一共30张，4个窗口同时卖)四条线程;
//		new Tickets().start(); //注意每一个对象都有自己的成员变量，我们可以采用static来共享成员变量并且利用同步锁对象来进防止线程错误发生
//		new Tickets().start();
//		new Tickets().start();
//		new Tickets().start();

		//示例2.只创建了一次对象所以run中采用synchronized同步锁并且传入this指向我们的那一个Thread对象
		NewTickets nr = new NewTickets(); 
		new Thread(nr).start();
		new Thread(nr).start();
		new Thread(nr).start();
		new Thread(nr).start();
	}
}

//车站售卖票类
class Tickets extends Thread{
	private static int ticket = 30; //让四个售卖员一起买这三十张票,为了让线程操作同一个数据不发生错误采用同步代码块
	private static Object obj = new Object(); //创建一个静态的Obj对象可作为同步锁;(如果用引用数据类型成员变量当做锁对象则必须是静态的)
	public void run() {
			//当票没有买完一直进行售票状态
			while(true)
			{
				//同步锁(为了共同操作30同一个synchronized(obj),不过建议采用下面的方式
				synchronized (Tickets.class) {
					if(ticket <= 0)
						break;
					try {
						Thread.sleep(10);  //线程1睡,线程2睡,线程3睡,线程4睡(随机唤醒线程)
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println( getName()+ " | 卖出第"  + ticket-- + "张票");
				}
			}
	}
}

//采用runnable接口实现售卖车票
class NewTickets implements Runnable{
	private static int ticket = 30;
	private static Object obj = new Object(); //锁对象:非常注意是静态的哟!
	@Override
	public void run() {
		while(true)
		{
			//同步锁，防止线程操作同一个变量时候出错; 锁对象也可以是NewTickets.class
			synchronized (obj) {
				if(ticket <= 0)
					break;
				
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				//注意这里是Thread子类接口实现不能直接调用其内部方法，需要先获取当前执行线程.Thread类方法
				System.out.println( Thread.currentThread().getName()+ " | 卖出第"  + ticket-- + "张票");
			}
		}
	}
}
