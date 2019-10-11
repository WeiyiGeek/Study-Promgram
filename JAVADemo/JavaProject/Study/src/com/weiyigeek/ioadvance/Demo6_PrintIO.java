package com.weiyigeek.ioadvance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Demo6_PrintIO {

	public static void main(String[] args) throws IOException {
		// 示例1：打印流只操作数据目的
		// (1)打印字节流数据
		PrintStream ps = System.out;
		ps.write(97);   //输出的是字符a
		ps.println();
		ps.println(97);	 //其实底层用的是Integer.toString(x),将x转换为数字字符串打印
		ps.println("aaa");
		ps.println(new Personer("张三", 23));  //直接打印对象(实际调用了对象的toString方法)
		Personer p = null;
		ps.println(p);	//如果是null就返回null,如果不是null就调用对象的toString()

		// (2)打印字符流数据
		PrintWriter pw = new PrintWriter(new FileOutputStream("d:\\PrintWrite.txt"), true);
		pw.write(97);
		pw.print("大家好");               
		pw.println("你好"); //自动刷出,只针对的是println方法(但是缓冲区已经存在的数据会一起刷出)
		pw.close();
	}

}

//执行结果
//a
//97
//aaa
//Personer [name=张三, age=23]
//null
//d:\\PrintWrite.txt内容
//a大家好你好

