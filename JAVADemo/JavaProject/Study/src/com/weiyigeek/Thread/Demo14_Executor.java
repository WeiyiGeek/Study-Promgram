package com.weiyigeek.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo14_Executor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//(1) �̳߳ص�ʹ��
		ExecutorService pool =  Executors.newFixedThreadPool(2); //�����̳߳ض���
		//�ύִ�е��߳�(����ִ��Runnable�������Callable���������߳�)
		//pool.submit(new Mrunnable()); //�߳�һ�������ִ��
		//pool.submit(new Mrunnable()); //�̶߳�
		//�����ظ�ִ��
		//pool.shutdown(); //�ر��߳�
		
		
		//(2)���̳߳���ʵ��(ʵ���̷߳���3)
		ExecutorService pool1 =  Executors.newFixedThreadPool(2); //�����̳߳ض���
		Future<Integer> f1 = pool1.submit(new MyCallable(100)); //���̷߳������ִ�в��ҷ�����ֵ
		Future<Integer> f2 = pool1.submit(new MyCallable(50));
		System.out.println("ǰ100֮��:" + f1.get()); //��ȡ��ֵ(��Ҫ�׳��쳣)
		System.out.println("ǰ50֮��:" + f2.get());
		pool1.shutdown();
	}
}

//ʵ���̵߳ĵ����ַ�ʽCallable
class MyCallable implements Callable<Integer>{
	private int num;
	//���췽������Ҫ��ǰnum��֮�ۺ�
	public MyCallable(int num) {
		this.num = num;
	}
	@Override
	//call���������run���������׳��쳣�Լ��з���ֵ;
	public Integer call() throws Exception {
		int sum = 0;
		while(num >= 0){
			sum += num--;
		}
		return sum;
	}
}

//ִ�н��:
//	pool-1-thread-1....0
//	pool-1-thread-1....1
//	pool-1-thread-1....2
//	pool-1-thread-2....0
//	pool-1-thread-1....3
//	pool-1-thread-1....4
//	pool-1-thread-1....5

//ǰ100֮��:5050
//ǰ50֮��:1275