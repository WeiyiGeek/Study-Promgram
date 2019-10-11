package com.weiyigeek.ioadvance;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo2_ByteArrayOutputStream {
	public static void main(String[] args) throws IOException {
		// 示例1.内存输出流案例ByteArrayOutputStream并采用字节数组来循环读取字节数组
		FileInputStream fis = new FileInputStream("d:\\times.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); //在内存中创建了可以增长得内存数组
		byte[] arr = new byte[1024]; //创建字节数组
		int ch;
		while((ch = fis.read(arr)) != -1)
			baos.write(arr,0,ch); //将读取到的数据写入到内存之中
		
		//方式1：将缓冲区数据全部获取除了并且赋值给arr数组
		byte[] arr1 = baos.toByteArray();
		System.out.println(new String(arr1));
		
		//方式2：将缓存区的内容直接转换伟字符串进行输出(推荐)
		System.out.println(baos.toString());  //注意即使没有调用底层也会默认的帮我们调用toString方法
		fis.close();  //注意事项:内存输出流是不用关闭的当使用完毕后自动释放
	}
}
