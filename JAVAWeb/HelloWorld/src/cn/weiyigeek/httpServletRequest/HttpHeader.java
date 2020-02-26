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
        //0.������ҳ���л���
		request.setCharacterEncoding("utf-8");  //����ĸ�ʽ������
		
		response.setContentType("text/html");   //�����ʽ
        response.setCharacterEncoding("utf-8"); //���������
        
		//1.ö�ټ���
		response.getWriter().append("------- ����ͷ��ȡ  ------- <br/>");
		Enumeration<String> headers = request.getHeaderNames();
		
		//2.ѭ����������ͷ
		while(headers.hasMoreElements())
		{
			String reqname = headers.nextElement();
			String reqvalue = request.getHeader(reqname);
			//3.����ҳ�н������
			response.getWriter().append(reqname + ":" + reqvalue + "<br/>");
		}
		
		response.getWriter().append("<br/> ------- ��ȡ������� ------- <br/>");
		//4.��ʽ1����ȡ����������(ֵ��ѧϰ)
		Map<String, String[]> map= request.getParameterMap(); //map ����
		Set<String> keySet = map.keySet();  //Set ����
		Iterator<String> iterator = keySet.iterator(); //������
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			String[] value = map.get(key);  //Ĭ�����״γ��ֵĲ�������Ϊ׼
			
			//5.��֤���ڶ����ͬ�Ĳ���
			if(value.length > 1){
				for (int i = 0; i < value.length; i++) {
					String val = new String(value[i].getBytes("ISO-8859-1"),"utf-8"); // ��ֹ�����������������(�ն�)
					response.getWriter().append(key+ ":" + val + "<br/>");
				}
			}else {
				response.getWriter().append(key+ ":" + value[0] + "<br/>");
			}
		}
		
		//6.��ʽ2����ȡ����Ĳ���(�������������)
  	    Enumeration<String> para = request.getParameterNames();
  	    while(para.hasMoreElements())
  	    {
  	    	String paraname = para.nextElement();
  	    	String[] value = request.getParameterValues(paraname);
  	    	if(value.length > 1) {
  	    		for (int j = 0; j < value.length; j++) {
  	  				String val = new String(value[j].getBytes("ISO-8859-1"),"utf-8"); // ��ֹ�����������������(�ն�)
  	  	    		System.out.println(paraname +  " = " + val);
				}

  	    	}else {
  	    		 System.out.println(paraname +  " = " + value[0] + "\n");

  	    	}
  	    }		
	}
}
