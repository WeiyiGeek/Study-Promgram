package cn.weiyigeek.httpServletRequest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpPostInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.POST�������������
		request.setCharacterEncoding("UTF-8");
		
		//3.��ȡ���POST����Ĳ���
		System.out.println("�������ú� ---  name = " + new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8") + "\n----");
		
		//4.��ȡ�ͻ��˵���Ϣ
		System.out.println("��ǰ�ͻ���Э��  ��" + request.getProtocol());
		System.out.println("��ǰ������� ��" + request.getCharacterEncoding());
		System.out.println("��Ŀ���� :" + request.getContextPath());
		System.out.println("��ĿURL:" + request.getRequestURI());
		System.out.println("������Ϣ ��" + request.getLocalName() + " - " + request.getLocalAddr()  + " - " + request.getLocalPort());
		System.out.println("�ͻ�����Ϣ : " + request.getRemoteUser() + " - " + request.getRemoteAddr() + " - " + request.getRemoteHost() + " - " + request.getRemotePort());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.POST �������
		System.out.println("POST ����.....");
		System.out.println("��������ǰ ---  name = " + request.getParameter("name"));
		doGet(request, response);
	}
}
