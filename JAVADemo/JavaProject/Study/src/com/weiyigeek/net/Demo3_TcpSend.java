package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Demo3_TcpSend {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8888);  //�����ͻ������ӵ�����˵�Tcp-socket = �ۿ�
		//�Ż�1:��Ҫ����ʱ�����ַ�����д��ʱ��Ҳ���ַ���
		//�Ż�2:��������Ӧ���Ƕ��̵߳�
		
		//��ʱ�����ǽ�һ���ֽ���ת����Ϊ���ַ��� 
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //��ȡ����˷��͵���Ϣ,��ȡĬ������\r\nΪ��������
		//���ﲻ����ʹ��BufferedWriter һ��һ��д
		PrintStream ps = new PrintStream(socket.getOutputStream()); //PrintStream ����д�뻻�еķ���������\r\nΪ��������;
		//��ȡ����˵���Ϣ���������Ϣ
		System.out.println(br.readLine());
		ps.println("2.���ǿͻ��˵ķ�����Ϣ!");
		System.out.println(br.readLine());
		ps.println("4.�ͻ��˵�ͨ�Ž���!");
		//�رտͻ��˵�socket
		socket.close();
	}
}
