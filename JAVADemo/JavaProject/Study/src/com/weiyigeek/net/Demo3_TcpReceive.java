package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo3_TcpReceive {
	private static ServerSocket ss;
	public static void main(String[] args) throws Exception {
		ss = new ServerSocket(8888);
		while(true){
			final Socket socket = ss.accept(); // 循环的接收客户端的信息
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //接收的字节流转换成为字符流
						PrintStream ps = new PrintStream(socket.getOutputStream()); //向客服端发送信息的对象
						ps.println("1.我是服务端发出的信息!"); //注意这里不能采用print否则会一直卡输入界面，这是由于没有\r\n，客户端不知道什么时候结束就一直在读
						System.out.println(br.readLine());
						ps.println("3.服务端请求客户端关闭通信");
						System.out.println(br.readLine());
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}

	}
}
