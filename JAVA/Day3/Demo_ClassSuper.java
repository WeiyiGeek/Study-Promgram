//继承中的构造方法
class Demo_ClassSuper {
    public static void main(String[] args) {
        //继承构造
        Son son = new Son();
        son.print();
        System.out.println("-------------------------");
        son = new Son(65536);
        son.print();
    }
}

//如果取消类构造方法，系统会自动添加空参构造方法
//父类 Father ，Object是最顶层的父类
class Father extends Object {
    int father = 1024;
    public Father() {
        super();  //当然这里也可加入父类有参 super(32768)
        System.out.println("父类 空参 构造方法");
    }
    public Father(int value) {
        this.father = value;
        System.out.println("父类 有参 构造方法");
    }
}

//子类
class Son extends Father {
    int father = 2048;

    //子类空参
    public Son() {
        //super();    //缺省该super()是系统自动添加的 ， 必须放在构造器的第一条语句,在构造中与super()不能同时存在
        this(10000);   //本类中的构造方法 ， 必须放在构造器的第一条语句,在构造中与super()不能同时存在
        System.out.println("子类 空参 构造方法"); //再父子类执行后执行
    }
    //子类有参
    public Son(int value) {
        super(value);
        System.out.println("子类 有参 构造方法");
    }

    public void print() {
        System.out.println("父类："+super.father);
        System.out.println("子类："+this.father);  //this既可以输出本类变量也可以输出父类的变量(前提是本类没有父类的重名变量)
        System.out.println("子类："+father);
    }
}

// 父类 有参 构造方法
// 子类 有参 构造方法
// 子类 空参 构造方法
// 父类：10000
// 子类：2048
// 子类：2048
// -------------------------
// 父类 有参 构造方法
// 子类 有参 构造方法
// 父类：65536
// 子类：2048
// 子类：2048