//ģ�巽�����ģʽ:
package com.weiyigeek.reflect;
public class Demo6_Template {
	public static void main(String[] args) {
		Temp tmp = new Temp();
		System.out.println("����ʱ��Ϊ: " + tmp.getRunTime());
	}
}

//����һ��������
abstract class GetRunTime {
	//ӵ�г��󷽷�(abstract)��������ǳ�����,Ϊ�˷�ֹ�෽�������¼���һ��final��������,�������ֱ�ӵ��ø��෽��;
	public final long getRunTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return end - start;
	}
	public abstract void code();
}


//����һ���ಢ�̳иó�����
class Temp extends GetRunTime {
	@Override
	public void code() {
		for(int i = 0; i < 10000; i++)
			System.out.println(i);
	}
}
