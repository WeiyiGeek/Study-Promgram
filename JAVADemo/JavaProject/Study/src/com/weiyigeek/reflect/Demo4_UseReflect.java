package com.weiyigeek.reflect;
import java.io.BufferedReader;
import java.io.FileReader;
import com.weiyi.Collection.Students;
public class Demo4_UseReflect {
	public static void main(String[] args) throws Exception {
		//1.ʵ��1Reflectͨ������
		Students stu = new Students("����",1024);
		System.out.println("�޸�ǰ:" + stu);

		Demo3_ReflectTool tool = new Demo3_ReflectTool();
		tool.setProperty(stu,"name","����");
		System.out.println("�޸ĺ�:" + stu);
		
		//2.������ϰ
		//дһ��Properties��ʽ�������ļ������������������;
		//дһ��������������ļ��������������Ʋ���������࣬�÷���÷�������run
		BufferedReader br = new BufferedReader(new FileReader("config.properties"));  //����������
		Class clazz = Class.forName(br.readLine()); //��ȡ�����ļ���������ȡ�ֽ������
		Demo3_ReflectTool dr = (Demo3_ReflectTool) clazz.newInstance(); //ͨ���ֽ��봴���ö��� (��Ҫǿת)
		dr.run(); //���ɵ���Demo3_UseReflect���е÷���
	}
}
