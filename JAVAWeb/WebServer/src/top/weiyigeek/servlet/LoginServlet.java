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
		    //1.接收经过过滤器转发的数据
		    Map map = request.getParameterMap();
		    LoginBean lb = new LoginBean();
		    BeanUtils.populate(lb, map);
		    
		    //2.调用dao进行数据库查询
		    User user = new UserLoginImpl();
            Person result = user.userlogin(lb);
            
            //3.判断用户是否登录成功以及后面是进行自动登陆
            if(result != null) {
                if("on".equals(lb.getAutoLogin())) {
                    //发送Cookies给客户端(实际开发中一定不要这么做不安全的-可以将session值传入redis+钝化)
                    Cookie cookie = new Cookie("autoLogin",lb.getUsername()+"-"+lb.getPassword());
                    cookie.setMaxAge(60*60*24*7);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.println("ok");
                }
                
                //4.通过session作用域进行传值
                request.getSession().setAttribute("login", "true");
                request.getSession().setAttribute("user", result);
                response.sendRedirect("default.jsp");
               
            }else {
                //5.失败则跳转到登陆界面
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().write("<script> alert('账号或者密码错误!,请验证后登陆！');location.href='Login.jsp';</script>");
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
