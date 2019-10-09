package com.weiyigeek.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo8_ImagesEncrpty {
	public static void main(String[] args) throws IOException {
		//实例实现图片的加解密并且复用两种异常处理方法
		Byte secret = 127;
		System.out.println("1.图片加密中!");
		encryption(secret);
		System.out.println("2.图片解密中!");
		decrption(secret);
	}

	//图片加密
	public static void encryption(Byte secretKey) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("d:\\qq.png");
			fos = new FileOutputStream("d:\\qq.encrpty.png");
			
			int count;
			while((count = fis.read()) != -1)
				fos.write(count ^ secretKey);
			System.out.println("qq.png 加密完成!");
		}finally {
			//释放资源
			if(fis != null)
				fis.close();
			if(fos != null)
				fos.close();
		}
	}
	
	//图片解密
	public static void decrption(Byte secretKey) throws IOException{
		try(
			FileInputStream fis = new FileInputStream("d:\\qq.encrpty.png");
			FileOutputStream fos = new FileOutputStream("d:\\qq.decrpty.png");
		){
			int count;
			while(( count = fis.read()) != -1)
				fos.write(count ^ secretKey);
			System.out.println("qq.encrpty.png 解密完成!");
		}
	}
}
