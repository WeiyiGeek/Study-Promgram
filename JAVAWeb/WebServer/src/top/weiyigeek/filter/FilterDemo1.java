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
    //自动生成:构造方法
    public FilterDemo1() {}
	/*** @see Filter#destroy()*/
	public void destroy() {}
	//Filter过滤的入口方法
	/*** @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    //此处统一对用户请求的数据进行编码
	    request.setCharacterEncoding("UTF-8");
	   // System.out.println((++count) + ".Filter(过滤器) - doFilter : 已获取用户请求正在做一些列的处理.....");
		// pass the request along the filter chain
	    System.out.println("-请求进入 FilterDemo1过滤器 .... Before Chain.doFilter");
		chain.doFilter(request, response);
		System.out.println("#响应进入 FilterDemo1 过滤器 .... Recevice");
	}
	/*** @see Filter#init(FilterConfig) */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
