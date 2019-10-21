package com.weiyigeek.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo14_Executor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//(1) 线程池的使用
		ExecutorService pool =  Executors.newFixedThreadPool(2); //创建线程池对象
		//提交执行的线程(可以执行Runnable对象或者Callable对象代表的线程)
		//pool.submit(new Mrunnable()); //线程一放入池中执行
		//pool.submit(new Mrunnable()); //线程二
		//避免重复执行
		//pool.shutdown(); //关闭线程
		
		
		//(2)多线程程序实现(实现线程方法3)
		ExecutorService pool1 =  Executors.newFixedThreadPool(2); //创建线程池对象
		Future<Integer> f1 = pool1.submit(new MyCallable(100)); //将线程放入池中执行并且返回其值
		Future<Integer> f2 = pool1.submit(new MyCallable(50));
		System.out.println("前100之和:" + f1.get()); //获取其值(需要抛出异常)
		System.out.println("前50之和:" + f2.get());
		pool1.shutdown();
	}
}

//实现线程的第三种方式Callable
class MyCallable implements Callable<Integer>{
	private int num;
	//构造方法传入要求前num的之综合
	public MyCallable(int num) {
		this.num = num;
	}
	@Override
	//call方法相比于run方法可以抛出异常以及有返回值;
	public Integer call() throws Exception {
		int sum = 0;
		while(num >= 0){
			sum += num--;
		}
		return sum;
	}
}

//执行结果:
//	pool-1-thread-1....0
//	pool-1-thread-1....1
//	pool-1-thread-1....2
//	pool-1-thread-2....0
//	pool-1-thread-1....3
//	pool-1-thread-1....4
//	pool-1-thread-1....5

//前100之和:5050
//前50之和:1275