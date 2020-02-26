package cn.weiyigeek.httpServletRequest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpPostInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.POST请求输出不乱码
		request.setCharacterEncoding("UTF-8");
		
		//3.获取输出POST请求的参数
		System.out.println("编码设置后 ---  name = " + new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8") + "\n----");
		
		//4.获取客户端的信息
		System.out.println("当前客户端协议  ：" + request.getProtocol());
		System.out.println("当前请求编码 ：" + request.getCharacterEncoding());
		System.out.println("项目名称 :" + request.getContextPath());
		System.out.println("项目URL:" + request.getRequestURI());
		System.out.println("本机信息 ：" + request.getLocalName() + " - " + request.getLocalAddr()  + " - " + request.getLocalPort());
		System.out.println("客户端信息 : " + request.getRemoteUser() + " - " + request.getRemoteAddr() + " - " + request.getRemoteHost() + " - " + request.getRemotePort());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.POST 请求入口
		System.out.println("POST 请求.....");
		System.out.println("编码设置前 ---  name = " + request.getParameter("name"));
		doGet(request, response);
	}
}
