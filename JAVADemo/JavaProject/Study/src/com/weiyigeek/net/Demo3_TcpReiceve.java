package com.weiyigeek.net;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Demo3_TcpReiceve {
	public static void main(String[] args) throws Exception {
		//2.Server�����TCP socket ����
		ServerSocket ss = new ServerSocket(9999); //����˼����˿�
		Socket socket = ss.accept(); //���ܿͷ��˵�����
		InputStream is = socket.getInputStream();  //��ȡ�ͻ��˵�������
		OutputStream os = socket.getOutputStream(); //�ͻ��˵������
		
		//��ͻ��˷�����Ϣ
		os.write("���Ǵӷ���˷��͵���Ϣ".getBytes());
		
		//��ӡ�����տͻ��˷��͵���Ϣ
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr,0,len));
		socket.close();
	}
}
