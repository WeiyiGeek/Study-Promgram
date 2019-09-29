package com.weiyigeek.file;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Demo1_FileConstruction {
	public static void main(String[] args) throws IOException {  //抛出IO异常模块(需要注意)
		//#示例1:File类的构造方法使用方法 ##########################################
		File f1 = new File("E:\\githubProject\\Study-Promgram\\update.sh");
		System.out.println("方式1：判断update.sh是否存在 : " + f1.exists());
		//----------------------
		String parent = "E:\\githubProject\\Study-Promgram";
		String child = "update.sh";
		File f2 = new File(parent,child);
		System.out.println("方式2：" + f2.exists());
		//----------------------		
		File file = new File("E:\\githubProject\\Study-Promgram"); //为什么要采用这种方式呢,后面自自然有说明;
		String filename = "update.sh";
		File f3 = new File(file,filename);
		System.out.println("方式3：" + file.exists() + " - " + f3.exists());
		
		
		//#示例2:File类中常用方法 ########################################################
		// createNewFile 创建文件
		File f4 = new File("E:\\","FileClass.txt");
		boolean flag = f4.createNewFile();
		String res = flag ? "文件创建成功" : "文件已经创建";
		System.out.println(res);
		//----------------------
		// mkdir 创建单个文件夹
		File d1 = new File("E:\\CreateDirector");
		System.out.println("创建单个文件 ：" + d1.mkdir());
		//----------------------
		// mkdirs 创建多级文件类似Linux中 md -p /tmp/create/www
		File d2 = new File("E:\\CreateDirector\\Web\\WWW");
		System.out.println("创建单个文件 ：" + d2.mkdirs());
		
		
		//#示例3:File类中重命名和删除功能 ########################################################
		// renameTo 改名
		File f5 = new File("E:\\FileClass.txt");
		File f6 = new File("E:\\CreateDirector\\Web\\WWW\\FileClassRename.txt");
		//System.out.println("文件更改名称 : " + f5.renameTo(f6));  //剪切到f6的指定路径
		
		// delete 删除 (注意只能删除文件夹下面为空的文件夹)
		System.out.println("文件删除：" + f6.delete());
		System.out.println("文件夹删除：" + d1.delete());
		
		//#示例4:File类中判断功能 ########################################################
		System.out.println("是否是文件: " + f5.isFile());
		System.out.println("是否是文件夹: " + d2.isDirectory());
		
		//#示例4:File类中获取功能 ########################################################
		System.out.println("绝对路径：" + f2.getAbsolutePath());
		System.out.println("Filel类实例化传入路径 : " + f2.getPath());
		System.out.println("文件名称: " + f2.getName());
		System.out.println("文件大写: " + f2.length()); 
		Date d = new Date(f5.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(d));
		//重点(目录中的)
		File f7 = new File("F:/day19_video");
		String[] arr = f7.list();
		for (String s : arr) {
			System.out.println(s); //文件名称/目录名称
		}
		File[] filearr = f7.listFiles();
		for (File sf : filearr) {
			System.out.println(sf); //绝对路径目录并且带文件路径
		}
	}
}
