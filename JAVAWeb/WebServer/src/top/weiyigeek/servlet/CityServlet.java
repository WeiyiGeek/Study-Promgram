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
            //1.������ȡ
            request.setCharacterEncoding("utf-8");
            int pid = Integer.parseInt(request.getParameter("pid"));
            
            //2.�����ݿ��ҳ�ʡ�ݵĳ���
            CityService cs = new CityServiceImpl();
            List<CityBean> list = cs.findCity(pid);
            for (CityBean cityBean : list) {
                System.out.println(cityBean.toString());
            }
            
            //3.ʵ����XML����Ŀ�
           // XStream xStream = new XStream();
            //xStream.useAttributeFor(CityBean.class, "cid"); //���id��������
            //xStream.alias("city", CityBean.class);         //���ñ���
            //String xml = xStream.toXML(list);              //ת��һ�������xml�ַ���(��ȻҲ���Խ�xmlת����Ϊһ������)
            
            
            //4.����JSON���ݷ�װ
            JSONArray json = JSONArray.fromObject(list);
            String res = json.toString();
            System.out.println("JSON:" + res);        
            
            //5.��������
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(res);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("�յ�Post����.....");
		doGet(request, response);
	}

}
