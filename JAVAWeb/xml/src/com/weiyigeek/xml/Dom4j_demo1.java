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
 *   ����:��֤Dom4j����XML��
 */

public class Dom4j_demo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.����reader��ȡ����
		SAXReader reader = new SAXReader();
		try {
			//2.��ȡָ����xmlԴ�ļ�
			Document document = reader.read(new File("src/xml/index.xml"));
			System.out.println("��ȡXMLԴ�ļ���ַ: " + document.getName());
		
			//3.��ȡxml�и�Ԫ��
			Element rootElement = document.getRootElement();
			System.out.println("��Ԫ������: " + rootElement.getName());
			
			//4.�õ���Ԫ�غ����ӣ����Ԫ��
			System.out.println("��Ԫ������" + rootElement.element("stu").getName());
			System.out.println("����Ԫ������: " + rootElement.element("stu").element("name").getName());
			
			//5.��ȡ����Ԫ�ؼ�������
			List<Element> element = rootElement.elements();
			for (Element ele : element) {
				String name = ele.element("name").getStringValue();
				String age = ele.element("age").getText();
				String addr = ele.elementText("address");
				System.out.println(ele.attributeValue("id")+ "��" + name + "-" + age + "-" + addr);
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
