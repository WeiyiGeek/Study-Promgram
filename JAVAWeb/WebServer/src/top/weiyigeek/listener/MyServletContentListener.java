package top.weiyigeek.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContentListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext: ��ʼ�� .....");
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext: ������ .....");
    }
}
