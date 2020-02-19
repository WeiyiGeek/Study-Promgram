package com.weiyigeek.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/***
 * 
 * @author Administrator
 *   ���ܣ���֤XPATH��ʹ��
 */

public class Dem4j_demo2 {
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			//1.����SAX��ȡ����
			SAXReader reader = new SAXReader();
			
			//2.��ȡxmlԴ�ļ�
			Document document = reader.read(new File("src/xml/index.xml"));
			
		    //3.��Ԫ��
			Element rootElement = document.getRootElement();
			
		    //4.ʹ��xpathѡȡ�����ڵ����
			Element xpathElement = (Element) rootElement.selectSingleNode("//name");
			System.out.println("��ȡһ������Ԫ�ص�ֵ: " + xpathElement.getText());
			
			//5.ʹ��xpath��ȡ�����ͬ�ڵ����Ե�ֵ
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
