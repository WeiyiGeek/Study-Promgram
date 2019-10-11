package com.weiyigeek.ioadvance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Demo1_SequenceInputStream {

	public static void main(String[] args) throws IOException {
		//示例1.将两个输入流整合成一个输入流并输出
		demo1();
		
		//示例2.将多个输入流整合成为一个输入流并输出采用Vector进行实现
		FileInputStream fis1 = new FileInputStream("d:\\chinese.txt");//创建输入流对象
		FileInputStream fis2 = new FileInputStream("d:\\demo.txt"); //创建输入流对象
		FileInputStream fis3 = new FileInputStream("d:\\times.txt"); //创建输入流对象
		
		Vector<FileInputStream> v = new Vector<FileInputStream>(); //创建集合对象（关键点）
		v.add(fis1);  //将流对象存储进来
		v.add(fis2);
		v.add(fis3);
		Enumeration<FileInputStream> en = v.elements(); //枚举存在流对象元素
		SequenceInputStream sis = new SequenceInputStream(en); //将枚举中输入流整合成一个
		FileOutputStream fos = new FileOutputStream("d:\\Enumeration.txt");
		int b;
		while((b = sis.read()) != -1)
			fos.write(b);
		sis.close();
		fos.close();
	
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis1 = new FileInputStream("d:\\chinese.txt");//创建输入流对象
		FileInputStream fis2 = new FileInputStream("d:\\demo.txt"); //创建输入流对象
		SequenceInputStream sis = new SequenceInputStream(fis1,fis2); //整合fis1/fis2两个输入流整合成一个流
		FileOutputStream fos = new FileOutputStream("d:\\times.txt");  //创建输出流对象
		byte[] arr = new byte[sis.available()];
		int ch;
		while((ch = sis.read(arr)) != -1){
			fos.write(arr,0,ch);
			fos.write("\r\n".getBytes());
		}
		sis.close();
		fos.close();
	}
}
