package com.weiyigeek.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Demo1_UDPReceive {
	public static void main(String[] args) throws Exception {
		//2.Socket 通信接收端
		DatagramSocket udpsocket = new DatagramSocket(8888);  //创建socket相当于接收货物的码头
		DatagramPacket udppacket = new DatagramPacket(new byte[1024], 1024); //创建接收的集装箱
		while(true) {
			udpsocket.receive(udppacket); //接收货物实际就是数据
			byte[] arr = udppacket.getData(); // 获取数据
			int len = udppacket.getLength(); //获取有效的字节个数
			String ip = udppacket.getAddress().getHostAddress();  //获取IP地址
			int port = udppacket.getPort(); //获取端口号
			String msg = new String(arr, 0, len);
			System.out.println(ip+":" + port + " = " + msg );
			if(msg.equals("quit")) {
				System.out.println("通信结束!");
				break;
			}
		}
		udpsocket.close();
	}
}
