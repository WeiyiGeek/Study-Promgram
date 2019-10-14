package com.weiyigeek.Thread;
public class Demo2_ThreadClass {
	public static void main(String[] args) {
		//示例1.多线程程序实现的方式1
		/**
		* 1)定义新类继承Thread类
		* 2)重写run方法
		* 3)把新线程要做的事写在run方法中
		* 4)创建线程对象
		* 5)开启start()新线程内部会自动执行run方法
		*/
		NewThread mt = new NewThread();
		mt.start();  //调用start方法开启多线程;
		//比对多线程执行，我们在主线程里面写入一个循环
		for (int i = 0; i < 1000; i++)
			System.out.println(new Thread().getName() + " - MasterThread");  //可以直接获取线程的名称
		
		
		//示例2.多线程程序实现的方式2:实现Runnable接口
		/* 1)定义类实现Runnable接口
		* 2)实现run方法
		* 3)把新线程要做的事写在run方法中
		* 4)创建自定义的Runnable的子类对象
		* 5)创建Thread对象, 传入Runnable对象
		* 6)调用start()开启新线程, 内部会自动调用Runnable的run()方法
		* */
		NewRunnable nr = new NewRunnable(); //创建自定义类对象
		Thread t = new Thread(nr); //注意这里传入Thread的子类Runnable对象（将其当作参数传递给Thread的构造函数）
		t.start();  //自动调用方法中的run方法 
		for (int i = 0; i < 1000; i++) 
			System.out.println(new Thread().getName() + " - MasterThread-NewRunnable");  //可以直接获取线程的名称
	
	}
}

// (1)继承Thread类

class NewThread extends Thread {
	//2.重写Run方法：将要执行的代码放入run方法之中
	public void run() {
		for (int i = 0; i < 1000; i++)
			System.out.println(this.getName() + " - " + this.getClass());
	}
}


//(2)实现Runnable接口
class NewRunnable implements Runnable {
	//实现接口中方法
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) 
			System.out.println(i + "-" + this.getClass());
	}
}

/**
 *  #示例1执行结果(节选了比较匀称的地方)
 *  Thread-0 - class com.weiyigeek.Thread.NewThread
	Thread-232 - MasterThread
	Thread-0 - class com.weiyigeek.Thread.NewThread
	Thread-233 - MasterThread
	Thread-0 - class com.weiyigeek.Thread.NewThread
	Thread-234 - MasterThread

	#示例2执行结果(节选了比较匀称的地方)
	833-class com.weiyigeek.Thread.NewRunnable
	Thread-1524 - MasterThread-NewRunnable
	.....................
	Thread-1968 - MasterThread-NewRunnable
	834-class com.weiyigeek.Thread.NewRunnable
 ***/
