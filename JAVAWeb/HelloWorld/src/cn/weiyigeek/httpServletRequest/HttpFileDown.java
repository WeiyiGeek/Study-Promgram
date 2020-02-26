package cn.weiyigeek.httpServletRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class HttpFileDown
 */
public class HttpFileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.返回给客户端的文字内容使用的默认编码
		response.setCharacterEncoding("UTF-8");
		
		//2.指定浏览器解析数据的格式和编码
		//response.setHeader("Content-Type", "text/html; charset=UTF-8");
		
		//3.采用字符流进行输出中文不乱码
		String filename = new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8"); //下载文件带中文字符
		//response.getWriter().write("1.字符流（方式）：当前您下载的文件是  " +  filename + "<br/>");
        //String csn = Charset.defaultCharset().name();		//getBytes()默认码表
        //response.getWriter().append("2.getBytes()默认码表:" + csn);

		//4.采用字节流进行指定编码输出中文不乱码（其实getBytes()方法的默认码表就是UTF-8与Tomcat默认码表无关系）
		//response.setContentType("text/html; charset=UTF-8");   //响应内容格式和编码
		
		String path = getServletContext().getRealPath("Config/"+filename);
		String name = "3.字节流（方式）：当前您下载的文件路径是  ："  + path; 
		//response.getOutputStream().write(name.getBytes("UTF-8"));  //注意不能和字符流同时存在；
		//response.getOutputStream().print(name);
		
		//5.设置下载文件的响应头并且如果存在中文名称需要对其进行编码；
		/*
		 * 如果IE或者Chrome使用的URLEncoding编码
		      如果是Firefox使用的是base64编码
		 */
		
		String clientType = request.getHeader("User-Agent");
		//注意大小写，当然为了方便您可以
		if(clientType.contains("Firefox")) 
		{
			filename = base64EncodeFileName(filename);
		} else {
			filename = URLEncoder.encode(filename,"UTF-8");
		}
		response.setHeader("Content-Disposition", "attachment; filename="+filename);	//返回文件中文不乱码


		//6.读取文件到字节流然后进行下载
		InputStream is = new FileInputStream(path); //采用绝对路径进行读取文件
		OutputStream os = response.getOutputStream(); 
		
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = is.read(buf)) != -1)
		{
			//7.写出文件
			os.write(buf, 0, len);
		}
		//8.关闭输入输出流
		os.close();
		is.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?" + new String(base64Encoder.encode(fileName.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}