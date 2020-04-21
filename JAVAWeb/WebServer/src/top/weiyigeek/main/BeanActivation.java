package top.weiyigeek.main;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class BeanActivation implements HttpSessionActivationListener,Serializable {
 
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //钝化
    public void sessionWillPassivate(HttpSessionEvent hse) {
        System.out.println("- HttpSessionActivation(被钝化) ， Session 值 =  " + hse.getSession().getId());
    }
    //活化
    public void sessionDidActivate(HttpSessionEvent hse) {
        System.out.println("- HttpSessionActivation(被活化) ， Session 值 =  " + hse.getSession().getId());
    }
}
