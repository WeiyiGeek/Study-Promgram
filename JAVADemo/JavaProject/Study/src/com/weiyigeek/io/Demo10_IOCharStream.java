package com.weiyigeek.io;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo10_IOCharStream {

	public static void main(String[] args) throws IOException {
		// 实例1.字符流类FileReader的读取使用
		FileReader fr = new FileReader("d:\\chinese.txt");
		int x;
		while((x = fr.read()) != -1) //通过码表一次读取一个字符(如果是中文一次读取两个字节)
			System.out.print((char)x); //强制转型
		
		fr.close();
		
		// 实例2.字符流类FileWriter的读取使用
		FileWriter fw = new FileWriter("d:\\demo.txt",true); 
		fw.write("\r\n我和我的祖国一刻也不能分割!\r\n"); //可以将中文字符串直接写入(其实底层还是将其转换成为字节数组存入)
		fw.write(98); //可以写出单个字符
		fw.close();
		
		// 实例3.字符流类实现字符的拷贝
		FileReader fr1 = new FileReader("d:\\chinese.txt");
		FileWriter fw1 = new FileWriter("d:\\demo.txt",true);
		int ch;
		while((ch = fr1.read()) != -1) //每次读取一个字符
			fw1.write(ch);
		
		System.out.println("\n字符流拷贝完成！正在关闭IO流！");
		fr1.close();
		fw1.close();
	}

}
