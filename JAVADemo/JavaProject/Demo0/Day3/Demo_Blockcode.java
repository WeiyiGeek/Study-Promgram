package Day3;

//代码块案例演示
// 
class Demo_Blockcode {
    static {
        System.out.println("1.主方法中的静态代码块");
    }
    public static void main(String[] args) {
        System.out.println("2.主方法main");

        //局部代码块
        {
         int x = 1024;   //限定变量的声明周期
         System.out.println("3.主方法main中代码块"+x);
        }

        Baser b = new Baser();
    }

}

/**基础类 */
class Baser {
    // 静态代码块：随着类加载而加载,且只执行一次
    // 作用:用来给类进行初始化,一般用来加载驱动 ，静态代码块是优先于主方法执行
    static {
        System.out.println("4.Base类的静态代码块");
    }

    public Baser() {
        System.out.println("7.Base类构造方法");
    }

    //构造代码块:每创建一次对象就会执行一次,优先于构造函数执行
    {
        System.out.println("5.Base类构造代码块");
        test();
    }

    public void test() {
        System.out.println("6.Base类构造代码块调用的test()函数");
    }
}


// 1.主方法中的静态代码块
// 2.主方法main
// 3.主方法main中代码块1024
// 4.Base类的静态代码块
// 5.Base类构造代码块
// 6.Base类构造代码块调用的test()函数
// 7.Base类构造方法