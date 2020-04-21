package top.weiyigeek.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import net.sf.json.JSONArray;
import top.weiyigeek.main.CityBean;
import top.weiyigeek.service.CityService;
import top.weiyigeek.service.impl.CityServiceImpl;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.参数获取
            request.setCharacterEncoding("utf-8");
            int pid = Integer.parseInt(request.getParameter("pid"));
            
            //2.从数据库找出省份的城市
            CityService cs = new CityServiceImpl();
            List<CityBean> list = cs.findCity(pid);
            for (CityBean cityBean : list) {
                System.out.println(cityBean.toString());
            }
            
            //3.实例化XML处理的库
           // XStream xStream = new XStream();
            //xStream.useAttributeFor(CityBean.class, "cid"); //想把id做成属性
            //xStream.alias("city", CityBean.class);         //设置别名
            //String xml = xStream.toXML(list);              //转化一个对象成xml字符串(当然也可以将xml转化成为一个对象)
            
            
            //4.进行JSON数据封装
            JSONArray json = JSONArray.fromObject(list);
            String res = json.toString();
            System.out.println("JSON:" + res);        
            
            //5.返回数据
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(res);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("收到Post请求.....");
		doGet(request, response);
	}

}
