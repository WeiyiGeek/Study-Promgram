package top.weiyigeek.listener;

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A demo = new A();
        demo.Test(new B());  //多态的体现,此处将B实例类传递给Test方法中MessageListener接口参数，实际上是父类引用指向子类方法;
    }
}
