package com.weiyigeek.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Demo12_IOchardemo {
	public static void main(String[] args) throws IOException {
		//需求1:将一个文本文档上的文本反转第一行和倒数第一行交换,第二行和倒数第二行交换
		reserse();
		//需求2:BufferedReader子类LineNumberReader行号设置和获取
		lnr();
	}


	public static void reserse() throws IOException {
		//注意事项(值得学习：流对象应该晚开早关)
		//1.创建输入流对象(关键点)
		BufferedReader br = new BufferedReader(new FileReader("d:\\chinese.txt"));
		//2.创建带有索引的List集合Collection
		ArrayList<String> al = new ArrayList<>();
		//3.读取字符流对象打开的文件的每一行转储到集合中
		String lines;
		while((lines = br.readLine()) != null)
			al.add(lines);
		//4.关闭字符输入流(关键点)
		br.close();
		//5.创建输出流对象(关键点)
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\reverse.txt"));
		//6.倒着遍历集合上的数据并且写入到文件之中;
		for (int i = al.size() - 1; i >= 0; i--) {
			bw.write(al.get(i)); //获取集合中索引的对应的值
			bw.newLine();    //没写入一行则换行
		}
		//7.关闭字符输出流(关键点)
		bw.close();
	}
	
	public static void lnr() throws FileNotFoundException, IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader("d:\\chinese.txt"));
		String line;
		lnr.setLineNumber(1); //行号设置
		while((line = lnr.readLine()) != null){
			System.out.println(lnr.getLineNumber() + ":" + line); //行号读取(根据我们设置的行号递增)
		}
		lnr.close();
	}

}

//执行结果
//reverse.txt 内容
//I studying JAVA!
//I'm WeiyiGeek!
//我爱您,祖国!

//2:我爱您,祖国!
//3:I'm WeiyiGeek!
//4:I studying JAVA!


