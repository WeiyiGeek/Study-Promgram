package com.weiyigeek.Thread;

public class Demo1_Thread {

	public static void main(String[] args) {
		//示例1.证明Java的JVM是多线程执行的
		//CPU在同一时刻只会运行一个任务,但是由于执行效率太高了会出现联系执行相同的任务;\
		//线程就是一条路所有的任务将在上面执行
		for(int i = 0; i < 1000000; i++)
			new Demo();
		
		for(int i = 0; i < 1000; i++)
			System.out.println("Master Thread 执行 " + i);	
	}
}

//Demo:进行垃圾回收
class Demo {
	@Override
	protected void finalize() throws Throwable {
		System.out.println(this.getClass() + "类垃圾回收!");
	}
}

/**
 * 执行结果:
 * class com.weiyigeek.Thread.Demo类垃圾回收!
	class com.weiyigeek.Thread.Demo类垃圾回收!
	class com.weiyigeek.Thread.Demo类垃圾回收!
	Master Thread 执行 620
	class com.weiyigeek.Thread.Demo类垃圾回收!
	class com.weiyigeek.Thread.Demo类垃圾回收!
	Master Thread 执行 621
	Master Thread 执行 622
 ***/
