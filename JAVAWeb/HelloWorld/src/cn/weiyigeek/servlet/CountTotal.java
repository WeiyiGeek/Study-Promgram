package cn.weiyigeek.servlet;
/**
 * ��֤ServletContext��ȡ����
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountTotal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ServletContext�л�ȡ�ɹ���½�Ĵ���
		int total = (int) getServletContext().getAttribute("total");
		
		//2.��ӡ����ɹ��Ĵ���
		response.getWriter().append("�𾴵��û����ɹ���½ " + total +" ��");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
