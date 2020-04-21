package top.weiyigeek.sesssion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.获取JSP页面传递过来的参数
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1.获取用户的Session会话ID
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		response.getWriter().append("<h5>用户当前Session会话ID值 :   " + sessionid + "</h5><br>");
		
		//2.采用Session进行存值
		session.setAttribute("name", name);
		session.setAttribute("pass", pass);
		
		//3.获取Session中获取的值
		session.getAttribute("name");
		session.getAttribute("pass");

		//4.移除值
		session.removeAttribute("name");
		session.removeAttribute("pass");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
