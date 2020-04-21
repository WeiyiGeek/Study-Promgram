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
			//1.��ȡ��ʾ��ҳ���Լ�ÿҳ��ʾ�ö���
			int page = Integer.parseInt(request.getParameter("page"));
			int count = Integer.parseInt(request.getParameter("count"));
			
			
			//2.���÷����ಢ���ز�ѯ�����ݰ������� ��ǰҳ�� ����ҳ��
			pagePersonService pps = new pagePersonServiceImp();
			pagePerson pp = pps.pageShow(page, count);
			
			//3.��������������֮��
			request.setAttribute("page", pp);
			
			//4.��ת��ҳ��ʾҳ��
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
