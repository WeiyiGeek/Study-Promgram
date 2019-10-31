package com.weiyigeek.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Demo1_UDPReceive {
	public static void main(String[] args) throws Exception {
		//2.Socket ͨ�Ž��ն�
		DatagramSocket udpsocket = new DatagramSocket(8888);  //����socket�൱�ڽ��ջ������ͷ
		DatagramPacket udppacket = new DatagramPacket(new byte[1024], 1024); //�������յļ�װ��
		while(true) {
			udpsocket.receive(udppacket); //���ջ���ʵ�ʾ�������
			byte[] arr = udppacket.getData(); // ��ȡ����
			int len = udppacket.getLength(); //��ȡ��Ч���ֽڸ���
			String ip = udppacket.getAddress().getHostAddress();  //��ȡIP��ַ
			int port = udppacket.getPort(); //��ȡ�˿ں�
			String msg = new String(arr, 0, len);
			System.out.println(ip+":" + port + " = " + msg );
			if(msg.equals("quit")) {
				System.out.println("ͨ�Ž���!");
				break;
			}
		}
		udpsocket.close();
	}
}
