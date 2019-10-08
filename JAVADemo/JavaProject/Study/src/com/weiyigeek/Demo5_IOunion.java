package com.weiyigeek;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo5_IOunion {
	public static void main(String[] args) throws IOException {
		//ʾ��1.IO���̺��Ŀ���ͼƬ�ֽ���(�������������)-��ʽ1
		try {
			FileInputStream fis = new FileInputStream("F:\\IMG_2330.PNG"); //����������
			FileOutputStream fos = new FileOutputStream("F:\\IMG_2330.bak.png"); //���������
			int flag;
			while((flag = fis.read()) != -1) //�൱����copy��Ч��
			{
				fos.write(flag);
			}
			System.out.print("ʾ��1.�����������������ʹ�ý���CopyͼƬ��Ч��;");
			fis.close(); //�ر��������򿪵��ļ��ͷ���Դ
			fos.close(); //�ر�������򿪵��ļ��ͷ���Դ
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//ʾ��2.IO��������Ƶ��Դ�ֽ���(һ����-1B-8bit)-��ʽ2(���Ǵ��ַ�ʽ���׵����ڴ����)
		try {
			FileInputStream fis = new FileInputStream("F:\\IMG_2330.PNG"); //����������
			FileOutputStream fos = new FileOutputStream("F:\\IMG_2330.bak1.png"); //���������
			byte[] count = new byte[fis.available()]; //��������ֽ���������֮��(�������ļ���ͬ��С���ֽ�����)
			System.out.println("ͼƬ��С: "+fis.available()+" Byte");
			fis.read(count); //���ļ��ϵ�Byte�������������ֽڶ�ȡ���ڴ���(���� b.length�����������ֽ����������ֽڡ� )
			fos.write(count); //���ֽ������е��ֽ�����д���ļ���
		} catch (Exception e) {
			System.out.println();
		}finally {
			System.out.println("ʾ��2.һ���Զ�ȡ�ļ�����ֽ������ڴ���,Ȼ�����ڴ��е��ֽ�����д�뵽�����ļ���");
		}
	}
}
