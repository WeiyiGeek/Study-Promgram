package com.weiyigeek.Thread;
public class Demo12_Waitnotify {
	public static void main(String[] args) {
		//JDK5֮ǰ�޷�����ָ����һ���̣߳�����������ѣ�,����߳�֮��ͨ����Ҫʹ��notifyAll()֪ͨ�����߳�,��while�������ж�����;
		//�����߳�ͨ��ʵ��:
		final Waitnofity wn = new Waitnofity(); //ע��������final���β����������ڲ�����ʹ��
		//�߳�1
		new Thread() {
			public void run() {
				//�����ڲ����е����������Լ������쳣
				while(true) {
					try {
						wn.print1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//�߳�2
		new Thread() {
			public void run() {
				//�����ڲ����е����������Լ������쳣
				while(true){
					try {
						wn.print2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//�߳�3
		new Thread() {
			public void run() {
				while(true) {
					//�����ڲ����е����������Լ������쳣
					try {
						wn.print3();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}


//����һ����3������һ������;
class Waitnofity {
	private int flag = 1;
	public void print1() throws InterruptedException {
		//ͬ��������
		synchronized (this) {
			while(flag != 1){ //�߳�1�ڴεȴ�,while()ѭ����ѭ���ж�ÿ�ζ����жϱ��
				this.wait();
			}
			System.out.print(Thread.currentThread().getName() + " - Print1()");
			System.out.println(" ");
			flag=2;
			this.notifyAll(); // �������е��߳�(���������ѡ���̣߳���������������ִ��)
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this) {
			//�������if����������ȴ����������
			while(flag != 2){ //�߳�2�ڴεȴ�
				this.wait();
			}
			System.out.print(Thread.currentThread().getName() + " - Print2()");
			System.out.println(" ");
			flag=3;
			this.notifyAll(); // �������е��߳�
		}
	}
	
	public void print3() throws InterruptedException {
		synchronized(this) {
			while(flag != 3){ //�߳�3�ڴεȴ���
				this.wait();
			}
			System.out.print(Thread.currentThread().getName() + " - Print3()");
			System.out.println(" ");
			flag=1;
			this.notifyAll(); // �������е��߳�
		}
	}
}