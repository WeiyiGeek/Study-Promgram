/**
 * ե֭��Juicerʾ�������÷���Class.forName()�����ļ���ȡ
 * Fruit ˮ���ӿ�
 * Apple �� Orange �� Banana
 * squeeze ե֭
 */
package com.weiyigeek.reflect;

import java.io.BufferedReader;
import java.io.FileReader;

public class Demo2_ReflectForName {
	public static void main(String[] args) throws Exception {
		Juicer j = new Juicer(); //�൱�ڹ���ե֭��
		//���÷�����������ļ���ȡconfig.properties
		BufferedReader br = new BufferedReader(new FileReader("config.properties")); //�����ļ��ж�ȡclass����
		
		//ƻ�� /���� (�ǳ�ֵ��ѧϰ)
		String line;
		while((line = br.readLine()) != null) {
			Class clazz2 = Class.forName(line);   //��ȡһ�� => ��.���� Ҫʹ��������ʱ��ֱ�Ӹ������Ƽ���
			Fruit o= (Fruit) clazz2.newInstance(); //����ת�� ��������ָ���������(����һ���µĶ���)��ˮ��������ָ������ j.run(f);
			j.run(o);
		}
	}
}

//ˮ���ӿ�
interface Fruit {
	public void squeeze();
}
//ƻ��֭
class Apple implements Fruit {
	@Override
	public void squeeze() {
		System.out.println("����һ�� ƻ�� ֭");
	}
}
//����֭
class Orange implements Fruit {
	@Override
	public void squeeze() {
		System.out.println("����һ�� ���� ֭");
	}
	
}
//�㽶֭
class Banana implements Fruit {
	@Override
	public void squeeze() {
		System.out.println("����һ�� �㽶 ֭");
	}
}

//ե֭����
class Juicer {
	public void run(Fruit a){
		a.squeeze();
	}
}
