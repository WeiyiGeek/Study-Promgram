package top.weiyigeek.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author WeiyiGeek
 * @Desc Session �Ķۻ��λ����
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    public void sessionWillPassivate(HttpSessionEvent hse) {
           System.out.println("HttpSessionActivation���ۻ����� " + hse.getSession());
    }
    
    public void sessionDidActivatee(HttpSessionEvent hse) {
        System.out.println("HttpSessionActivation(�)�� " + hse.getSession());
    }
}
