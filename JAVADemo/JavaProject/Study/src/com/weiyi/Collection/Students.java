package com.weiyi.Collection;
//����һ��ѧ����
public class Students implements Comparable<Students> {
	private String name;
	private int age;
	//�����ղκ��в�
	public Students() {}
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//����get/setter ����
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Students o) {
		// TODO Auto-generated method stub
		/**
		 //������ȡԪ�ص�ʱ���Ǵ���߿����ұߣ���Ҫ��ƥ�����䵱�����ظ���ʱ����������������������Ҫ����������Ҫ����������
			��compareTo��������0��ʱ�򼯺���ֻ��һ��Ԫ��(���洢����Ԫ��)
			��compareTo��������������ʱ�򼯺ϻ���ô�����ôȡ
			��compareTO�������ظ�����ʱ�򼯺ϻᵹ��洢
			return 0;
		*/
		int num = this.age - o.age;
		System.out.println(num);
		return num == 0 ? this.name.compareTo(o.name) : num;  //�ж������Ƿ���ͬ�����ͬ�ٿ����������ǲ�����ͬ(��String���Ѿ���д��compareTo-��ͬ����0��o.name���ڷ���1,o.nameС�ڷ���-1)���򷵻�num
		 
	}
	
	
	
}

