package top.weiyigeek.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
/**
 * @Desc 属性更改|替换|添加事件触发
 * @author WeiyiGeek
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        System.out.println("1.属性添加......");
    }
    public void attributeRemoved(HttpSessionBindingEvent hsbe) {
        System.out.println("2.属性移除......");
    }
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {
        System.out.println("3.属性替换......");
    }
}
