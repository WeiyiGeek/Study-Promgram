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
    //�ۻ�
    public void sessionWillPassivate(HttpSessionEvent hse) {
        System.out.println("- HttpSessionActivation(���ۻ�) �� Session ֵ =  " + hse.getSession().getId());
    }
    //�
    public void sessionDidActivate(HttpSessionEvent hse) {
        System.out.println("- HttpSessionActivation(���) �� Session ֵ =  " + hse.getSession().getId());
    }
}
