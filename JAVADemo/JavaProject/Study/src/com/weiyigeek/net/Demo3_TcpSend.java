<<<<<<< HEAD
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
=======
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
>>>>>>> 96cd630503027409f79068bfe4468a7f0b544d2b
