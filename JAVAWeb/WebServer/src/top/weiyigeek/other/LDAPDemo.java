package top.weiyigeek.other;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 * @Descr ʹ��Javax.naming��֤LDAP��¼
 * @author WeiyiGeek
 *
 */
public class LDAPDemo {
    public static void main(String[] args) {
        String IP = "192.168.107.245";
        String PORT = "389";
        String BASEDN = "dc=weiyigeek,dc=com,dc=cn";
        String MANAGER = "cn=admin";
        String PASS = "1234561";
        String USERNAME = "cn=WeiyiGeek,ou=Development";
        String LDAP_URL = "ldap://"+IP+":"+PORT+"/"+BASEDN;
        String[] attrIDs = {"mail","displayName","uidNumber","sn" };
        
        //���ڹ�ϣ��ʵ�ֵ����̰߳�ȫ�ģ������ڶ��̻߳�����
        Hashtable<String, String> tbl = new Hashtable<String, String>();
        
        //JNDI 
        //Ϊ��ʼ��������ѡ������ṩ��
        tbl.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        //�ṩ��ʼ����������Ҫ����Ϣ
        tbl.put(Context.PROVIDER_URL, LDAP_URL);
        tbl.put(Context.SECURITY_AUTHENTICATION, "simple");
        tbl.put(Context.SECURITY_PRINCIPAL, USERNAME+","+BASEDN);
        tbl.put(Context.SECURITY_CREDENTIALS, PASS);
        
        System.out.println("--------------Show Env Setting --------------");
        Enumeration<String> keys = tbl.keys();
        while(keys.hasMoreElements()) {
            System.out.println(tbl.get(keys.nextElement()));
        }
        System.out.println("");
        System.out.println("--------------Login Verification LDAP    ---------- ");
        
        
        //�����Ķ���
        DirContext context = null;
        try {
            //������ʼ��������
            context = new InitialDirContext(tbl);
            System.out.println("Login Successful! ��¼�ɹ�");
            System.out.println("Login Verification LDAP \n");
            
            //������������������
            System.out.println("-------------- ö�� ��ѯ���� ---------- ");
            //��ʽ1:
//            NamingEnumeration list = context.list("ou=Development");  //ָ������
//            while (list.hasMore()) {
//                NameClassPair nc = (NameClassPair)list.next();
//                System.out.println(nc);
//            }
            
            //��ʽ2:
            NamingEnumeration<?> bindings = context.listBindings(""); //��ָ����������ʾȫ��
            while (bindings.hasMore()) {
                Binding bd = (Binding)bindings.next();
                System.out.println(bd.getName() + ": "  + bd.getNameInNamespace() + ": " + bd.getObject() );
            }
            bindings.close();
            
          //��������ȫ����ȡ
            try {
                Attributes answer = context.getAttributes(USERNAME);
                System.out.println("\n-----------------��ȡ "+ USERNAME + " ��������-----------------");
                for (NamingEnumeration ae = answer.getAll(); ae.hasMore();) {
                    Attribute attr = (Attribute)ae.next();
                    System.out.print(attr.getID());
                    for (NamingEnumeration e = attr.getAll(); e.hasMore(); System.out.println(" : " + e.next()));
                }
            } catch (Exception e) {
               System.out.println("Read Fail : " + USERNAME + " Object ���󲻴���!");
            } 
            
           
          //ָ���������Զ�ȡ
            try {
                Attributes answer = context.getAttributes(USERNAME, attrIDs);
                System.out.println("\n----------------- ��ȡ����ָ������ -----------------");
                for (NamingEnumeration ae = answer.getAll(); ae.hasMore();) {
                    Attribute attr = (Attribute)ae.next();
                    System.out.print(attr.getID());
                    for (NamingEnumeration e = attr.getAll(); e.hasMore(); System.out.println(" : " + e.next()));
                }
            } catch (Exception e) {
               System.out.println("Read Fail : " + USERNAME + " Object ���󲻴���!");
            } 
            
            
        } catch (Exception e) {
            System.out.println("Login failed : " + e.getMessage());
        } finally {
            //����context�����Ķ���
            try {
                if (context != null) {
                    context.close();
                    context = null;
                }
                tbl.clear();
            } catch (Exception e) {
                System.out.println("Exception happened." + e.getMessage());
            }
        }
    }
}
