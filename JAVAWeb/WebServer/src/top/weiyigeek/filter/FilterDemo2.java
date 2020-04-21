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
		System.out.println("FilterDemo2 : 过滤器被销毁......");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("-请求进入 FilterDemo2 过滤器 .... Before Chain.doFilter");
		chain.doFilter(request, response);
	    System.out.println("-响应进入 FilterDemo2 过滤器 .... Recevice");
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	   System.out.println("FilterDemo2 : 初始化创建过滤器......"+ fConfig.getFilterName());
	}
}
