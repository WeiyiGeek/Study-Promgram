package com.weiyigeek;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_IO {

	public static void main(String[] args) throws IOException {
		// 实例1.一个读程序案例InputStream
		try {
			FileInputStream fis = new FileInputStream("c:\\read.txt"); //创建流对象并关联demo.txt
			int flag = 0;
			System.out.print("文件中读取到的字符: ");
			while((flag = fis.read()) != -1)  //从硬盘上读取一个字节结束标志为-1
			{
				System.out.print(Character.toChars(flag)); //打印每一个字符将字节编码转换成为字符
			}	
			fis.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	

		// 示例2.写入字符到文本之中
		try {
			//创建数据流对象如果没有该文件则建立该文件,如果有这个文件会将覆盖其内容
			FileOutputStream fos = new FileOutputStream("c:\\write.txt");
			for (int i = 32; i < 128; i++) {
				fos.write(i); //虽然写出的是一个int数,但是在写出的时候会将前面的24个0去掉所以写出的一个byte
			}
			System.out.println("\nASCII码字符写入覆盖成功!");
			fos.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		//示例3.FileOutputStream实现数据的追加写入
		try {
			FileOutputStream fos = new FileOutputStream("c:\\write.txt", true); //多个一个boolean参数表示进行追加写入
			fos.write('\r'); //换行回车符
			fos.write('\n');
			fos.write('a');
			fos.write('p');
			fos.write('p');
			fos.write('e');
			fos.write('n');
			fos.write('d');
			System.out.println("追加Append写入成功!");
			fos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
