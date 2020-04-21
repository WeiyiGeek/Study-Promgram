package top.weiyigeek.cookies;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 设置 Cookies 验证
 */
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//1.内容回显
		response.getWriter().append("Served at: ").append(request.getContextPath()+"<br/>");
		String name = request.getParameter("name");
		String value =request.getParameter("value");
		
		//2.设置Cookies和有效期默认是7天
		Cookie xm = new Cookie(name, value);
		xm.setMaxAge(60 * 60); // 失效时间 1个小时
		response.addCookie(xm);
		System.out.println("设置的Cookie1: " + name + " = " + value);
		
		//3.设置Cookies的有效期和HTTPOnly
		Cookie age = new Cookie("age", "18");
		age.setHttpOnly(true);
		age.setPath("/");
		age.setDomain("127.0.0.1");     //只有在127.0.0.1该域才生效（可以区分内外网络）
		age.setMaxAge(60 * 60 * 24 * 7); //单位秒，正值时间过期，负值时间关闭浏览器即失效;
		age.setValue("2020");
		response.addCookie(age);
		System.out.println("设置的Cookie2: " + age.getName() + " = " + age.getValue());

		//3.获取请求的Cookies
		Cookie[] cook = request.getCookies();
		//防止出现空指针
		if(cook != null)
		{
			for (Cookie cookie : cook) {
				String cn = cookie.getName();
				String cv = cookie.getValue();
				response.getWriter().append(cn + " ：" + cv + "<br>");
			}
		}
	
		//4.显示最近访问的时间是什么时候;
		if("name".equals(name) && "WeiyiGeek".equals(value))
		{
			System.out.println("用户登陆成功:"+ name);
			Cookie lastTime = until(cook,"lasttime"); //调用工具类进行查找
			//判断用户是否首测登陆过
			if(lastTime == null)
			{
				Cookie currentTime = new Cookie("lasttime",new Date().getTime()+"");
				currentTime.setMaxAge(60*60);
				response.addCookie(currentTime);
			}else {
				long lastVisitTime = Long.parseLong(lastTime.getValue()); //解析
				response.getWriter().append("<b>当前用户最近登陆时间:</b>"+new Date(lastVisitTime));
				//重置用户登陆的时间
				lastTime.setValue(new Date().getTime()+"");
				response.addCookie(lastTime);  //修改后重新响应提交
			}
		}
	}

	//5.工具类：搜素
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
