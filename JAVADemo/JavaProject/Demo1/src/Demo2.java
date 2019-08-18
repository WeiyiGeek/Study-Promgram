
public class Demo2 {

	public static void main(String[] args) {
		//ʾ��1��hashCode() ��ʹ��
		Object obj1 = new Object();
		System.out.println("Object ����"+obj1.hashCode());
		System.out.println("Object �����ַ��"+System.identityHashCode(obj1));
	
		//ʾ��2.getclass() ��ʹ��
		Person g = new Person(1,"WeiyiGeek");
		Class demo = g.getClass(); //��ȡ������ֽ����ļ�
		System.out.println("Person ������:"+demo.getName()); //��ȡ������

		//ʾ��3.toString() ��ʹ��
		String info = g.toString();
		System.out.println(info);
		System.out.println(g); //���ֱ�Ӵ�Ӧ��������ã���Ĭ�ϵ���toString����
		
		
		//ʾ��4.equals() ��ʹ��
		//Object�е�equals�����Ƚ϶���ĵ�ֵַ,û��ʲô���壬������Ҫ��д����
		//��Ϊ�ڿ���������ͨ���Ƚ϶����е�����ֵ,������Ϊ��ͬ������ͬһ����,�������Ǿ���Ҫ��д��;
		Person g1= new Person(1,"WeiyiGeek");
		System.out.println(g1.equals(g));  //ʵ�ʻ��ǲ�������==��ʽ�Ƚ�,�����ǶԷ�����������д
		System.out.println(g1 == g );  //���equals
	}

}

class Person {
	public String name;
	public int num = 1;
	public Person() {
		super();
	}
	public Person(int num,String name) {
		this.num = num;
		this.name = name;
	}
	//�ؼ���1
	@Override
	public String toString() {
		System.out.println("��дtoString������num = "+num);
		return super.toString();
	}
	//�ؼ���2 : ��дobject�е�equals����
	@Override
	public boolean equals(Object obj) {
		//����ת��
		Person s = (Person)obj;
		return this.name.equals(s.name) && this.num == s.num;
	}
	

}
