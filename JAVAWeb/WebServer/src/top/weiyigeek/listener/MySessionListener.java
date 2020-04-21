package top.weiyigeek.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSession： 创建session了.....");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSession：销毁session了.....");
    }
}
