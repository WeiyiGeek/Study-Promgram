package com.weiyigeek;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_IO {

	public static void main(String[] args) throws IOException {
		// ʵ��1.һ����������InputStream
		try {
			FileInputStream fis = new FileInputStream("c:\\read.txt"); //���������󲢹���demo.txt
			int flag = 0;
			System.out.print("�ļ��ж�ȡ�����ַ�: ");
			while((flag = fis.read()) != -1)  //��Ӳ���϶�ȡһ���ֽڽ�����־Ϊ-1
			{
				System.out.print(Character.toChars(flag)); //��ӡÿһ���ַ����ֽڱ���ת����Ϊ�ַ�
			}	
			fis.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	

		// ʾ��2.д���ַ����ı�֮��
		try {
			//�����������������û�и��ļ��������ļ�,���������ļ��Ὣ����������
			FileOutputStream fos = new FileOutputStream("c:\\write.txt");
			for (int i = 32; i < 128; i++) {
				fos.write(i); //��Ȼд������һ��int��,������д����ʱ��Ὣǰ���24��0ȥ������д����һ��byte
			}
			System.out.println("\nASCII���ַ�д�븲�ǳɹ�!");
			fos.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		//ʾ��3.FileOutputStreamʵ�����ݵ�׷��д��
		try {
			FileOutputStream fos = new FileOutputStream("c:\\write.txt", true); //���һ��boolean������ʾ����׷��д��
			fos.write('\r'); //���лس���
			fos.write('\n');
			fos.write('a');
			fos.write('p');
			fos.write('p');
			fos.write('e');
			fos.write('n');
			fos.write('d');
			System.out.println("׷��Appendд��ɹ�!");
			fos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
