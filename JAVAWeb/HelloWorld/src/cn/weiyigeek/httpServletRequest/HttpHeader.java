package cn.weiyigeek.httpServletRequest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.采用网页进行回显
		request.setCharacterEncoding("utf-8");  //输入的格式不乱码
		
		response.setContentType("text/html");   //输出格式
        response.setCharacterEncoding("utf-8"); //输出不乱码
        
		//1.枚举集合
		response.getWriter().append("------- 请求头获取  ------- <br/>");
		Enumeration<String> headers = request.getHeaderNames();
		
		//2.循环迭代请求头
		while(headers.hasMoreElements())
		{
			String reqname = headers.nextElement();
			String reqvalue = request.getHeader(reqname);
			//3.向网页中进行输出
			response.getWriter().append(reqname + ":" + reqvalue + "<br/>");
		}
		
		response.getWriter().append("<br/> ------- 获取多个参数 ------- <br/>");
		//4.方式1：获取多个请求参数(值得学习)
		Map<String, String[]> map= request.getParameterMap(); //map 集合
		Set<String> keySet = map.keySet();  //Set 集合
		Iterator<String> iterator = keySet.iterator(); //迭代器
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			String[] value = map.get(key);  //默认以首次出现的参数名称为准
			
			//5.验证存在多个相同的参数
			if(value.length > 1){
				for (int i = 0; i < value.length; i++) {
					String val = new String(value[i].getBytes("ISO-8859-1"),"utf-8"); // 防止输入输出的中文乱码(终端)
					response.getWriter().append(key+ ":" + val + "<br/>");
				}
			}else {
				response.getWriter().append(key+ ":" + value[0] + "<br/>");
			}
		}
		
		//6.方式2：获取请求的参数(中文输出不乱码)
  	    Enumeration<String> para = request.getParameterNames();
  	    while(para.hasMoreElements())
  	    {
  	    	String paraname = para.nextElement();
  	    	String[] value = request.getParameterValues(paraname);
  	    	if(value.length > 1) {
  	    		for (int j = 0; j < value.length; j++) {
  	  				String val = new String(value[j].getBytes("ISO-8859-1"),"utf-8"); // 防止输入输出的中文乱码(终端)
  	  	    		System.out.println(paraname +  " = " + val);
				}

  	    	}else {
  	    		 System.out.println(paraname +  " = " + value[0] + "\n");

  	    	}
  	    }		
	}
}
