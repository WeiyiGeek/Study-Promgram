package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo4_Client {
	public static void main(String[] args) throws Exception, IOException {
		//需求:客户端向服务器写字符串(键盘录入),服务器(多线程)将字符串反转后写回,客户端再次读取到是反转后的字符串
		//1.服务端创建socket (码头)
		Socket socket = new Socket("127.0.0.1",8888); //创建客端端连接的服务端的IP:prot
		Scanner sc = new Scanner(System.in);  //创建键盘录入对象
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //获取输入流
		PrintStream ps = new PrintStream(socket.getOutputStream()); //获取输出流
		System.out.print("请输入您要发送的字符串:");
		ps.println(sc.nextLine() ); // 向服务端发送信息
		System.out.println("服务端翻转后的字符串:" + br.readLine());
		socket.close();  //关闭socket - 实际开发中非常重要
	}
}
