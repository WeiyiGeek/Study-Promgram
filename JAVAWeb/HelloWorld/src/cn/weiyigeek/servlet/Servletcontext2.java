package cn.weiyigeek.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servletcontext2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getClassLoader());
		
		Properties prop = new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("../../Config/WeiyiGeek.Properties");
		prop.load(is);
		System.out.println("–’√˚:" + prop.getProperty("name") + ",ƒÍ¡‰ : " + prop.getProperty("age") );
		is.close();
	}
}
