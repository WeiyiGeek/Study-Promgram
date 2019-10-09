package com.weiyigeek.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo5_IOBuffered {
	public static void main(String[] args) throws IOException {
		//ʵ��:BufferedInputStream �� BufferedOutputStream
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:\\demo.txt")); //�����ļ������������Ҵ�����������FileInputStream����װ��
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\demo.bak.txt")); //�����ļ�����������Ҵ�����������FileInputStream����װ��
	
		int b;
		while((b = bis.read()) != -1) {	 //ÿ�ζ�ȡ8192�ֽ����ݽ��ж�ȡ���ڴ�Ȼ��д�뵽������
			bos.write(b);  //���ڴ��ж�ȡд�뵽�����У����������ֽ�����ת��Ч�ʲ���byte����ֱ�ӹ���Ч�ʸ�ʡ�ڴ�
		}
		//ֻ��Ҫ�ر�װ�κ�Ķ��󼴿�ԭʵ����������Ҫ����
		bis.close();
		bos.close();
	}
}
