package com.weiyi.Collection;
//创建一个学生类
public class Students implements Comparable<Students> {
	private String name;
	private int age;
	//创建空参和有参
	public Students() {}
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//创建get/setter 方法
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
		 //二叉树取元素的时候是从左边开向右边（主要光匹配年龄当年龄重复的时候会出现问题所以这里我们要考虑完整次要条件姓名）
			当compareTo方法返回0的时候集合中只有一个元素(不存储其他元素)
			当compareTo方法返回正数的时候集合会怎么存就怎么取
			当compareTO方法返回负数的时候集合会倒序存储
			return 0;
		*/
		int num = this.age - o.age;
		System.out.println(num);
		return num == 0 ? this.name.compareTo(o.name) : num;  //判断年龄是否相同如果相同再看其姓名是是不是相同(再String中已经重写了compareTo-相同返回0，o.name大于返回1,o.name小于返回-1)否则返回num
		 
	}
	
	
	
}

