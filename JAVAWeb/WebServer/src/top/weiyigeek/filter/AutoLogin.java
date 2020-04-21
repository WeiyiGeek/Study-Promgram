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
		//1.过滤器创建ServletRequest作用域;
	    HttpServletRequest req = (HttpServletRequest) request;
	    Object login = req.getSession().getAttribute("login");
	    Person ps = (Person)req.getSession().getAttribute("user");
	    
	    //2.判断用户session是否有效
	    if (login != null && ps != null) {
	        System.out.println("#用户一已登录并且有效!");
	         //有效则直接放行
	        chain.doFilter(request, response);
	    }else {
	        //3.如果session失效则看Cookies中是否有自动登陆字段;
	        Cookie[] cookies = req.getCookies();
	        Cookie c = CookieUtil.findCookie(cookies, "autoLogin");
	        if( c == null ) {
	            //4.如果没有设置自动登陆则放行
	            System.out.println("#用户未登陆或者未设置身份自动登陆....");
                chain.doFilter(request, response);
	        }else {
	            System.out.println("#Session失效，用户设置自动登陆-正在进行自动登陆!");
	            //5.登陆字符串分隔
	            String loginStr = c.getValue();
	            String username = loginStr.split("-")[0];
	            String password = loginStr.split("-")[1];
	            LoginBean lb = new LoginBean(username,password,"on");
	            System.out.println(lb.toString());
	            
	            //6.完成登陆对象的封装后直接调用Dao接口进行验证
	            User uu = new UserLoginImpl();
	            try {
                    ps = uu.userlogin(lb);
                    //7.使用session存这个值到域中，方便下一次未过期前还可以用。
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
