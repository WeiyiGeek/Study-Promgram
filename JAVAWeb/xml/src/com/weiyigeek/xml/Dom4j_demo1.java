package com.weiyigeek.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/***
 * 
 * @author Administrator
 *   功能:验证Dom4j解析XML包
 */

public class Dom4j_demo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.建立reader读取对象
		SAXReader reader = new SAXReader();
		try {
			//2.读取指定的xml源文件
			Document document = reader.read(new File("src/xml/index.xml"));
			System.out.println("读取XML源文件地址: " + document.getName());
		
			//3.获取xml中根元素
			Element rootElement = document.getRootElement();
			System.out.println("根元素名称: " + rootElement.getName());
			
			//4.得到子元素和子子（子孙）元素
			System.out.println("子元素名称" + rootElement.element("stu").getName());
			System.out.println("子子元素名称: " + rootElement.element("stu").element("name").getName());
			
			//5.获取所有元素及其属性
			List<Element> element = rootElement.elements();
			for (Element ele : element) {
				String name = ele.element("name").getStringValue();
				String age = ele.element("age").getText();
				String addr = ele.elementText("address");
				System.out.println(ele.attributeValue("id")+ "：" + name + "-" + age + "-" + addr);
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
