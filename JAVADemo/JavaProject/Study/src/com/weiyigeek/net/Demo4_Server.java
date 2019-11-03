package com.weiyigeek.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Demo4_Server {
	
	public static void main(String[] args) throws Exception, IOException {
		//���� �����  socket
		ServerSocket ss = new ServerSocket(8888);
		//���ϵĽ��շ���˵�����
		while(true){
			final Socket sc = ss.accept(); //���յ��Ͷ˷��͵���Ϣ
			//��������˶��߳�
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream())); //��ȡ������
						PrintStream ps = new PrintStream(sc.getOutputStream()); //��ȡ�����
						//��Ȼ����Ҳ���Բ���StringBuilder
						StringBuffer sendMsg = new StringBuffer(br.readLine()).reverse(); //���տͻ��˵��ַ������ҽ��з�ת
						System.out.println("����˷�ת�ͻ��˷��͵��ַ���:" + sendMsg);
						ps.println(sendMsg); //��ͷ��˷��ͷ�ת����ַ���
						sc.close();  //�ؼ����տͶ˶˵�socket
					} catch (IOException e) {
						e.printStackTrace();
					}  
				}
			}.start();
		}
	}
}
