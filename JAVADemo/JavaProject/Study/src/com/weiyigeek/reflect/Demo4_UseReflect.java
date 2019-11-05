package com.weiyigeek.reflect;
import java.io.BufferedReader;
import java.io.FileReader;
import com.weiyi.Collection.Students;
public class Demo4_UseReflect {
	public static void main(String[] args) throws Exception {
		//1.实例1Reflect通用属性
		Students stu = new Students("张三",1024);
		System.out.println("修改前:" + stu);

		Demo3_ReflectTool tool = new Demo3_ReflectTool();
		tool.setProperty(stu,"name","王五");
		System.out.println("修改后:" + stu);
		
		//2.反射练习
		//写一个Properties格式得配置文件，配置类得完整名称;
		//写一个程序读该配置文件获得类得完整名称并几种这个类，用反射得方法运行run
		BufferedReader br = new BufferedReader(new FileReader("config.properties"));  //创建输入流
		Class clazz = Class.forName(br.readLine()); //读取配置文件中类名获取字节码对象
		Demo3_ReflectTool dr = (Demo3_ReflectTool) clazz.newInstance(); //通过字节码创建该对象 (需要强转)
		dr.run(); //即可调用Demo3_UseReflect类中得方法
	}
}
