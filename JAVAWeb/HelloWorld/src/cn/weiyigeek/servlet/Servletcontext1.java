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
		
		//方式1:ServletContext获取资源文件
		Scmethod1(response);

		//方式2:ServletContext + Propersties 获取资源文件
		Scmethod2(response);
		
		
		//方式3:ServletContext资源文件获取
		ServletContext sc = getServletContext();
		Properties prop = new Properties();
		//给相对路径然后直接获取文件绝对地址和读取文件转化成为流对象
		InputStream is = sc.getResourceAsStream("Config/WeiyiGeek.Properties"); 
		prop.load(is);
		System.out.println("\n方式三:ServletContext资源文件获取\n");
		System.out.println("Name = " + prop.getProperty("name") + "\n");
		System.out.println("Age = " + prop.getProperty("age"));
	}

	
	//方式2
	public void Scmethod2(HttpServletResponse response) throws FileNotFoundException, IOException {
		//1.获取上下文对象
		ServletContext context = getServletContext();
		//2.或者Properties中的参数值采用ServletContext进行读取
		Properties prop = new Properties();
		String proppath = context.getRealPath("Config/WeiyiGeek.Properties"); //获取到了WeiyiGeek.Properties绝对路径
		System.out.println("Properties 配置文件路径 = " + proppath);
		//Properties 配置文件路径 = D:\apache-tomcat-7.0.100\wtpwebapps\HelloWorld\Config\WeiyiGeek.Properties

		//3.指定properties数据源(但是需要注意这里是web应用，如果想获取web工程的下资源需要采用ServletContext获取配置文件路径)
		InputStream is = new FileInputStream(proppath);
		prop.load(is);
		
		//4.获取属性的值
		String name = prop.getProperty("name");
		String age = prop.getProperty("age");
		response.getWriter().append("\n ------------------ \n");
		response.getWriter().append("ServletContext-> Properties Param Name = ").append(name  + "\n");
		response.getWriter().append("ServletContext-> Properties Param Age = ").append(age);
	}
	
	//方式1
	public void Scmethod1(HttpServletResponse response) throws IOException {
		//1.获取上下文对象
		ServletContext context = getServletContext();
		
		//2.获取web.xml中Context-param中设置全局配置参数的key和value;
		response.getWriter().append("ServletContext Param Name = ").append(context.getInitParameter("name") + "\n");
		response.getWriter().append("ServletContext Param Age = ").append(context.getInitParameter("age"));
	}
}
