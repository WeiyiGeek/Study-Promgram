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
			final Socket socket = ss.accept(); // ѭ���Ľ��տͻ��˵���Ϣ
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //���յ��ֽ���ת����Ϊ�ַ���
						PrintStream ps = new PrintStream(socket.getOutputStream()); //��ͷ��˷�����Ϣ�Ķ���
						ps.println("1.���Ƿ���˷�������Ϣ!"); //ע�����ﲻ�ܲ���print�����һֱ��������棬��������û��\r\n���ͻ��˲�֪��ʲôʱ�������һֱ�ڶ�
						System.out.println(br.readLine());
						ps.println("3.���������ͻ��˹ر�ͨ��");
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
