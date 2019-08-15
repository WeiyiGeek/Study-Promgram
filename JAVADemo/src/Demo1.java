package com.weiyi;
//#注意这里的修饰权限
public class Demo1 {
   private String love;
   public Demo1(){}
   public Demo1(String love){
     this.love = love;
   }
   public String getLove(){
     return love;
   }
   //#关键点 （protected）的修饰符
   protected void print(){
     System.out.println("这里是不能被不同包下的无关类访问的!");
   }
}