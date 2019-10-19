package com.weiyigeek.Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo_TimerTask {
	public static void main(String[] args) throws InterruptedException {
		//定时器timer的实现演示
		Timer t = new Timer(); //定时器对象
		t.schedule(new NewTask(), new Date(2019-1900,9,19,11,21,30),3000); //定时器任务 参数一传入TimerTask对象 3s重复一次
		while(true){
			Thread.sleep(1000);  //f2-添加一次中断
			System.out.println(new Date());
		}
	}
}

//新建立一个类继承timer的子类来自定要指定的任务(实际上继承了Runnable实现多线程)
class NewTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("正在执行任务!");
	}
}
