package top.weiyigeek.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterDemo2
 */
public class FilterDemo2 implements Filter {
    public FilterDemo2() {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("FilterDemo2 : ������������......");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("-������� FilterDemo2 ������ .... Before Chain.doFilter");
		chain.doFilter(request, response);
	    System.out.println("-��Ӧ���� FilterDemo2 ������ .... Recevice");
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	   System.out.println("FilterDemo2 : ��ʼ������������......"+ fConfig.getFilterName());
	}
}
