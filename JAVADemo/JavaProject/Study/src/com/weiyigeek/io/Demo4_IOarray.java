package com.weiyigeek.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_IOarray {

	public static void main(String[] args) throws IOException {
		//实例3.读取的第三种方式
		FileInputStream fis = new FileInputStream("C:\\demo.avi");
		FileOutputStream fos = new FileOutputStream("D:\\demo.avi");
		byte[] len = new byte[1024 * 8]; //值得学习1024=1k * 8 = 8K
		int length;
		//如果read里没有加上len返回就不是读取的个数,而是字节的码表值 300 - 6 = 294(98 + 97 + 99)abc
		while((length = fis.read(len)) != -1)  //read(len) 返回实际读取到的字节个数(将文件上的字节读取到字节数组中)
		{
			fos.write(len, 0, length);  //指定索引和偏移来截取写入(这样就不可能多读或者少读)-会进行循环拷贝每次8k数据
		}
		fis.close();
		fos.close();
	}
}
