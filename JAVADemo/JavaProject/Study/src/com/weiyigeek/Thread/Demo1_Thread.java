package com.weiyigeek.Thread;

public class Demo1_Thread {

	public static void main(String[] args) {
		//ʾ��1.֤��Java��JVM�Ƕ��߳�ִ�е�
		//CPU��ͬһʱ��ֻ������һ������,��������ִ��Ч��̫���˻������ϵִ����ͬ������;\
		//�߳̾���һ��·���е�����������ִ��
		for(int i = 0; i < 1000000; i++)
			new Demo();
		
		for(int i = 0; i < 1000; i++)
			System.out.println("Master Thread ִ�� " + i);	
	}
}

//Demo:������������
class Demo {
	@Override
	protected void finalize() throws Throwable {
		System.out.println(this.getClass() + "����������!");
	}
}

/**
 * ִ�н��:
 * class com.weiyigeek.Thread.Demo����������!
	class com.weiyigeek.Thread.Demo����������!
	class com.weiyigeek.Thread.Demo����������!
	Master Thread ִ�� 620
	class com.weiyigeek.Thread.Demo����������!
	class com.weiyigeek.Thread.Demo����������!
	Master Thread ִ�� 621
	Master Thread ִ�� 622
 ***/
