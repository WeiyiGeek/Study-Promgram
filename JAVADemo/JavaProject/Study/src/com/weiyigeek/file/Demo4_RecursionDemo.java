package com.weiyigeek.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo4_RecursionDemo {

	public static void main(String[] args) throws Exception {
		// 实例1.通过从键盘录入一个路径然后统计该路径下所有文件大小
		// 从键盘接收一个文件夹(注意直接获取文件夹size是0)
		//File dir = getPath();
		// 统计好文件夹大小
		//System.out.println(dir.getPath() +" 路径下的所有文件大小: " + (getFileSize(dir) / 1024.0 / 1024.0) + "MB" );
	
		//实例2.从键盘接收一个文件夹路径删除该文件夹
		//delFile(dir);
		//System.out.println("文件夹删除完毕!");
		
		//实例3.键盘接收两个文件夹路径拷贝到宁一个文件夹中;
//		File src = getPath();  
//		File dest = getPath();  //实现建立一个已存在的新目标文件夹
//		//防止空文件夹循环执行建立,不会进行循环遍历建立
//		if(src.equals(dest)){
//			System.out.println("目标与源对象是同一个文件目录!(不能进行拷贝)"); //目标文件夹是源文件夹的子文件夹
//		}else {
//			copyFile(src, dest);
//		}
//		
		
		//实例4.键盘接收一个文件夹路径把文件中所有文件以及文件名称按照层级打印
		File dir = getPath();
		printfFile(dir,0);
		
	}
	/**
	 * getPath() 
	 * 功能:获取键盘输入得路径并进行一系列判断并且返回File类型得文件夹路径对象
	 * @return:File
	 * */
	public static File getPath() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要统计/删除/拷贝文件夹得路径:");
		while(true)
		{
			String lines = sc.nextLine();
			File path = new File(lines);
			if(!path.exists())
			{
				System.out.println("录入得文件夹路径不存在,请重新输入");
			}else if(path.isFile()){
				System.out.println("您录入得是一个文件不是文件夹,请重新输入:");
			}else {
				return path;
			}
		}
	}
	
	/***
	 * getFileSize : 统计该文件夹大小;
	 * @param dir
	 * @return
	 */
	public static long getFileSize(File dir) {
		//定义求和变量
		long len = 0;
		//获取该文件夹下得所有文件路径
		File[] file = dir.listFiles();
		//遍历数组
		for (File subFile : file) {
			if(subFile.isFile()){
				len += subFile.length(); //如果是文件获取其size然后进行累加
			}else {
				len += getFileSize(subFile); //如果是文件就采用递归进行调用
			}
		}
		return len;
	}

	/***
	 * delFile: 获取并删除该文件夹下的所有文件和文件夹
	 * Description：删除不走回车站
	 * @param dir
	 */
	public static void delFile(File dir){
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			if(file.isFile()){
				file.delete();  //删除文件
			}else {
				delFile(file);  //递归调用文件夹进行删除
			}
		}
		dir.delete(); // 遍历删除后直接删除空文件夹
	}
	
	/**
	 * copyFile() : 把其中一个文件夹中(包含内容)拷贝到另外一个文件夹中
	 * @param File,File
	 * @throws IOException 
	 * @Return void
	 */
	public static void copyFile(File src, File dest) throws IOException{
		//在目标文件夹中创建原文件夹
		File newDir = new File(dest, src.getName());
		System.out.println(src.getName());
		newDir.mkdir();
		//获取原文件中所有的文件和文件夹存储在File数组中
		File[] subFiles = src.listFiles();
		//遍历数组
		for (File file : subFiles) {
			if(file.isFile())
			{
				//后面会介绍到IO流(不急),这里采用字节流
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));  //创建输入流
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir,file.getName()))); //新的路径+文件名称
				int ch;
				while((ch = bis.read()) != -1)
					bos.write(ch);
				
				bis.close();
				bos.close();
			}else {
				//递归调用处理文件夹
				copyFile(file, newDir); //精华之所在在新建立路径建立文件夹
			}
		}
	}
	
	/**
	 * printfFile : 层级打印文件夹下的文件(非常值得学习)
	 * @return void
	 */
	public static void printfFile(File dir,int flag){
		File[] subFiles = dir.listFiles();
		for (File subFile: subFiles) {
			for(int i = 0; i <= flag; i++){ //精华之处当前层级处理完原来层级目录下的flag是不改变的
				System.out.print("> ");  
			}
			System.out.println(subFile.getName());
			if(subFile.isDirectory())
			{
				printfFile(subFile,flag+1);  //注意++flag/flag++都会出现层级不一致的问题（会导致原有的flag值覆盖，zhi）
			}
		}
	}
}
