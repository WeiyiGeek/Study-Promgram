package com.weiyigeek.io;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo1_InputStream {

	public static void main(String[] args) throws IOException {
		// ʵ��1.һ����������InputStream
		FileInputStream fis = new FileInputStream("C:\\demo.txt"); //���������󲢹���demo.txt
		int flag = 0;
		while((flag = fis.read()) != -1)  //��Ӳ���϶�ȡһ���ֽڽ�����־Ϊ-1
		{
			System.out.print(Character.toChars(flag)); //��ӡÿһ���ַ����ֽڱ���ת����Ϊ�ַ�
		}
		fis.close();  //����رմ򿪵Ĵ����ļ���Դ
	}

}
