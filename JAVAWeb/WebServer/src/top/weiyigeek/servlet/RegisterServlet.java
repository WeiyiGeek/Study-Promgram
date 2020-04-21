package top.weiyigeek.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import top.weiyigeek.dao.User;
import top.weiyigeek.dao.impl.UserLoginImpl;
import top.weiyigeek.main.registerBean;
import top.weiyigeek.utils.MyDateConverter;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        //1.ע���Լ�������ת����
	        request.setCharacterEncoding("UTF-8");
	        ConvertUtils.register(new MyDateConverter(), Date.class);
	        
	        //2.���������ת��
	        Map map = request.getParameterMap();
	        registerBean bean = new registerBean();
            BeanUtils.populate(bean, map);
            System.out.println(bean.toString());

            //3.����Dao��������
            User uu = new UserLoginImpl();
            int flag = uu.userregister(bean);
            
            //4.����ע�����������ת;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");

            if (flag > 0) {
                response.getWriter().write("<script>alert('ע��ɹ�');window.location.href='./Login.jsp'</script>");
            } else {
                response.getWriter().write("<script>alert('ע��ʧ��');window.location.href='./Register.jsp'</script>");
            }             
        } catch (IllegalAccessException | InvocationTargetException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
