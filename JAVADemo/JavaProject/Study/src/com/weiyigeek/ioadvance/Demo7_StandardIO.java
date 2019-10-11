package com.weiyigeek.ioadvance;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Demo7_StandardIO {

	public static void main(String[] args) throws IOException {
		//示例1.标准输入输出流基础使用
//		System.setIn(new FileInputStream("d:\\PrintWrite.txt")); //修改标准输入流
//		System.setOut(new PrintStream("b.txt"));				//修改标准输出流（需要采用打印流）
//		
//		InputStream in = System.in;								//获取标准输入流默认指向键盘输入改变之后指向a.txt
//		PrintStream ps = System.out;							//获取标准输出流默认指向的是控制台改变后指向a.txt
//		int b;
//		while((b = in.read()) != -1) {							//从a.txt上读取数据
//			ps.write(b);										//将数据写到b.txt上
//		}
//		
//		//System.out.println();	//也是一个输出流,不用关因为没有和硬盘上的文件产生关联的管道
//		in.close(); 
//		ps.close();
		
		//示例2.修改标准输入输出流拷贝图片
//		System.setIn(new FileInputStream("IO图片.png"));		//改变标准输入流
//		System.setOut(new PrintStream("copy.png")); 		//改变标准输出流
//		
//		InputStream is = System.in;							//获取标准输入流
//		PrintStream ps1 = System.out;						//获取标准输出流
//		
//		int len;
//		byte[] arr = new byte[1024 * 8];  //字节数组(存储读取的字节流)
//		while((len = is.read(arr)) != -1) 
//			ps1.write(arr, 0, len);
//		
//		is.close();
//		ps1.close();
		
		
		//示例3.两种方法实现键盘录入（与上面示例1/2冲突）
		System.setIn(System.in); //恢复原始的标准输入输出流指向
		System.setOut(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //转换流字节流转成一个字符流然后通过BufferedReader进行进一步封装
		String line = br.readLine();
		System.out.println("方式1键盘录入结果: " + line);
		br.close();
		//方式2就是采用Scanner类来接收输入
	}
}
