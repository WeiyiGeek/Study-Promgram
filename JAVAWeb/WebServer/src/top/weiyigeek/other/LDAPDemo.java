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
 * @Descr 使用Javax.naming验证LDAP登录
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
        
        //基于哈希表实现的是线程安全的，能用于多线程环境中
        Hashtable<String, String> tbl = new Hashtable<String, String>();
        
        //JNDI 
        //为初始化上下文选择服务提供者
        tbl.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        //提供初始化上下文需要的信息
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
        
        
        //上下文对象
        DirContext context = null;
        try {
            //创建初始化上下文
            context = new InitialDirContext(tbl);
            System.out.println("Login Successful! 登录成功");
            System.out.println("Login Verification LDAP \n");
            
            //举上下文有两个方法
            System.out.println("-------------- 枚举 查询对象 ---------- ");
            //方式1:
//            NamingEnumeration list = context.list("ou=Development");  //指定对象
//            while (list.hasMore()) {
//                NameClassPair nc = (NameClassPair)list.next();
//                System.out.println(nc);
//            }
            
            //方式2:
            NamingEnumeration<?> bindings = context.listBindings(""); //不指定对象则显示全部
            while (bindings.hasMore()) {
                Binding bd = (Binding)bindings.next();
                System.out.println(bd.getName() + ": "  + bd.getNameInNamespace() + ": " + bd.getObject() );
            }
            bindings.close();
            
          //对象属性全部读取
            try {
                Attributes answer = context.getAttributes(USERNAME);
                System.out.println("\n-----------------获取 "+ USERNAME + " 对象属性-----------------");
                for (NamingEnumeration ae = answer.getAll(); ae.hasMore();) {
                    Attribute attr = (Attribute)ae.next();
                    System.out.print(attr.getID());
                    for (NamingEnumeration e = attr.getAll(); e.hasMore(); System.out.println(" : " + e.next()));
                }
            } catch (Exception e) {
               System.out.println("Read Fail : " + USERNAME + " Object 对象不存在!");
            } 
            
           
          //指定对象属性读取
            try {
                Attributes answer = context.getAttributes(USERNAME, attrIDs);
                System.out.println("\n----------------- 获取对象指定属性 -----------------");
                for (NamingEnumeration ae = answer.getAll(); ae.hasMore();) {
                    Attribute attr = (Attribute)ae.next();
                    System.out.print(attr.getID());
                    for (NamingEnumeration e = attr.getAll(); e.hasMore(); System.out.println(" : " + e.next()));
                }
            } catch (Exception e) {
               System.out.println("Read Fail : " + USERNAME + " Object 对象不存在!");
            } 
            
            
        } catch (Exception e) {
            System.out.println("Login failed : " + e.getMessage());
        } finally {
            //销毁context上下文对象
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
