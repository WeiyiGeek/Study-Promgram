/**
 * # @File : AnonmouseInnerClass.java
 * # @CreateTime : 2019/8/16 16:21
 * # @Author : WeiyiGeek
 * # @Function :
 **/
class AnonmouseInnerClass {
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        Outer demo = new Outer();  //外部类
        demo.method();  //调用匿名内部类

    }
}

//匿名类实现的接口
interface Inter {
    public void show1();
    public void show2();
}

//匿名类的外部类
class Outer {
    //建立一个公共的方法,匿名内部类重写多个方法调用
    public void method(){
        //简化版的内部类(匿名内部类)
        new Inter() {
            //重写实现接口中第一个方法
            public void show1() {
                System.out.println("匿名内部类: 重写实现接口中第一个方法");
            }
            //重写实现接口中第一个方法
            public void show2() {
                System.out.println("匿名内部类: 重写实现接口中第二个方法");
            }
        }.show1();  //方式1(关键点)实现两个方法输出需要上面这块代码重写一次;


        //方式2:此种方法存在弊端
        Inter i = new Inter(){
            public void show1() {
                System.out.println("匿名内部类: 重写实现接口中第一个方法");
            }
            //重写实现接口中第一个方法
            public void show2() {
                System.out.println("匿名内部类: 重写实现接口中第二个方法");
            }
            /** 弊端的产生:写一个自定义的方法
             public void show3() {
             System.out.println("匿名内部类: 自定义的方法");
             }
             **/
        };  //注意此处需要 ";"

        i.show1(); //编译看接口中定义的show1方法,运行看子类中的show1方法
        i.show2(); //编译看接口中定义的show2方法,运行看子类中的show2方法
        //i.show3(); //这里不能采用这样的形式由于编译看父类接口中定义的方法，而接口中没有这样的方法，所以会产生错误;
        //如果向下强转需要与子类的类名,而这里是匿名内部类;
    }
}