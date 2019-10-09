package com.weiyigeek.io;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo1_InputStream {

	public static void main(String[] args) throws IOException {
		// 实例1.一个读程序案例InputStream
		FileInputStream fis = new FileInputStream("C:\\demo.txt"); //创建流对象并关联demo.txt
		int flag = 0;
		while((flag = fis.read()) != -1)  //从硬盘上读取一个字节结束标志为-1
		{
			System.out.print(Character.toChars(flag)); //打印每一个字符将字节编码转换成为字符
		}
		fis.close();  //必须关闭打开的磁盘文件资源
	}

}
