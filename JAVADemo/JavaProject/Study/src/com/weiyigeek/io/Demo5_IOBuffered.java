package com.weiyigeek.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo5_IOBuffered {
	public static void main(String[] args) throws IOException {
		//实例:BufferedInputStream 与 BufferedOutputStream
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:\\demo.txt")); //创建文件输入流对象并且创建缓冲区对FileInputStream对象装饰
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\demo.bak.txt")); //创建文件输出流对象并且创建缓冲区对FileInputStream对象装饰
	
		int b;
		while((b = bis.read()) != -1) {	 //每次读取8192字节数据进行读取到内存然后写入到磁盘中
			bos.write(b);  //从内存中读取写入到磁盘中，经过两个字节数组转换效率不如byte数组直接公用效率高省内存
		}
		//只需要关闭装饰后的对象即可原实例化对象不需要管理
		bis.close();
		bos.close();
	}
}
