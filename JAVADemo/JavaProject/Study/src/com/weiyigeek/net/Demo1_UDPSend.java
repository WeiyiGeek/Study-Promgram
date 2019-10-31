package com.weiyigeek.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo1_UDPSend {

	public static void main(String[] args) throws Exception {
		// 1.网络编程之UDP协议 - socket 传输优化（发送端）
		Scanner sc = new Scanner(System.in);  //创建键盘录入对象
		DatagramSocket udpsocket = new DatagramSocket(); //创建一个UDP-socket相当于是一个码头
		while(true) {
			String str = sc.nextLine();  //接收我们录入的字符串，如果等于quit则退出循环 相当于是货物
			//创建Packet相当于集装箱
			DatagramPacket pt = new DatagramPacket(str.getBytes(), str.getBytes().length,InetAddress.getByName("127.0.0.1"), 8888);
			udpsocket.send(pt); //从socket通道将数据发送出去,从码头发送货物;
			if(str.equals("quit")){
				break;
			}
		}
		udpsocket.close();
	}

}
