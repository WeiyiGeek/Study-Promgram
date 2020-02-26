package cn.weiyigeek.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servletcontext1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ʽ1:ServletContext��ȡ��Դ�ļ�
		Scmethod1(response);

		//��ʽ2:ServletContext + Propersties ��ȡ��Դ�ļ�
		Scmethod2(response);
		
		
		//��ʽ3:ServletContext��Դ�ļ���ȡ
		ServletContext sc = getServletContext();
		Properties prop = new Properties();
		//�����·��Ȼ��ֱ�ӻ�ȡ�ļ����Ե�ַ�Ͷ�ȡ�ļ�ת����Ϊ������
		InputStream is = sc.getResourceAsStream("Config/WeiyiGeek.Properties"); 
		prop.load(is);
		System.out.println("\n��ʽ��:ServletContext��Դ�ļ���ȡ\n");
		System.out.println("Name = " + prop.getProperty("name") + "\n");
		System.out.println("Age = " + prop.getProperty("age"));
	}

	
	//��ʽ2
	public void Scmethod2(HttpServletResponse response) throws FileNotFoundException, IOException {
		//1.��ȡ�����Ķ���
		ServletContext context = getServletContext();
		//2.����Properties�еĲ���ֵ����ServletContext���ж�ȡ
		Properties prop = new Properties();
		String proppath = context.getRealPath("Config/WeiyiGeek.Properties"); //��ȡ����WeiyiGeek.Properties����·��
		System.out.println("Properties �����ļ�·�� = " + proppath);
		//Properties �����ļ�·�� = D:\apache-tomcat-7.0.100\wtpwebapps\HelloWorld\Config\WeiyiGeek.Properties

		//3.ָ��properties����Դ(������Ҫע��������webӦ�ã�������ȡweb���̵�����Դ��Ҫ����ServletContext��ȡ�����ļ�·��)
		InputStream is = new FileInputStream(proppath);
		prop.load(is);
		
		//4.��ȡ���Ե�ֵ
		String name = prop.getProperty("name");
		String age = prop.getProperty("age");
		response.getWriter().append("\n ------------------ \n");
		response.getWriter().append("ServletContext-> Properties Param Name = ").append(name  + "\n");
		response.getWriter().append("ServletContext-> Properties Param Age = ").append(age);
	}
	
	//��ʽ1
	public void Scmethod1(HttpServletResponse response) throws IOException {
		//1.��ȡ�����Ķ���
		ServletContext context = getServletContext();
		
		//2.��ȡweb.xml��Context-param������ȫ�����ò�����key��value;
		response.getWriter().append("ServletContext Param Name = ").append(context.getInitParameter("name") + "\n");
		response.getWriter().append("ServletContext Param Age = ").append(context.getInitParameter("age"));
	}
}
