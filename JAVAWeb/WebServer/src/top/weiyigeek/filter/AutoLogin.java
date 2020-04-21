package top.weiyigeek.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import top.weiyigeek.dao.User;
import top.weiyigeek.dao.impl.UserLoginImpl;
import top.weiyigeek.main.LoginBean;
import top.weiyigeek.main.Person;
import top.weiyigeek.utils.CookieUtil;

/**
 * Servlet Filter implementation class AutoLogin
 */
public class AutoLogin implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1.����������ServletRequest������;
	    HttpServletRequest req = (HttpServletRequest) request;
	    Object login = req.getSession().getAttribute("login");
	    Person ps = (Person)req.getSession().getAttribute("user");
	    
	    //2.�ж��û�session�Ƿ���Ч
	    if (login != null && ps != null) {
	        System.out.println("#�û�һ�ѵ�¼������Ч!");
	         //��Ч��ֱ�ӷ���
	        chain.doFilter(request, response);
	    }else {
	        //3.���sessionʧЧ��Cookies���Ƿ����Զ���½�ֶ�;
	        Cookie[] cookies = req.getCookies();
	        Cookie c = CookieUtil.findCookie(cookies, "autoLogin");
	        if( c == null ) {
	            //4.���û�������Զ���½�����
	            System.out.println("#�û�δ��½����δ��������Զ���½....");
                chain.doFilter(request, response);
	        }else {
	            System.out.println("#SessionʧЧ���û������Զ���½-���ڽ����Զ���½!");
	            //5.��½�ַ����ָ�
	            String loginStr = c.getValue();
	            String username = loginStr.split("-")[0];
	            String password = loginStr.split("-")[1];
	            LoginBean lb = new LoginBean(username,password,"on");
	            System.out.println(lb.toString());
	            
	            //6.��ɵ�½����ķ�װ��ֱ�ӵ���Dao�ӿڽ�����֤
	            User uu = new UserLoginImpl();
	            try {
                    ps = uu.userlogin(lb);
                    //7.ʹ��session�����ֵ�����У�������һ��δ����ǰ�������á�
                    req.getSession().setAttribute("user", ps);
                    chain.doFilter(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    request.getRequestDispatcher("Login.jsp").forward(request, response);;
                } 
	        } 
	    } 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
