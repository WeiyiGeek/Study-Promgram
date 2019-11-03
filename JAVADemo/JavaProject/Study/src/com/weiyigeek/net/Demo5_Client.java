package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo5_Client {
	public static void main(String[] args) throws Exception, IOException {
		//(1) 客户端流程
		//1.录入上传文件的路径，并且验证该路径是否存在
		File upFile = getFile();
		//2.发送文件名称在服务端
		Socket client = new Socket("127.0.0.1",9999);
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())); // 获取输入流
		PrintStream ps = new PrintStream(client.getOutputStream()); //获取输出流
		System.out.println("正在向服务端发送将要上传的文件名称:" + upFile.getName());
		ps.println(upFile.getName());
		
		//6.接收结果，判断服务端是否存在该文件
		 String res = br.readLine();
		 System.out.println(res);
		 if(res.equals("Found")) {
			 System.out.println("服务端已经存在该文件请不要重新上传,即将关闭Client Socket!");
			 client.close();
			 return;
		 }else {
			 System.out.println("服务端不存在该文件正在上传！");
		 }
		 
		 //7.用字节流可以拷贝任何文件，使用FileInputStream读取文件并且写入到网络之中
		 FileInputStream fis = new FileInputStream(upFile);
		 byte[] arr = new byte[8192];
		 int len;
		 
		 while((len = fis.read(arr)) != -1) {
			 //PrintStream 优点:可以写字符流也可以写字节流
			 //BufferedWriter : 只可以写字符流
			 ps.write(arr, 0, len);
		 }
		 
		 //关闭IO文件和socket
		 fis.close();
		 client.close();
	}

	private static File getFile() {
		Scanner sc = new Scanner(System.in); //创建录入路径的对象
		System.out.print("请输入您要上传的文件路径: ");
		while(true){
			String line = sc.nextLine();
			File path = new File(line);
			if(!path.exists()) {
				System.out.println("文件不存在请重新输入: ");
				
			}else if (path.isDirectory()){
				System.out.println("您输入的路径是目录不是文件请重新输入: ");
			}else {
				return path;
			}
		}
	}
}
