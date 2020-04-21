package top.weiyigeek.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.weiyigeek.dao.UserDao;
import top.weiyigeek.service.UserService;
import top.weiyigeek.service.impl.UserServiceImpl;

/**
 * Servlet implementation class CheckUserServlet
 */
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    //1.���ñ��벢��ȡ�����ֵ
		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("application/json; charset=utf-8");
		    String name = request.getParameter("checkuser");
		    
		    //2.����Service���еķ�������ʵ����֤
		    UserService service = new UserServiceImpl();
            int res = service.checkUser(name);
            System.out.println(name+ " = " + res);
         
            //3.��������
            if (res == 0 ) {
                //(1)�ı�����
                //response.getWriter().println(1);
                
                //(2)json����
                response.getWriter().write("{ \"status\": true }");
            }else {
                response.getWriter().write("{ \"status\": false }");
            }
            
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
