package com.geek.hellowrold;

import java.io.*;
import java.util.Scanner;

public class demo6 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("锟斤拷锟斤拷锟斤拷:锟斤拷锟斤拷|锟斤拷锟斤拷|锟斤拷锟斤拷|薪水");
		String xm = sn.next();
		int nl = sn.nextInt();
		String desc = sn.next();		
		float gz = sn.nextFloat();
		sn.close();
		
		demo7 person = new demo7(xm,nl);
		person.setDesc(desc);
		person.setMoney(gz);
		person.resultPrin();
	}
}
