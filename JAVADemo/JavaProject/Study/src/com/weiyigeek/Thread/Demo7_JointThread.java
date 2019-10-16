package com.weiyigeek.Thread;

public class Demo7_JointThread {

	public static void main(String[] args) {
		//示例1.线程加入
		demo1();
		
		//示例2.yield让出cpu礼让线程
		MyThread mt1 = new MyThread("MasterYield");
		MyThread mt2 = new MyThread("SlaveYield");
//		mt1.start();
//		mt2.start();
	}
	
	//(1)
	public static void demo1() {
		final Thread th1 = new Thread("Slave-Join") { //由于需要被匿名内部类调用所以这里采用final进行修饰
			public void run() {
				for(int i = 0; i < 20; i++)
				{
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(getName() + " - " + i);  //需要加入的线程执行输出的语句
				}
			}
		};
		Thread th2 = new Thread("Master") { 
			public void run() {
				for(int i = 0; i < 20; i++)
				{
					try {
						//th1.join();						   //插队,加入(执行完成后才执行Master线程)
						th1.join(30);						//加入,有固定的时间过了固定时间继续交替执行
						Thread.sleep(20);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(getName() + " - " + i);
				}
			}
		};
		th1.setPriority(Thread.MIN_PRIORITY);
		th2.setPriority(Thread.MAX_PRIORITY); //优先执行Master线程
		th1.start();
		th2.start();
	}
}

//(2)
class MyThread extends Thread{

	public MyThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i <= 30; i++)
		{
			if(i%2 == 0)  //当可以整除2时候进行让出CPU让其他线程执行
			{
				Thread.yield(); //让出CPU这里就不采用Thread.sleep() 方式
			}
			System.out.println(getName() + " - " + i);
		}
	}
}


/**
*示例1(按照加入的线程时间进行执行)
Slave-Join - 0
Slave-Join - 1
Master - 0
Slave-Join - 2
Slave-Join - 3
Master - 1
Slave-Join - 4
Slave-Join - 5
Slave-Join - 6

 *示例2(实际上yield效果还是比较明显的)
SlaveYield - 0
MasterYield - 0
SlaveYield - 1
MasterYield - 1
SlaveYield - 2
MasterYield - 2
SlaveYield - 3
MasterYield - 3
SlaveYield - 4
SlaveYield - 5
MasterYield - 4
MasterYield - 5
 
 **/
