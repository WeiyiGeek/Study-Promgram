/***
 * 多态Polymorphic中的特点
 * 成员变量 与 成员方法
 ***/
class Demo1_polymorphic1 {
    public static void main(String[] args)
    {
        //示例1.特点之成员变量
        Father f = new Son();      //注意看左边父类
        System.out.println("father 类定义" + f.num);

        Son s = new Son();
        System.out.println("son 类定义：" + s.num);

        //示例2.特点之成员方法
        f.print();  //实际还是指向子类的方法
        s.print();

        //示例3.特点之静态方法
        f.printf();  //相当于是Father.printf() 即类名直接调用
        s.printf();
    }
}

//父类
class Father {
    int num = 10;
    public void print(){
        System.out.println("我是一个父类");
    }
    public static void printf() {
        System.out.println("我是一个Father父类的静态方法");
    }
}
//子类
class Son extends Father {
    int num = 20;
    public void print(){
        System.out.println("我是一个子类");
    }
    public static void printf() {
        System.out.println("我是一个Son子类的静态方法");
    }
}