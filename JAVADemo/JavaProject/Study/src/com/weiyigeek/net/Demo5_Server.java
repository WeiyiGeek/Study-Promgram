package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo5_Server {
	public static void main(String[] args) throws Exception {
		//(2) 服务端流程
		//3.创建多线程
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("服务器已启动绑定端口 : 9999 --- run");
		
		//4.接收客服端的数据并读取文件名称
		while(true) {
			final Socket res = ss.accept(); //接收客服端发送的信息
			//多线程实例
			new Thread() {
				public void run() {
					try {
						//需要抽取出来字节流
						InputStream is = res.getInputStream(); 
						BufferedReader br = new BufferedReader(new InputStreamReader(is)); // 获取输入流（字符流）
						PrintStream ps = new PrintStream(res.getOutputStream()); //获取输出流
						String fileName = br.readLine(); //读取发送的文件名
						
						//5.判断服务端里面文件是否存在将结果发送客户端
						File dir = new File("update");
						dir.mkdir();
						File file = new File(dir,fileName); //封装成为File对象
						if(file.exists()) {
							ps.println("Found"); //服务端存在!
							res.close();
						}else {
							ps.println("NotFound"); //服务端不存在！
						}
						
						//8.从网络中读取传输的文件数据,并且写入到本地之中
						FileOutputStream fos = new FileOutputStream(file);
						byte[] arr = new byte[8192];
						int len;
						while((len = is.read(arr)) != -1) {
							fos.write(arr,0,len);
						}
						System.out.println(file.getName() +"文件上传成功!");
						//关闭文件IO和SocketIO
						fos.close();
						res.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}	
	}
}
