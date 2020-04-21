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
			//1.���ݿ��ѯ��Ա��Ϣ
			PersonService service = new PersonServiceImpl();
			List<Person> person = service.findAll(); 
			
			//2.�洢���ݵ�����������֮��
			request.setAttribute("PersonList", person);
			
			//3.��ת��ָ��ҳ��
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
