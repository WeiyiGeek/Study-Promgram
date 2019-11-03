package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo5_Server {
	public static void main(String[] args) throws Exception {
		//(2) ���������
		//3.�������߳�
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("�������������󶨶˿� : 9999 --- run");
		
		//4.���տͷ��˵����ݲ���ȡ�ļ�����
		while(true) {
			final Socket res = ss.accept(); //���տͷ��˷��͵���Ϣ
			//���߳�ʵ��
			new Thread() {
				public void run() {
					try {
						//��Ҫ��ȡ�����ֽ���
						InputStream is = res.getInputStream(); 
						BufferedReader br = new BufferedReader(new InputStreamReader(is)); // ��ȡ���������ַ�����
						PrintStream ps = new PrintStream(res.getOutputStream()); //��ȡ�����
						String fileName = br.readLine(); //��ȡ���͵��ļ���
						
						//5.�жϷ���������ļ��Ƿ���ڽ�������Ϳͻ���
						File dir = new File("update");
						dir.mkdir();
						File file = new File(dir,fileName); //��װ��ΪFile����
						if(file.exists()) {
							ps.println("Found"); //����˴���!
							res.close();
						}else {
							ps.println("NotFound"); //����˲����ڣ�
						}
						
						//8.�������ж�ȡ������ļ�����,����д�뵽����֮��
						FileOutputStream fos = new FileOutputStream(file);
						byte[] arr = new byte[8192];
						int len;
						while((len = is.read(arr)) != -1) {
							fos.write(arr,0,len);
						}
						System.out.println(file.getName() +"�ļ��ϴ��ɹ�!");
						//�ر��ļ�IO��SocketIO
						fos.close();
						res.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}	
	}
}
