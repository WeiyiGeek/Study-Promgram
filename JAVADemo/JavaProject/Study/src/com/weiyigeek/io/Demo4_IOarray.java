package com.weiyigeek.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_IOarray {

	public static void main(String[] args) throws IOException {
		//ʵ��3.��ȡ�ĵ����ַ�ʽ
		FileInputStream fis = new FileInputStream("C:\\demo.avi");
		FileOutputStream fos = new FileOutputStream("D:\\demo.avi");
		byte[] len = new byte[1024 * 8]; //ֵ��ѧϰ1024=1k * 8 = 8K
		int length;
		//���read��û�м���len���ؾͲ��Ƕ�ȡ�ĸ���,�����ֽڵ����ֵ 300 - 6 = 294(98 + 97 + 99)abc
		while((length = fis.read(len)) != -1)  //read(len) ����ʵ�ʶ�ȡ�����ֽڸ���(���ļ��ϵ��ֽڶ�ȡ���ֽ�������)
		{
			fos.write(len, 0, length);  //ָ��������ƫ������ȡд��(�����Ͳ����ܶ�������ٶ�)-�����ѭ������ÿ��8k����
		}
		fis.close();
		fos.close();
	}
}
