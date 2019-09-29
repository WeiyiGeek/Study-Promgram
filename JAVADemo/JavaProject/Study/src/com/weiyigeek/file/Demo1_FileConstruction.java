package com.weiyigeek.file;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Demo1_FileConstruction {
	public static void main(String[] args) throws IOException {  //�׳�IO�쳣ģ��(��Ҫע��)
		//#ʾ��1:File��Ĺ��췽��ʹ�÷��� ##########################################
		File f1 = new File("E:\\githubProject\\Study-Promgram\\update.sh");
		System.out.println("��ʽ1���ж�update.sh�Ƿ���� : " + f1.exists());
		//----------------------
		String parent = "E:\\githubProject\\Study-Promgram";
		String child = "update.sh";
		File f2 = new File(parent,child);
		System.out.println("��ʽ2��" + f2.exists());
		//----------------------		
		File file = new File("E:\\githubProject\\Study-Promgram"); //ΪʲôҪ�������ַ�ʽ��,��������Ȼ��˵��;
		String filename = "update.sh";
		File f3 = new File(file,filename);
		System.out.println("��ʽ3��" + file.exists() + " - " + f3.exists());
		
		
		//#ʾ��2:File���г��÷��� ########################################################
		// createNewFile �����ļ�
		File f4 = new File("E:\\","FileClass.txt");
		boolean flag = f4.createNewFile();
		String res = flag ? "�ļ������ɹ�" : "�ļ��Ѿ�����";
		System.out.println(res);
		//----------------------
		// mkdir ���������ļ���
		File d1 = new File("E:\\CreateDirector");
		System.out.println("���������ļ� ��" + d1.mkdir());
		//----------------------
		// mkdirs �����༶�ļ�����Linux�� md -p /tmp/create/www
		File d2 = new File("E:\\CreateDirector\\Web\\WWW");
		System.out.println("���������ļ� ��" + d2.mkdirs());
		
		
		//#ʾ��3:File������������ɾ������ ########################################################
		// renameTo ����
		File f5 = new File("E:\\FileClass.txt");
		File f6 = new File("E:\\CreateDirector\\Web\\WWW\\FileClassRename.txt");
		//System.out.println("�ļ��������� : " + f5.renameTo(f6));  //���е�f6��ָ��·��
		
		// delete ɾ�� (ע��ֻ��ɾ���ļ�������Ϊ�յ��ļ���)
		System.out.println("�ļ�ɾ����" + f6.delete());
		System.out.println("�ļ���ɾ����" + d1.delete());
		
		//#ʾ��4:File�����жϹ��� ########################################################
		System.out.println("�Ƿ����ļ�: " + f5.isFile());
		System.out.println("�Ƿ����ļ���: " + d2.isDirectory());
		
		//#ʾ��4:File���л�ȡ���� ########################################################
		System.out.println("����·����" + f2.getAbsolutePath());
		System.out.println("Filel��ʵ��������·�� : " + f2.getPath());
		System.out.println("�ļ�����: " + f2.getName());
		System.out.println("�ļ���д: " + f2.length()); 
		Date d = new Date(f5.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		System.out.println(sdf.format(d));
		//�ص�(Ŀ¼�е�)
		File f7 = new File("F:/day19_video");
		String[] arr = f7.list();
		for (String s : arr) {
			System.out.println(s); //�ļ�����/Ŀ¼����
		}
		File[] filearr = f7.listFiles();
		for (File sf : filearr) {
			System.out.println(sf); //����·��Ŀ¼���Ҵ��ļ�·��
		}
	}
}
