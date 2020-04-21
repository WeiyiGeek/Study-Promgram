package top.weiyigeek.servlet;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.weiyigeek.main.Person;
import top.weiyigeek.service.PersonService;
import top.weiyigeek.service.impl.PersonServiceImpl;

/**
 * Servlet implementation class editPersonServlet
 */
public class editPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡҪ�������ϵ�sid
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		try {
			//2.����id��ȡ�������Ϣ�����������person(ע�����ﲻ��List����)
			PersonService ps = new PersonServiceImpl();
			Person person  = ps.getInfoById(sid);
			
			//3.�����ݴ��������������������֮�в�������ת��edit.jspȡֵ
			request.setAttribute("person", person);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
