package top.weiyigeek.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.weiyigeek.main.Person;
import top.weiyigeek.service.PersonService;
import top.weiyigeek.service.impl.PersonServiceImpl;

/**
 * Servlet implementation class Findall
 */
public class findall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.数据库查询人员信息
			PersonService service = new PersonServiceImpl();
			List<Person> person = service.findAll(); 
			
			//2.存储数据到作用域属性之中
			request.setAttribute("PersonList", person);
			
			//3.跳转到指定页面
			request.getRequestDispatcher("findlist.jsp").forward(request, response);
		}catch ( SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
