package com.weiyigeek.Thread;
import java.io.IOException;
public class Demo10_Runtime {
	public static void main(String[] args) throws IOException, InterruptedException{
		//单线程类学习 Runtime
		Runtime r = Runtime.getRuntime(); //注意由于Runtime类是单实例的所以用其静态公共的方法获取Runtime内部实例化对象
		//演示操作同一个对象：命令执行关机命令和取消关机
		System.out.println("正在执行关机命令!");
		r.exec("shutdown -s -t 300");  //300s 关机
		Thread.sleep(5000);  //主线程 休眠 5s
		r.exec("shutdown -a");
		System.out.println("已经取消关机!");
	}
}
