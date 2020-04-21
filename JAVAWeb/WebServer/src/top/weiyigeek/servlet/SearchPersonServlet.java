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
 * Servlet implementation class SearchPersonServlet
 */
public class SearchPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.��ȡ�����ı�������
			request.setCharacterEncoding("utf-8");
			
			//2.��ȡ��ѯ���������ݸ�service����н�һ���ĵ���dao
			String sname = request.getParameter("sname");
			String gender = request.getParameter("sgender");
			PersonService ps = new PersonServiceImpl();
			List<Person> list = ps.searchPerson(sname, gender); //����һ������Person�����List����
			
			//3.����ȡ�ļ��϶��������������������
			request.setAttribute("PersonList", list);
			
			//4.��תҳ��
			request.getRequestDispatcher("findlist.jsp").forward(request, response);;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
