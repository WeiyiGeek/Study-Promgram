package com.weiyigeek.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo11_IOCharCustom {
	public static void main(String[] args) throws IOException {
		// 1.自定义字符数组
		customArray();

		// 2.带缓冲的字符流
		bufferRW();
		
		// 3.字符流缓存区读取和写入一行到文件
		System.out.println("3.字符流缓存区读取和写入一行到文件");
		BufferedReader br = new BufferedReader(new FileReader("d:\\chinese.txt"));       //创建缓冲区字符输入流
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\demo.bak.txt",true)); //创建缓冲区字符输出流
		
		bw.write("----------------------------------------------------");
		bw.newLine();  //写成回车换行符
		String lines;
		int count = 1;
		while((lines = br.readLine()) != null)
		{
			lines = "\t" + count++ + "." + lines;
			System.out.println(lines);
			bw.write(lines);
			bw.newLine();			
		}

		br.close();
		bw.close();
			
	}

	public static void bufferRW() throws FileNotFoundException, IOException {
		System.out.println("2.带缓冲的字符流");
		BufferedReader br = new BufferedReader(new FileReader("d:\\chinese.txt"));       //创建缓冲区字符输入流
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\demo.bak.txt",true)); //创建缓冲区字符输出流
		int ch;	
		while((ch = br.read()) != -1) {		//read一次会先将缓冲区读满从缓冲去中一个一个的返给临时变量ch
			bw.write(ch);					//write一次是将数据装到字符数组装满后再一起写出去
		}
		br.close();
		bw.close();
	}

	public static void customArray() throws FileNotFoundException, IOException {
		System.out.println("1.自定义字符数组");
		FileReader fr = new FileReader("d:\\chinese.txt");   //创建字符输入流
		FileWriter fw = new FileWriter("d:\\demo.txt"); //创建字符输出流
		
		char[] arr = new char[1024]; //创建字符数组
		int length;
		while((length = fr.read(arr)) != -1) //将数据读到字符数组中
			fw.write(arr,0,length);
		fr.close();
		fw.close();
	}
}
