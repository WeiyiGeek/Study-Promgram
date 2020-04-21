package top.weiyigeek.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author WeiyiGeek
 * @Desc Session 的钝化何活化处理
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    public void sessionWillPassivate(HttpSessionEvent hse) {
           System.out.println("HttpSessionActivation（钝化）： " + hse.getSession());
    }
    
    public void sessionDidActivatee(HttpSessionEvent hse) {
        System.out.println("HttpSessionActivation(活化)： " + hse.getSession());
    }
}
