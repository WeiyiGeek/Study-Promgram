package com.weiyigeek.Thread;
import java.io.IOException;
public class Demo10_Runtime {
	public static void main(String[] args) throws IOException, InterruptedException{
		//���߳���ѧϰ Runtime
		Runtime r = Runtime.getRuntime(); //ע������Runtime���ǵ�ʵ�����������侲̬�����ķ�����ȡRuntime�ڲ�ʵ��������
		//��ʾ����ͬһ����������ִ�йػ������ȡ���ػ�
		System.out.println("����ִ�йػ�����!");
		r.exec("shutdown -s -t 300");  //300s �ػ�
		Thread.sleep(5000);  //���߳� ���� 5s
		r.exec("shutdown -a");
		System.out.println("�Ѿ�ȡ���ػ�!");
	}
}
