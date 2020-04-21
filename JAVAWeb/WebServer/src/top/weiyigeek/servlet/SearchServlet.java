package top.weiyigeek.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.weiyigeek.main.SearchBean;
import top.weiyigeek.service.SearchService;
import top.weiyigeek.service.impl.SearchServiceImpl;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        //编码与参数获取
	        request.setCharacterEncoding("UTF-8");
	        String keys = request.getParameter("words");
	        
	        //调用service层执行数据库Dao
	        SearchService ss = new SearchServiceImpl();
            List<SearchBean> result = ss.findWords(keys);
            
            System.out.println("--------- 查询到的数据 ------------");
            for(SearchBean word: result) {
                System.out.println("#"+word.toString());
            }
            
            //返回查询到的数据
            request.setAttribute("words", result);
            request.getRequestDispatcher("listSearch.jsp").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
