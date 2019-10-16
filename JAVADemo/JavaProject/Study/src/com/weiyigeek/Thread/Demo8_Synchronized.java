package com.weiyigeek.Thread;

public class Demo8_Synchronized {

	public static void main(String[] args) {
		// 示例1.同步代码块与同步方法
		final Printer pp = new Printer();
		new Thread("Sync-0") {
			public void run() {
				while(true){
					//pp.p1();
					//pp.p3();
					pp.p4();
				}
			}
		}.start();
		
		new Thread("Sync-1") {
			public void run() {
				while(true){
					//pp.p2();
					//pp.p31();
					pp.p41();
				}
			}
		}.start();
	}
}

//测试类
class Printer {
	Syn d = new Syn();
	public void p1() {
		//锁对象可以是任意对象,但是被锁的代码需要保证是同一把锁,并且不能用匿名对象
		//注意不能采用匿名内部类synchronized(new)
		synchronized (d) {
			System.out.print("P1");
			System.out.print("Method");
			System.out.println("");
		}
	}
	public void p2() {
		synchronized (d) {
			System.out.print("P2");
			System.out.print("Method");
			System.out.println("");
		}
	}
	//同步放只需要在方法上加synchrnized关键字即可
	//非静态同步函数的锁是:this	
	public synchronized void p3() {
		System.out.print("W");
		System.out.print("e");
		System.out.print("i");
		System.out.println();
	}
	public void p31() {
		synchronized(this) {  //this 这里与出现p3()表示同一把锁所以不出现乱序;
			System.out.print("G");
			System.out.print("e");
			System.out.print("e");
			System.out.print("k");
			System.out.println();
		}
	}
	
	//静态的同步函数的锁是:字节码对象(本类) - 注意静态方法优先于对象存在;
	public static synchronized void p4() {	
		System.out.print("W");
		System.out.print("e");
		System.out.print("i");
		System.out.print("\r\n");
	}
	public static void p41() {
		synchronized (Printer.class) {  //参数是该类的字节码，与p4()表示同一把锁
		System.out.print("G");
		System.out.print("e");
		System.out.print("e");
		System.out.print("k");
		System.out.print("\r\n");
		}
		
	}
}

//新建立一个类构建同步锁（空类即可）
class Syn {
	
}

/**
#1.未加入同步锁的情况下
P1Method
P1MethodP2Method

P2Method
#2.加入synchronized()关键字便不会出现这样的问题
 
 3.
**/