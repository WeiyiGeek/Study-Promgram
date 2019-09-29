package com.weiyigeek.file;

import java.io.File;
import java.io.FilenameFilter;

public class Demo2_filter {

	public static void main(String[] args) {
		//示例1.文件过滤查找实例(条件判断)
		File f1 = new File("F:/day19_video");
		File[] subFiles = f1.listFiles();
		for (File file : subFiles) {
			if(file.isFile() && file.getName().endsWith(".avi"))
			{
				//输出后缀为.avi的文件
				System.out.println(file);
			}
		}
	
		
		//实例2.过滤器的使用;需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有就输出该文件名称
		String[] arr = f1.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				File file = new File(dir, name);
				return file.isFile() && file.getName().endsWith(".avi");
			}
		});
		
		for (String str : arr) {
			System.out.println("满足条件的 ：" + str);
		}
	}
}
