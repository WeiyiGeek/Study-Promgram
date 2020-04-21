package top.weiyigeek.cookies;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ���� Cookies ��֤
 */
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//1.���ݻ���
		response.getWriter().append("Served at: ").append(request.getContextPath()+"<br/>");
		String name = request.getParameter("name");
		String value =request.getParameter("value");
		
		//2.����Cookies����Ч��Ĭ����7��
		Cookie xm = new Cookie(name, value);
		xm.setMaxAge(60 * 60); // ʧЧʱ�� 1��Сʱ
		response.addCookie(xm);
		System.out.println("���õ�Cookie1: " + name + " = " + value);
		
		//3.����Cookies����Ч�ں�HTTPOnly
		Cookie age = new Cookie("age", "18");
		age.setHttpOnly(true);
		age.setPath("/");
		age.setDomain("127.0.0.1");     //ֻ����127.0.0.1�������Ч�����������������磩
		age.setMaxAge(60 * 60 * 24 * 7); //��λ�룬��ֵʱ����ڣ���ֵʱ��ر��������ʧЧ;
		age.setValue("2020");
		response.addCookie(age);
		System.out.println("���õ�Cookie2: " + age.getName() + " = " + age.getValue());

		//3.��ȡ�����Cookies
		Cookie[] cook = request.getCookies();
		//��ֹ���ֿ�ָ��
		if(cook != null)
		{
			for (Cookie cookie : cook) {
				String cn = cookie.getName();
				String cv = cookie.getValue();
				response.getWriter().append(cn + " ��" + cv + "<br>");
			}
		}
	
		//4.��ʾ������ʵ�ʱ����ʲôʱ��;
		if("name".equals(name) && "WeiyiGeek".equals(value))
		{
			System.out.println("�û���½�ɹ�:"+ name);
			Cookie lastTime = until(cook,"lasttime"); //���ù�������в���
			//�ж��û��Ƿ��ײ��½��
			if(lastTime == null)
			{
				Cookie currentTime = new Cookie("lasttime",new Date().getTime()+"");
				currentTime.setMaxAge(60*60);
				response.addCookie(currentTime);
			}else {
				long lastVisitTime = Long.parseLong(lastTime.getValue()); //����
				response.getWriter().append("<b>��ǰ�û������½ʱ��:</b>"+new Date(lastVisitTime));
				//�����û���½��ʱ��
				lastTime.setValue(new Date().getTime()+"");
				response.addCookie(lastTime);  //�޸ĺ�������Ӧ�ύ
			}
		}
	}

	//5.�����ࣺ����
	private Cookie until(Cookie[] userCook,String flag) {
	  if(userCook != null) {
			for(Cookie ucook: userCook){
				if(flag.equals(ucook.getName())){
					return ucook;
				}
			}
		}
	  return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
