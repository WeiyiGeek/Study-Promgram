package top.weiyigeek.listener;

/**
 * @desc A�����Test����ӿڷ���������Ҳ��2018��д
 * @author WeiyiGeek
 *
 */
public class A {
    public void Test(MessageListener msg) {
        for (int i = 0; i < 10; i++) {
           System.out.println("2018��A��������ǰIndex:"+i);
           if( i == 5) {
               System.out.println("2018��A�������Ѿ���"+i+"����֪ͨB���з���ִ��!");
               msg.print();
           }
        }
    }
}
