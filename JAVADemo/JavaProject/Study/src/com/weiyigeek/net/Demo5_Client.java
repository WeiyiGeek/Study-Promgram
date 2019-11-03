package com.weiyigeek.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo5_Client {
	public static void main(String[] args) throws Exception, IOException {
		//(1) �ͻ�������
		//1.¼���ϴ��ļ���·����������֤��·���Ƿ����
		File upFile = getFile();
		//2.�����ļ������ڷ����
		Socket client = new Socket("127.0.0.1",9999);
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())); // ��ȡ������
		PrintStream ps = new PrintStream(client.getOutputStream()); //��ȡ�����
		System.out.println("���������˷��ͽ�Ҫ�ϴ����ļ�����:" + upFile.getName());
		ps.println(upFile.getName());
		
		//6.���ս�����жϷ�����Ƿ���ڸ��ļ�
		 String res = br.readLine();
		 System.out.println(res);
		 if(res.equals("Found")) {
			 System.out.println("������Ѿ����ڸ��ļ��벻Ҫ�����ϴ�,�����ر�Client Socket!");
			 client.close();
			 return;
		 }else {
			 System.out.println("����˲����ڸ��ļ������ϴ���");
		 }
		 
		 //7.���ֽ������Կ����κ��ļ���ʹ��FileInputStream��ȡ�ļ�����д�뵽����֮��
		 FileInputStream fis = new FileInputStream(upFile);
		 byte[] arr = new byte[8192];
		 int len;
		 
		 while((len = fis.read(arr)) != -1) {
			 //PrintStream �ŵ�:����д�ַ���Ҳ����д�ֽ���
			 //BufferedWriter : ֻ����д�ַ���
			 ps.write(arr, 0, len);
		 }
		 
		 //�ر�IO�ļ���socket
		 fis.close();
		 client.close();
	}

	private static File getFile() {
		Scanner sc = new Scanner(System.in); //����¼��·���Ķ���
		System.out.print("��������Ҫ�ϴ����ļ�·��: ");
		while(true){
			String line = sc.nextLine();
			File path = new File(line);
			if(!path.exists()) {
				System.out.println("�ļ�����������������: ");
				
			}else if (path.isDirectory()){
				System.out.println("�������·����Ŀ¼�����ļ�����������: ");
			}else {
				return path;
			}
		}
	}
}
