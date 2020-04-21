package top.weiyigeek.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
/**
 * @Desc ���Ը���|�滻|����¼�����
 * @author WeiyiGeek
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        System.out.println("1.�������......");
    }
    public void attributeRemoved(HttpSessionBindingEvent hsbe) {
        System.out.println("2.�����Ƴ�......");
    }
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {
        System.out.println("3.�����滻......");
    }
}
