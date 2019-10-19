package com.weiyigeek.Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo_TimerTask {
	public static void main(String[] args) throws InterruptedException {
		//��ʱ��timer��ʵ����ʾ
		Timer t = new Timer(); //��ʱ������
		t.schedule(new NewTask(), new Date(2019-1900,9,19,11,21,30),3000); //��ʱ������ ����һ����TimerTask���� 3s�ظ�һ��
		while(true){
			Thread.sleep(1000);  //f2-���һ���ж�
			System.out.println(new Date());
		}
	}
}

//�½���һ����̳�timer���������Զ�Ҫָ��������(ʵ���ϼ̳���Runnableʵ�ֶ��߳�)
class NewTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("����ִ������!");
	}
}
