package com.weiyi;
public class Person {
  public String name;
  public int age;

  public Person(){}
  public Person(String name,int age)
  {
    this.name = name;
    this.age = age;
  }
  
  public String getName(){
    return name;
  }
  public int getAge(){
    return age;
  }
} 