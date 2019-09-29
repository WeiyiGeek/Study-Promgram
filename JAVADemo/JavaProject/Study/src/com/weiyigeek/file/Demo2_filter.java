package com.weiyigeek.file;

import java.io.File;
import java.io.FilenameFilter;

public class Demo2_filter {

	public static void main(String[] args) {
		//ʾ��1.�ļ����˲���ʵ��(�����ж�)
		File f1 = new File("F:/day19_video");
		File[] subFiles = f1.listFiles();
		for (File file : subFiles) {
			if(file.isFile() && file.getName().endsWith(".avi"))
			{
				//�����׺Ϊ.avi���ļ�
				System.out.println(file);
			}
		}
	
		
		//ʵ��2.��������ʹ��;�����ж�E��Ŀ¼���Ƿ��к�׺��Ϊ.jpg���ļ�������о�������ļ�����
		String[] arr = f1.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				File file = new File(dir, name);
				return file.isFile() && file.getName().endsWith(".avi");
			}
		});
		
		for (String str : arr) {
			System.out.println("���������� ��" + str);
		}
	}
}
