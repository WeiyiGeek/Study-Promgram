package cn.weiyigeek.servlet;
/**
 * ��֤ServletContext��ȡ����
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��¼ҳ�洫�ݵĲ���
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("Get �����ȡ�Ĳ��� ��user = " + user + "?pass = " + pass );
		
		//2.�ж��û������˺������Ƿ���ȷ
		if("admin".equals(user) && "123".equals(pass)) {
			
			//3.��¼�ɹ�����Ӧ���ն˿���̨���д�ӡ
			response.getWriter().append("��¼�ɹ�!");
			
			//4.��¼�ͻ�ȡ��Servlet�д洢��¼�ɹ���ֵ
			int count = 0;
			Object ob = getServletContext().getAttribute("total"); //��ȡServletContext����
			if(ob != null )
			{
				count = (int) ob;
			}
			getServletContext().setAttribute("total", ++count); //���ô洢ServletContext����
			System.out.println("��¼�ɹ�! ���ۻ��ɹ���½ " + count +"��");

			//5.���õ�¼�ɹ���תҳ��
			response.setStatus(302); //����״̬��
			response.setHeader("Location", "success.html"); //������תͷ
		}else {
			response.getWriter().print("��¼ʧ��,�˺Ż����������!");
			System.out.println("�˺Ż����������!");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
