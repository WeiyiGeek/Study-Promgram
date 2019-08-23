package com.weiyigeek;
//import java.util.*  //*通配符会到该包下挨个匹配上就导入,即该包下的所以类都是对我们可见的;
import java.util.Scanner;  //推荐方式(开发中都是导入具体类)
class Package_import {
  public static void main(String[] args)
  {
    System.out.print("[导包学习]\n请输入您的名字:");
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    System.out.println("您的名字是:"+name);
  }
}

