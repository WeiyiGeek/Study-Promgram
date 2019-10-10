package com.weiyigeek.file;

import java.io.File;
import java.util.Scanner;

public class Demo3_FileRecursion {
	public static void main(String[] args) {
		// 需求1.从键盘接收一个文件夹路径打印出该文件下的所有的java文件名;
		File path = getFile();
		printTxt(path);
		
		
	}
	//终端输入路径并进验证
	public static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径:");
		while(true){
			String path = sc.nextLine();
			File dir = new File(path);
			if(!dir.exists()) {
				System.out.println("录入的文件夹路径不存在,请重新输入");
			}else if(dir.isFile()) {
				System.out.println("您录的是一个文件,请重新输入一个文件夹路径");
			}else {
				return dir;
			}
		}
	}

	//递归函数
	//获取文件夹路径下的所有的文件
	public static void printTxt(File dir)
	{
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			if(file.isFile() && file.getName().endsWith(".txt")){
				System.out.println(file);
			}else if(file.isDirectory()){
				if(!file.getPath().endsWith(".")) {
					printTxt(file);
				}
			}
		}
	}
}
