package com.weiyigeek.ioadvance;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Demo3_RandomAccessFile {
	public static void main(String[] args) throws IOException {
		// 基础示例
		RandomAccessFile raf = new RandomAccessFile("d:\\times.txt", "rw"); //注意模式
		System.out.println("文件字节数: "+raf.length());
		System.out.println("文件描述符对象: "+raf.getFD());
		System.out.println("读取前offset量: "+raf.getFilePointer());
		System.out.println("#### 读取内容  #####");
		byte[] arr = new byte[(int)raf.length()]; 	//防止中文不乱码字节数组
		int ch;
		while((ch = raf.read(arr)) != -1)
			System.out.print(new String(arr,0,ch));
		System.out.println("读取后offset量: "+raf.getFilePointer());
		
		raf.seek(0);   //初始化读取从头读取
		raf.write(97); //从头写入 (替换了我)
		raf.write("\r\n".getBytes()); //从头写入
		raf.seek(0); 
		int x = raf.read();
		System.out.println("读取到的字符: " + (char)x); //从头读取我们输入97 = a
		raf.close();
	}
}
