package top.weiyigeek.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.CookieStore;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import top.weiyigeek.dao.User;
import top.weiyigeek.dao.impl.UserLoginImpl;
import top.weiyigeek.main.LoginBean;
import top.weiyigeek.main.Person;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    request.setCharacterEncoding("UTF-8");
		    //1.���վ���������ת��������
		    Map map = request.getParameterMap();
		    LoginBean lb = new LoginBean();
		    BeanUtils.populate(lb, map);
		    
		    //2.����dao�������ݿ��ѯ
		    User user = new UserLoginImpl();
            Person result = user.userlogin(lb);
            
            //3.�ж��û��Ƿ��¼�ɹ��Լ������ǽ����Զ���½
            if(result != null) {
                if("on".equals(lb.getAutoLogin())) {
                    //����Cookies���ͻ���(ʵ�ʿ�����һ����Ҫ��ô������ȫ��-���Խ�sessionֵ����redis+�ۻ�)
                    Cookie cookie = new Cookie("autoLogin",lb.getUsername()+"-"+lb.getPassword());
                    cookie.setMaxAge(60*60*24*7);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.println("ok");
                }
                
                //4.ͨ��session��������д�ֵ
                request.getSession().setAttribute("login", "true");
                request.getSession().setAttribute("user", result);
                response.sendRedirect("default.jsp");
               
            }else {
                //5.ʧ������ת����½����
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().write("<script> alert('�˺Ż����������!,����֤���½��');location.href='Login.jsp';</script>");
                //request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
