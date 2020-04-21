package top.weiyigeek.main;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @Desc ������HttpSessionBindingListener��������ʵ�֣�����Session��ֵ��״̬�ı�;
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
    //���� HttpSessionBindingListener ������Web.xml�н���ע�ᣬ������ʹ���б�����Bean���н���ʵ�ָýӿ�
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBinding:����ֵ �� ��....");
    }
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBinding:����ֵ�� ��� ��....");
    }
}
