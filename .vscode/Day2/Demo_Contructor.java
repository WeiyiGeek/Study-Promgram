package Day2;

//java对象构造方法 案例
class Demo_Contructor {
    public static void main(String[] args) {
        //案例1.构造方法的调用与使用 （有参构造）
        Base b = new Base("Weiyigeek"); //再创建对象时候系统自动帮我调用了Base类的构造方法Base()
        System.out.println("Name:"+b.getName()+"\n");

        //案例2. 构造方法的重载 (无参构造)
        Base b1 = new Base();
        System.out.println("Name:"+b1.getName());

        //案例3.
        Base b2 = new Base("Hacker");  //该对象将会变成垃圾被回收
        b2 = new Base("New Hacker");   //这种方法看运行结果貌似是改名了,其实是将原对象变成垃圾
        System.out.println("Name:"+b2.getName());
    }
}

/**基础类：base */
class Base {
    private String name;
    //构造方法定义 （注意无返回值类型 |有参构造）
    public Base(String name){
        this.name = name;  //成员变量赋值 属性的进行初始化值
        System.out.println("b对象 - 这是Base类的构造方法：name = "+this.name);
    }
    //构造方法重载 （空参构造 | 常规建议放在有参构造前面）
    public Base()
    {
        this.name = "空参构造";
        System.out.println("b1对象 - 这是Base类的重载构造方法："+this.name);
    }

    public String getName(){
        return this.name;
    }
}

//################## 执行结果 ##################
// b对象 - 这是Base类的构造方法：name = Weiyigeek
// Name:Weiyigeek

// b1对象 - 这是Base类的重载构造方法：空参构造
// Name:空参构造

// b对象 - 这是Base类的构造方法：name = Hacker
// b对象 - 这是Base类的构造方法：name = New Hacker
// Name:New Hacker