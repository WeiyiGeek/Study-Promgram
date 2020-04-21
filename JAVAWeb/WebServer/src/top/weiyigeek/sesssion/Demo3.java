package top.weiyigeek.sesssion;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.获取JSP页面传递过来的参数
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String action = request.getParameter("action");
		String product = request.getParameter("id");
		String[] productname = {"安全数据", "安全开发运维", "DevOps","大型分布式网站架构" , "安全威胁分析"};
		
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
	
		if (name != null && pass != null ) {
			if("admin".equals(name) && "123456".equals(pass)) {
				//1.获取当前用户的Session会话值
				String sessionid = request.getSession().getId();
				response.getWriter().append("<br>用户登陆成功 <br>").append("当前 Session 会话值 : " + sessionid);
				
				//2.设置登陆会话属性
				request.getSession().setAttribute("login", "yes");
				response.getWriter().append("<br><a style='color:red' href='index.jsp'>浏览商品</p>");
				
			} else {
				response.getWriter().append("<p style='color:red'>账号或密码错误!</p>");
			}
		}
		
		//4.获取购物车存储的Session值
		
		if (product !=  null ) {
			int id = Integer.parseInt(product);
			String idname = productname[id-1];
			Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		
			 //首次
			if(map == null) {
				//存入Map对象到Session
				map = new LinkedHashMap<String, Integer>();
				request.getSession().setAttribute("cart", map);
			}
		
			//判断是否存在该商品
			if(map.containsKey(idname)) {
				map.put(idname,map.get(idname)+1);
			}else {
				map.put(idname,1);
			}
			
			//界面跳转
			response.getWriter().append("<br><b>添加到购物车成功!</b>");
			response.getWriter().append("<p><a href='index.jsp'>返回商品页</a></p>");
			response.getWriter().append("<p><a href='index.jsp?#cart'>我的购物车</a></p>");

		}
		
		//7.清空购物车即session值与会话清除
		if ("del".equals(action)) {
			HttpSession session = request.getSession();
			session.removeAttribute("cart");
			response.sendRedirect("index.jsp");
		} else if ("logout".equals(action)) {
			//Session 会话清除
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
