package top.weiyigeek.servlet;

import java.io.IOException;
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
 * @Desc:执行员工信息更新操作servlet入口 
 */
public class updatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实际开发中能代码复用的时候一定要代码复用(减少体积)
		//设置编码
		request.setCharacterEncoding("utf-8");

		try {
			//获取收到的参数（实际开发中一定要过滤）
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("name");
			String gender = request.getParameter("gender");
			String telephone = request.getParameter("telephone");
			String info = request.getParameter("info");
			String jointime = request.getParameter("jointime");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(jointime);
		
			String [] j = request.getParameterValues("job");
			String sj = Arrays.toString(j);
			String job = sj.substring(1, sj.length()-1);
			
			//将数据装载进对象
			Person person = new Person(sid,sname,gender,telephone,job,info,date);
			
			//利用服务层进行修改更新员工修改
			PersonService ps = new PersonServiceImpl();
			ps.updatePerson(person);
			
			//重新跳转到全部员工信息页面
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
