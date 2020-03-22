package top.weiyigeek.Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.weiyigeek.Dao.UserDao;
import top.weiyigeek.Dao.impl.User;
import top.weiyigeek.entity.UserInfo;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "用户登录", urlPatterns = { "/Login" })
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		UserDao dao = new User();
		try {
			boolean status = dao.loginVerity(user, pass);
			if(status){
				request.getSession().setAttribute("login", "ok");
				response.getWriter().write("<br> 登录成功!");
				
				//查询所用人员的信息
				List<UserInfo> list = dao.infoQuery();
				
				//将数据存储进session之中
				request.getSession().setAttribute("list", list);;
				
				//执行跳转页面
				response.sendRedirect("listinfo.jsp");
			}else {
				response.getWriter().write("<br> 登录失败!");
			}
		} catch (Exception e) {
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
