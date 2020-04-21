package top.weiyigeek.main;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @Desc 第三类HttpSessionBindingListener监听器的实现，监听Session传值的状态改变;
 * @author WeiyiGeek
 */
public class BeanListener implements HttpSessionBindingListener {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //由于 HttpSessionBindingListener 不用在Web.xml中进行注册，所以在使用中必须在Bean类中进行实现该接口
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBinding:对象值 被 绑定....");
    }
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBinding:对象值被 解除 绑定....");
    }
}
