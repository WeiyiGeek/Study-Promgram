package com.weiyigeek.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo7_IOException {

	public static void main(String[] args) throws Exception {
		// 实例1：IO流的异常处理(1.6版本)
		//demo1();
		
		// 实例2：IO流的异常处理(1.7版本-自动关闭流)
		//inputStream体系实现了AutoCloseable接口是从jdk1.7版本开始的
		//坑呀注意try后面是()而不是{},而且我们重写了自动关闭流的方法
		try(
			FileInputStream fis = new FileInputStream("d:\\demo.txt");
			FileOutputStream fos = new FileOutputStream("d:\\chinese.txt");
			MyClose mc = new MyClose(fis,fos);  //重写自动关闭流的接口
		){
			int n;
			while((n = fis.read()) != -1 )
			fos.write(n);
		}
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = null; // 这里的null是非常重要的
		FileOutputStream fos = null; 
		//异常处理开始
		try {
			fis = new FileInputStream("d:\\demo.txt");
			fos = new FileOutputStream("d:\\chinese.txt");
			int b;
			while((b = fis.read()) != -1)
				fos.write(b);
	
		} finally {
			//try fianlly的嵌套目的是能关一个尽量关一个 (标准化值得学习)
			try {
				//值得学习
				if(fis != null){
	                try {
	                	fis.close();
	                } catch (IOException e) {
	                	fis = null;
	                    e.printStackTrace();
	                }
				}
			} finally {
				if(fos != null)
					fos.close();
			}
		}
	}
}

class MyClose implements AutoCloseable{
	
	private FileInputStream fis = null;
	private FileOutputStream fos = null;

	public MyClose() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyClose(FileInputStream fis,FileOutputStream fos) {
		this.fis = fis;
		this.fos = fos;
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("重写自动关闭流!采用AutoCloseable()接口");
		fis.close();
		fos.close();
	}
}
