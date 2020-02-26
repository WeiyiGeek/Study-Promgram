package cn.weiyigeek.servlet;
/**
 * 验证ServletContext读取案例
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountTotal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.在ServletContext中获取成功登陆的次数
		int total = (int) getServletContext().getAttribute("total");
		
		//2.打印输出成功的次数
		response.getWriter().append("尊敬的用户您成功登陆 " + total +" 次");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
