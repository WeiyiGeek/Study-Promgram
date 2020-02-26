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
		//1.���ظ��ͻ��˵���������ʹ�õ�Ĭ�ϱ���
		response.setCharacterEncoding("UTF-8");
		
		//2.ָ��������������ݵĸ�ʽ�ͱ���
		//response.setHeader("Content-Type", "text/html; charset=UTF-8");
		
		//3.�����ַ�������������Ĳ�����
		String filename = new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8"); //�����ļ��������ַ�
		//response.getWriter().write("1.�ַ�������ʽ������ǰ�����ص��ļ���  " +  filename + "<br/>");
        //String csn = Charset.defaultCharset().name();		//getBytes()Ĭ�����
        //response.getWriter().append("2.getBytes()Ĭ�����:" + csn);

		//4.�����ֽ�������ָ������������Ĳ����루��ʵgetBytes()������Ĭ��������UTF-8��TomcatĬ������޹�ϵ��
		//response.setContentType("text/html; charset=UTF-8");   //��Ӧ���ݸ�ʽ�ͱ���
		
		String path = getServletContext().getRealPath("Config/"+filename);
		String name = "3.�ֽ�������ʽ������ǰ�����ص��ļ�·����  ��"  + path; 
		//response.getOutputStream().write(name.getBytes("UTF-8"));  //ע�ⲻ�ܺ��ַ���ͬʱ���ڣ�
		//response.getOutputStream().print(name);
		
		//5.���������ļ�����Ӧͷ���������������������Ҫ������б��룻
		/*
		 * ���IE����Chromeʹ�õ�URLEncoding����
		      �����Firefoxʹ�õ���base64����
		 */
		
		String clientType = request.getHeader("User-Agent");
		//ע���Сд����ȻΪ�˷���������
		if(clientType.contains("Firefox")) 
		{
			filename = base64EncodeFileName(filename);
		} else {
			filename = URLEncoder.encode(filename,"UTF-8");
		}
		response.setHeader("Content-Disposition", "attachment; filename="+filename);	//�����ļ����Ĳ�����


		//6.��ȡ�ļ����ֽ���Ȼ���������
		InputStream is = new FileInputStream(path); //���þ���·�����ж�ȡ�ļ�
		OutputStream os = response.getOutputStream(); 
		
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = is.read(buf)) != -1)
		{
			//7.д���ļ�
			os.write(buf, 0, len);
		}
		//8.�ر����������
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