package cn.weiyigeek.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Administrator
 * Descript: 验证ServletConfig的使用获取web.xml配置的信息
 */
public class SevletConfig extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获得Servlet配置对象专门用于配置servlet的信息
		ServletConfig config = getServletConfig();
		
		//2.可以获取具体servlet配置中的名称;
		String servletName = config.getServletName();
		System.out.println("Servlet-Name = " + servletName);
		
		//3.检测参数是否存在被设置进行非法参数异常抛出(值得学习 illeal 英 /ɪˈliːɡl/ )
		String myself = config.getInitParameter("WeiyiGeek");
		if(myself == null) {
			throw new IllegalArgumentException("在Servlet配置中未找到WeiyiGeek参数，请核验Web.xml文件!");
		} else {
			System.out.println("WeiyiGeek load ....");
		}
		
		//4.获取单个具体参数
		String name = config.getInitParameter("name");
		System.out.println("配置文件中  name 值为" + name);
		
		//5.遍历配置中设置的多个参数
		Enumeration<String> para = config.getInitParameterNames();
		while(para.hasMoreElements()) {
			String key = para.nextElement();
			String value = config.getInitParameter(key);
			System.out.println("参数"+key+",值="+value);
		}
	}
}
