package top.weiyigeek.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSession�� ����session��.....");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSession������session��.....");
    }
}
