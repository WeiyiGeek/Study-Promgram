package com.weiyigeek.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo1_UDPSend {

	public static void main(String[] args) throws Exception {
		// 1.������֮UDPЭ�� - socket �����Ż������Ͷˣ�
		Scanner sc = new Scanner(System.in);  //��������¼�����
		DatagramSocket udpsocket = new DatagramSocket(); //����һ��UDP-socket�൱����һ����ͷ
		while(true) {
			String str = sc.nextLine();  //��������¼����ַ������������quit���˳�ѭ�� �൱���ǻ���
			//����Packet�൱�ڼ�װ��
			DatagramPacket pt = new DatagramPacket(str.getBytes(), str.getBytes().length,InetAddress.getByName("127.0.0.1"), 8888);
			udpsocket.send(pt); //��socketͨ�������ݷ��ͳ�ȥ,����ͷ���ͻ���;
			if(str.equals("quit")){
				break;
			}
		}
		udpsocket.close();
	}

}
