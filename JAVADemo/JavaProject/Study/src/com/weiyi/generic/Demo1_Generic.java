package com.weiyi.generic;
import java.util.ArrayList;
import java.util.Iterator;

//��������students��
import com.weiyi.Collection.Students;

public class Demo1_Generic {
	public static void main(String[] args) {
		//ʾ��0.���͵�ʹ��(�ַ�������)
		ArrayList<String> list = new ArrayList<>(); //���Ϳ���ʡ�Բ�д(1.7�����������η���)
		list.add("a");
		list.add("b");
		list.add("c");
		
		Iterator<String> llt = list.iterator();
		while(llt.hasNext()) {
			System.out.println(llt.next());
		}
		
		//ʾ��1.ArrayList�洢�ַ������������Ͱ�
		ArrayList<Students> lt = new ArrayList<Students>();//�ؼ���1 ������������һ��Ҫ��ͬ,����Ҳ������ǰ�������͵�������߸���
		lt.add(new Students("������",25));
		lt.add(new Students("������",22));
		lt.add(new Students("��ʦ��",21));
		
		Iterator<Students> ltr = lt.iterator(); //�ؼ���2(ע�ⷺ�ͼ�����ʲô����,����������ʲô����)
		while(ltr.hasNext())
		{
			Students obj = ltr.next(); //���ﲻ��ǿת
			System.out.println(obj.getName() +" ---- "+ obj.getAge()); //ע�������������һ��.next()ָ��ľ�����һ������
		}
		/***
		 * ִ�н����
		 * ������ ---- 25
		 * ������ ---- 22
		 * ��ʦ�� ---- 21
		 **/
		
		//ʾ��2.���͵�����:ͨ��Objectת����������
		/* ���ڵ�Object���Ϳ��Խ�������Ķ������ͣ�������ʵ�ʵ�ʹ���У���������ת�������⡣
		 * Ҳ�ʹ���������������Java�ṩ�˷�������������ȫ���⡣
		 **/
		Tool t = new Tool(); //�������������
		t.setObj(new Person("����",24)); //����ָ���������
		
		Worker w = (Worker) t.getObj(); //����ת��
		System.out.println(w); //�����ClassCastException
		//��ʵ���;������ֹϵù��ֶ��ö�һ��
		/***ִ�н��
		 * Exception in thread "main" java.lang.ClassCastException: com.weiyi.generic.Person cannot be cast to com.weiyi.generic.Worker
	at com.weiyi.generic.Demo1_Generic.main(Demo1_Generic.java:47)
		 */
	}
}

//ʾ��2��ʾ
class Tool{
	private Object obj;
	//alt + shift + s + r
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;   //���������������
	}
}

//�̳���
class Person extends Students {

	public Person() {
		super();
	}
	public Person(String name, int age) {
		super(name, age);
	}
}

class Worker extends Students {

	public Worker() {
		super();
	}

	public Worker(String name, int age) {
		super(name, age);
	}
}