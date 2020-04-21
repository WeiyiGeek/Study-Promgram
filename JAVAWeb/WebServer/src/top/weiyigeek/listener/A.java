package top.weiyigeek.listener;

/**
 * @desc A类入口Test传入接口方法，假设也是2018缩写
 * @author WeiyiGeek
 *
 */
public class A {
    public void Test(MessageListener msg) {
        for (int i = 0; i < 10; i++) {
           System.out.println("2018年A方法，当前Index:"+i);
           if( i == 5) {
               System.out.println("2018年A方法，已经到"+i+"正在通知B进行方法执行!");
               msg.print();
           }
        }
    }
}
