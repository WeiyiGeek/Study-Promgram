package top.weiyigeek.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContentListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext: 初始化 .....");
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext: 销毁了 .....");
    }
}
