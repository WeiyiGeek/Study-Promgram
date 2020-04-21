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
		//1.获取要更新资料的sid
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		try {
			//2.根据id获取其个人信息并返还对象给person(注意这里不是List集合)
			PersonService ps = new PersonServiceImpl();
			Person person  = ps.getInfoById(sid);
			
			//3.将数据存入内置作用域对象属性之中并进行跳转到edit.jsp取值
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
