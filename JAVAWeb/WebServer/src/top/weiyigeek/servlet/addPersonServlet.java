package top.weiyigeek.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.weiyigeek.main.Person;
import top.weiyigeek.service.PersonService;
import top.weiyigeek.service.impl.PersonServiceImpl;

/**
 * Servlet implementation class addPersonServlet
 */
public class addPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("utf-8");
		

		try {
			//��ȡ�յ��Ĳ���
			String sname = request.getParameter("name");
			String gender = request.getParameter("gender");
			String telephone = request.getParameter("telephone");
			String info = request.getParameter("info");
			String jointime = request.getParameter("jointime");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(jointime);
		
			String [] j = request.getParameterValues("job");
			String sj = Arrays.toString(j);
			String job = sj.substring(1, sj.length()-1);
			
			//������װ�ؽ�����
			Person person = new Person(sname,gender,telephone,job,info,date);
			
			PersonService ps = new PersonServiceImpl();
			ps.addPerson(person);
			
			//��ת��ȫ��Ա����Ϣҳ��
			request.getRequestDispatcher("findall").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
