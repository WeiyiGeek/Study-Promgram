package com.geek.hellowrold;
public class objectDog{
	int dogAge;
	String dogColor;
	
	public objectDog(String name){
		System.out.println("Welcome to my animins : "+name);
	}

	public void setAge( int age){
		dogAge = age;
	}
	
	public void setColor( String color){
		dogColor = color;
	}

	public int getAge(){
		System.out.println("Dog Age = "+dogAge);
		return dogAge;
	}
	
	public String getColor(){
		System.out.println("Dog Color = "+dogColor);
		return dogColor;
	}

	/*jinglaoshi leiming zuihao daxie */
	public static void main (String []args){
	/* 创建对象 */
	  objectDog myPuppy = new objectDog("tommy");
      /* 通过方法来设定age */
      myPuppy.setAge(2);
      /* 调用另一个方法获取age */
      myPuppy.getAge();
	  
	  myPuppy.setColor("red");
	  myPuppy.getColor();
	  
      /*你也可以像下面这样访问成员变量 */
      System.out.println("变量值 : " + myPuppy.dogAge +"\t"+myPuppy.dogColor); 
	}
		
}
	
