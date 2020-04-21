package top.weiyigeek.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.weiyigeek.main.pagePerson;
import top.weiyigeek.service.pagePersonService;
import top.weiyigeek.service.impl.pagePersonServiceImp;

/**
 * Servlet implementation class pageList
 */
public class pageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.获取显示的页数以及每页显示好多条
			int page = Integer.parseInt(request.getParameter("page"));
			int count = Integer.parseInt(request.getParameter("count"));
			
			
			//2.调用服务类并返回查询到数据包括条数 当前页数 、总页数
			pagePersonService pps = new pagePersonServiceImp();
			pagePerson pp = pps.pageShow(page, count);
			
			//3.将对象存进作用域之中
			request.setAttribute("page", pp);
			
			//4.跳转分页显示页面
			request.getRequestDispatcher("pageShow.jsp").forward(request, response);
			
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
