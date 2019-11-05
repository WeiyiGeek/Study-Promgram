package com.weiyigeek.reflect;
import java.lang.reflect.Field;
public class Demo3_ReflectTool {
	//1.通过反射写一个通用类来进行修改某个属性值(实际把前面所学做一个总结)
	public Demo3_ReflectTool() {};
	public void setProperty(Object obj, String propertyName, Object value) throws Exception {
		Class clazz = obj.getClass(); //获取字节码对象
		Field f = clazz.getDeclaredField(propertyName); //或者对象中私有成员变量
		f.setAccessible(true);   //去除私有成员变量权限
		f.set(obj, value); //设置改成员变量得值
	}
	public void run() {
		System.out.println("Welcome to China");
	}
}
