package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo4_Client {
	public static void main(String[] args) throws Exception, IOException {
		//����:�ͻ����������д�ַ���(����¼��),������(���߳�)���ַ�����ת��д��,�ͻ����ٴζ�ȡ���Ƿ�ת����ַ���
		//1.����˴���socket (��ͷ)
		Socket socket = new Socket("127.0.0.1",8888); //�����Ͷ˶����ӵķ���˵�IP:prot
		Scanner sc = new Scanner(System.in);  //��������¼�����
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //��ȡ������
		PrintStream ps = new PrintStream(socket.getOutputStream()); //��ȡ�����
		System.out.print("��������Ҫ���͵��ַ���:");
		ps.println(sc.nextLine() ); // �����˷�����Ϣ
		System.out.println("����˷�ת����ַ���:" + br.readLine());
		socket.close();  //�ر�socket - ʵ�ʿ����зǳ���Ҫ
	}
}
