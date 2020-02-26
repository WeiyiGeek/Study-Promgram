package cn.weiyigeek.servlet;
/**
 * 验证ServletContext存取案例
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取登录页面传递的参数
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("Get 请求获取的参数 ：user = " + user + "?pass = " + pass );
		
		//2.判断用户输入账号密码是否正确
		if("admin".equals(user) && "123".equals(pass)) {
			
			//3.登录成功在响应和终端控制台进行打印
			response.getWriter().append("登录成功!");
			
			//4.记录和获取在Servlet中存储登录成功的值
			int count = 0;
			Object ob = getServletContext().getAttribute("total"); //获取ServletContext属性
			if(ob != null )
			{
				count = (int) ob;
			}
			getServletContext().setAttribute("total", ++count); //设置存储ServletContext属性
			System.out.println("登录成功! 您累积成功登陆 " + count +"次");

			//5.设置登录成功跳转页面
			response.setStatus(302); //设置状态码
			response.setHeader("Location", "success.html"); //设置跳转头
		}else {
			response.getWriter().print("登录失败,账号或者密码错误!");
			System.out.println("账号或者密码错误!");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
