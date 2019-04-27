//final 关键字讲解
class Demo_Final {
    public static void main(String[] args) {
        //案例1.final 定义过得基本类型是不能被改变得
        DemoFinal fi = new DemoFinal();

        //案例2：地址值不能被改变,对象中得属性可以改变
        final Dm1 o = new Dm1("Whoami"); 
        o.getName();
        o.setName("Weiyigeek");
        o.getName();
    }
}

// ########### 执行结果 ##########
// 1024 , 1
// Whoami
// Weiyigeek


//类1：
class DemoFinal {
    //final 常常 public static 与连用
    public static final int NUM = 1024; //方法1：被final修饰得成员变量只能初始化一次 (且值不能被改变值 就是常量)
    final int COUNT;      //方法2：注意成员变量得默认初始化值是无效得
    public DemoFinal() {  //再对象构造方法中进行设置
       COUNT = 1;
        System.out.println(this.NUM + " , " + this.COUNT);
    }
}

//类2:类不能被继承
final class Dm1 {
    private String name;
    public Dm1(String value) {
        this.name = value;
    }
    public void getName() {
        System.out.println(this.name);
    }
    public void setName(String value) {
        this.name = value;
    }

    //被final修饰得方法不能被重写
    public final void notOverride() {
        System.out.println("这是不能被重写得类方法");
    }
}