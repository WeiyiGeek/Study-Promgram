package com.weiyigeek.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo2_ReceSend {

	public static void main(String[] args) {
		// 多线程实现一个窗口了接和收信息
		new receive().start();
		new send().start();
	}

}

//接收端线程
class receive extends Thread {
	@Override
	public void run() {
		try {
			DatagramSocket ss = new DatagramSocket(8888);  //监听端口
			DatagramPacket pt = new DatagramPacket(new byte[1024], 1024);
			while(true)
			{
				ss.receive(pt);
				byte[] arr = pt.getData();
				int len = pt.getLength();
				String ip = pt.getAddress().getHostAddress();
				int port = pt.getPort();
				String msg = new String(arr,0,len);
				System.out.println(ip + ":" + port + "\n" + msg);
				if(msg.equals("quit")) {
					System.out.println("接收端停止-Recevice Stop");
					break;
				}					
			}
			ss.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

//发送端线程
class send extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			DatagramSocket ss = new DatagramSocket();
			while(true){
				String msg = sc.nextLine();
				DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("127.0.0.1"), 8888);
				ss.send(dp);
				if(msg.equals("quit")) {
					System.out.println("发送端停止-Send Stop");
					break;
				}
			}
			ss.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
