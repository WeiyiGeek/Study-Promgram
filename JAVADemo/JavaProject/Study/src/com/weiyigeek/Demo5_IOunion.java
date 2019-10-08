package com.weiyigeek;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo5_IOunion {
	public static void main(String[] args) throws IOException {
		//示例1.IO流程核心拷贝图片字节流(输入流、输出流)-方式1
		try {
			FileInputStream fis = new FileInputStream("F:\\IMG_2330.PNG"); //创建输入流
			FileOutputStream fos = new FileOutputStream("F:\\IMG_2330.bak.png"); //创建输出流
			int flag;
			while((flag = fis.read()) != -1) //相当于是copy的效果
			{
				fos.write(flag);
			}
			System.out.print("示例1.输入流与输出流联合使用进行Copy图片的效果;");
			fis.close(); //关闭输入流打开的文件释放资源
			fos.close(); //关闭输出流打开的文件释放资源
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//示例2.IO拷贝音视频资源字节流(一次性-1B-8bit)-方式2(但是此种方式容易导致内存溢出)
		try {
			FileInputStream fis = new FileInputStream("F:\\IMG_2330.PNG"); //创建输入流
			FileOutputStream fos = new FileOutputStream("F:\\IMG_2330.bak1.png"); //创建输出流
			byte[] count = new byte[fis.available()]; //存入可用字节数到数组之中(创建和文件相同大小的字节数组)
			System.out.println("图片大小: "+fis.available()+" Byte");
			fis.read(count); //将文件上的Byte类型数组数据字节读取到内存中(读到 b.length从输入流到字节数组数据字节。 )
			fos.write(count); //将字节数组中的字节数据写到文件上
		} catch (Exception e) {
			System.out.println();
		}finally {
			System.out.println("示例2.一次性读取文件大的字节数到内存中,然后再内存中的字节数据写入到磁盘文件中");
		}
	}
}
