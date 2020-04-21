package top.weiyigeek.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterDemo1
 */
public class FilterDemo1 implements Filter {
    static int count = 0;
    //�Զ�����:���췽��
    public FilterDemo1() {}
	/*** @see Filter#destroy()*/
	public void destroy() {}
	//Filter���˵���ڷ���
	/*** @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    //�˴�ͳһ���û���������ݽ��б���
	    request.setCharacterEncoding("UTF-8");
	   // System.out.println((++count) + ".Filter(������) - doFilter : �ѻ�ȡ�û�����������һЩ�еĴ���.....");
		// pass the request along the filter chain
	    System.out.println("-������� FilterDemo1������ .... Before Chain.doFilter");
		chain.doFilter(request, response);
		System.out.println("#��Ӧ���� FilterDemo1 ������ .... Recevice");
	}
	/*** @see Filter#init(FilterConfig) */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
