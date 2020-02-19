package com.weiyigeek.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/***
 * 
 * @author Administrator
 *   功能：验证XPATH的使用
 */

public class Dem4j_demo2 {
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			//1.创建SAX读取对象
			SAXReader reader = new SAXReader();
			
			//2.读取xml源文件
			Document document = reader.read(new File("src/xml/index.xml"));
			
		    //3.根元素
			Element rootElement = document.getRootElement();
			
		    //4.使用xpath选取单个节点对象
			Element xpathElement = (Element) rootElement.selectSingleNode("//name");
			System.out.println("获取一个子孙元素的值: " + xpathElement.getText());
			
			//5.使用xpath获取多个相同节点属性的值
			List<Element> list = rootElement.selectNodes("//name");
			for(Element xpath : list){
				System.out.println(xpath.getName() + ":" + xpath.getStringValue());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
}
