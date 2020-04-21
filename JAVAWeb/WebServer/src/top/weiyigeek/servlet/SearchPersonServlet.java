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
			//1.获取参数的编码设置
			request.setCharacterEncoding("utf-8");
			
			//2.获取查询参数并传递给service层进行进一步的调用dao
			String sname = request.getParameter("sname");
			String gender = request.getParameter("sgender");
			PersonService ps = new PersonServiceImpl();
			List<Person> list = ps.searchPerson(sname, gender); //返回一个包含Person对象的List集合
			
			//3.将获取的集合对象放入在作用域属性中
			request.setAttribute("PersonList", list);
			
			//4.跳转页面
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
