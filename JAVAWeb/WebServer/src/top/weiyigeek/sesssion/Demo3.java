package top.weiyigeek.sesssion;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.��ȡJSPҳ�洫�ݹ����Ĳ���
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String action = request.getParameter("action");
		String product = request.getParameter("id");
		String[] productname = {"��ȫ����", "��ȫ������ά", "DevOps","���ͷֲ�ʽ��վ�ܹ�" , "��ȫ��в����"};
		
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
	
		if (name != null && pass != null ) {
			if("admin".equals(name) && "123456".equals(pass)) {
				//1.��ȡ��ǰ�û���Session�Ựֵ
				String sessionid = request.getSession().getId();
				response.getWriter().append("<br>�û���½�ɹ� <br>").append("��ǰ Session �Ựֵ : " + sessionid);
				
				//2.���õ�½�Ự����
				request.getSession().setAttribute("login", "yes");
				response.getWriter().append("<br><a style='color:red' href='index.jsp'>�����Ʒ</p>");
				
			} else {
				response.getWriter().append("<p style='color:red'>�˺Ż��������!</p>");
			}
		}
		
		//4.��ȡ���ﳵ�洢��Sessionֵ
		
		if (product !=  null ) {
			int id = Integer.parseInt(product);
			String idname = productname[id-1];
			Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		
			 //�״�
			if(map == null) {
				//����Map����Session
				map = new LinkedHashMap<String, Integer>();
				request.getSession().setAttribute("cart", map);
			}
		
			//�ж��Ƿ���ڸ���Ʒ
			if(map.containsKey(idname)) {
				map.put(idname,map.get(idname)+1);
			}else {
				map.put(idname,1);
			}
			
			//������ת
			response.getWriter().append("<br><b>��ӵ����ﳵ�ɹ�!</b>");
			response.getWriter().append("<p><a href='index.jsp'>������Ʒҳ</a></p>");
			response.getWriter().append("<p><a href='index.jsp?#cart'>�ҵĹ��ﳵ</a></p>");

		}
		
		//7.��չ��ﳵ��sessionֵ��Ự���
		if ("del".equals(action)) {
			HttpSession session = request.getSession();
			session.removeAttribute("cart");
			response.sendRedirect("index.jsp");
		} else if ("logout".equals(action)) {
			//Session �Ự���
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
