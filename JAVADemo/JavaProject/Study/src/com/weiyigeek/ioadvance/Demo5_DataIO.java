package com.weiyigeek.ioadvance;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo5_DataIO {

	public static void main(String[] args) throws IOException {
		// 示例1.数据输入输出流
		// (1)常规写入FileOutputStream写出流对比操作
		FileOutputStream fos = new FileOutputStream("d:\\demo1.txt");
		/***
		 * 00000000 00000000 00000011 11100101 #int类型997
		 * 11100101 => 229 //存入的时候截取一字节的数据(当然这是我们不想看到的)
		 * **/
		fos.write(997);
		fos.write(998);  //11100110 -> 230
		fos.close();
		FileInputStream fis = new FileInputStream("d:\\demo1.txt");
		int x = fis.read();
		int y = fis.read();
		System.out.println(x + " - " + y);
		
		// (2)采用数据输入输出流便不会存在这样的情况
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:\\demo1.txt"));
		dos.writeInt(997); //存入一个int类型的数据
		dos.writeInt(998);
		dos.close();
	
		DataInputStream dis = new DataInputStream(new FileInputStream("d:\\demo1.txt"));
		System.out.println("占用字节数: "+ dis.available()+"B"); // 2个Int类型 = 8B 内存空间
		x = dis.readInt();
		y = dis.readInt();
		System.out.println(x + " - " + y);
		dis.close();
	}

}
