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
		//0.��ȡJSPҳ�洫�ݹ����Ĳ���
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1.��ȡ�û���Session�ỰID
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		response.getWriter().append("<h5>�û���ǰSession�ỰIDֵ :   " + sessionid + "</h5><br>");
		
		//2.����Session���д�ֵ
		session.setAttribute("name", name);
		session.setAttribute("pass", pass);
		
		//3.��ȡSession�л�ȡ��ֵ
		session.getAttribute("name");
		session.getAttribute("pass");

		//4.�Ƴ�ֵ
		session.removeAttribute("name");
		session.removeAttribute("pass");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
