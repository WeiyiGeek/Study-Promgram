package com.weiyigeek.net;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Demo3_TcpSend {

	public static void main(String[] args) throws Exception {
		//1.tcp Socket �ͻ���
		Socket client = new Socket("127.0.0.1",9999); //����Socketָ��ip��ַ�Ͷ˿ں�
		InputStream is = client.getInputStream(); // ��ȡ����˷��͵���������Ϣ
		OutputStream os = client.getOutputStream(); //�ͻ��������˷�����Ϣ
		
		//�Ƚ��ͷ������Ϣ
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr,0,len));
		
		//�������˷�����Ϣ
		os.write("���ǿͻ��˷�������Ϣ!".getBytes());
		
		//�رտͻ���Socket
		client.close();
	}

}
