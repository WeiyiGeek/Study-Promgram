package com.weiyigeek.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo9_IOSynthesize {
	public static void main(String[] args) throws IOException {
		/* 需求1:在控制台录入文件的路径,将文件拷贝到当前项目下
		 * 需求分析:
		 * 1,定义方法对键盘录入的路径进行判断,如果是文件就返回
		 * 2,在主方法中接收该文件
		 * 3,读和写该文件 */
		File file = getFile(); //利用File类获取文件
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName())); //获取路径中的文件名称并将数据存储再当前目录中
		
		int b;
		while((b = bis.read()) != -1)
		{
			bos.write(b);
		}
		
		bis.close();
		bos.close();
		
		/**
		 * 需求2：将键盘录入的数据拷贝追加到当前项目下的文件中(上面需求1再当前目录下建立的文件),键盘录入数据当遇到quit时就退出
		 * 分析:
		 * 1,创建键盘录入对象
		 * 2,创建输出流对象关联需求1再当前目录下建立的文件
		 * 3,定义无限循环
		 * 4,遇到quit退出循环
		 * 5,如果不quit,就将内容写出
		 * 6,关闭流
		 * @throws IOException 
		 */
		
		//1,创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		//2,创建输出流对象关联file.getName()文件(追加)
		FileOutputStream fos = new FileOutputStream(file.getName(),true);
		System.out.println("请输入数据:");
		//3,定义无限循环
		while(true) {
			String line = sc.nextLine();					//将键盘录入的数据存储在line中
			//4,遇到quit退出循环
			if("quit".equals(line)) {
				break;
			}
			//5,如果不quit,就将内容写出
			fos.write(line.getBytes());						//字符串写出必须转换成字节数组
			fos.write("\r\n".getBytes());
		}
		//6,关闭流
		fos.close();
	}

	//(1)验证并且获取控制台输入的地址
	/* 定义一个方法获取键盘录入的文件路径并封装成File对象返回
	 * 1,返回值类型File
	 * 2,参数列表无
	 * */
	public static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件路径:");
		while(true)
		{
			String line = sc.nextLine();
			File file = new File(line); //封装成File对象并对其进行判断(非常值得学习)
			if(!file.exists())
				System.out.println("文件路径" + line + ", 文件不存在!请重写输入路径:");
			else if(file.isDirectory())
				System.out.println("文件路径" + line + ", 是个文件夹!请重写输入路径:");
			else
				return file;  
		}
	}
	
	
}
