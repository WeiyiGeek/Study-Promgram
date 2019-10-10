package com.weiyigeek.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.TreeMap;

public class Demo13_IOtranstion {

	public static void main(String[] args) throws IOException {
		// 实例1.使用指定编码表进行读写字符
		demo1();
		// 实例2.获取一个文本上每个字符出现的次数,将结果写在times.txt上
		demo2();
	}

	public static void demo2() throws IOException {
		//1.创建带缓冲的输入流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\chinese.txt"),"UTF-8"));
		//2.常见双列集合对象TreeMap
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		//3.将读取的字符存入双列集合中(包含则+1,否则值为1存储)
		int ch;
		while((ch = br.read()) != -1) {
			char c = (char)ch; //强制类型转换
			if(!tm.containsKey(c)){
				tm.put(c, 1);  //不存在就put进双列集合
			}else {
				tm.put(c, tm.get(c) + 1); //已经存在的键就直接获取其值+1
			}
			// tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) + 1)
		}
		//4.关闭输入流
		br.close();
		//5.创建输出对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\times.txt"),"gbk"));
		//6.遍历集合将集合中的内容写到console和times.txt之中
		for(Character key : tm.keySet())
		{
			//注意需要转义进行输出
			switch (key) {
			case ' ':
				bw.write("[空格]=" + tm.get(key));
				System.out.println("[空格]=" + tm.get(key));
				break;
			case '\n':
				bw.write("\\n=" + tm.get(key));
				System.out.println("\\n=" + tm.get(key));
				break;
			case '\r':
				bw.write("\\r=" + tm.get(key));
				System.out.println("\\r=" + tm.get(key));
				break;
			default:
				bw.write(key + "=" + tm.get(key)); //写成键和值
				System.out.println(key + "=" + tm.get(key));
				break;
			}
			bw.newLine();
		}
		//7.关闭输出流
		bw.close();
	}

	public static void demo1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\chinese.txt"),"utf-8")); //高效的用指定的编码表读
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\demoo.txt"),"gbk")); //高效的用指定的编码表写
		int ch;
		while((ch = br.read()) != -1) 
			bw.write(ch);
		br.close();
		bw.close();
	}
}
