package com.weiyigeek.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo6_IOrwchinese {
	public static void main(String[] args) throws IOException {
		// 实例：IO流读取写入中文
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:\\demo.txt"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\chinese.txt"));
		
		byte[] arr = new byte[bis.available()]; //字节数组
		
		//读取
		int size = bis.read(arr);
		System.out.println("文件大小: "+ size + "B"); //实际读取的文件大小
		System.out.println(new String(arr,0,size));  //采用String类直接采用字节数组来读取中文字符
		
		//写入
		bos.write(arr);                              //write直接写入中文
		bos.write("\r\n".getBytes()); 				 //Windows下的回车换行符转换为字节数组
		bos.write("我和我的祖国一刻也不能分割!".getBytes());  //也可以直接将字符串转换成为字节数组
		
		bis.close();
		bos.close();
	}
}
