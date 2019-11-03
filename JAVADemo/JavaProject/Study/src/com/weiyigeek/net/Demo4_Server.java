package com.weiyigeek.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Demo4_Server {
	
	public static void main(String[] args) throws Exception, IOException {
		//创建 服务端  socket
		ServerSocket ss = new ServerSocket(8888);
		//不断的接收服务端的请求
		while(true){
			final Socket sc = ss.accept(); //接收到客端发送的信息
			//启动服务端多线程
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream())); //获取输入流
						PrintStream ps = new PrintStream(sc.getOutputStream()); //获取输出流
						//当然下面也可以采用StringBuilder
						StringBuffer sendMsg = new StringBuffer(br.readLine()).reverse(); //接收客户端的字符串并且进行翻转
						System.out.println("服务端翻转客户端发送的字符串:" + sendMsg);
						ps.println(sendMsg); //向客服端发送翻转轴的字符串
						sc.close();  //关键接收客端端的socket
					} catch (IOException e) {
						e.printStackTrace();
					}  
				}
			}.start();
		}
	}
}
