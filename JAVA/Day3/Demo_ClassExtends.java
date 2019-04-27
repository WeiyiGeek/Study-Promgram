//继承讲解 extends
class Demo_ClassExtends {
    public static void main(String[] args) {
        //1.多层继承，使用最底层进行实例化对象
        grandChild child = new grandChild();
        child.grandChildFun();
        child.childFun();
        child.parentFun();
    }
}

//父类
class Parent {
    int num1 = 10;
    //子类默认是不能继承父类的构造方法,需要借助后面讲解的super进行访问
    public Parent() {
        System.out.println("父类里面的构造方法！");
    }
    //父类公共方法
    public void parentFun() {
        System.out.println("我是父类里面得方法-parentFun()");
    }
    //父类私有成员此时子类是无法访问得（除非后面讲解得映射）
    private void show() {
        System.out.println("父类里的私有方法-继承的子类是无法访问的");
    }
}

//子类
class Child extends Parent {
    int num1 = 20;
    //子类公共方法
    public void childFun() {
        System.out.println("我是子类里面得方法-childFun()");
    }
}

//多层继承子类 - > 孙子类
class grandChild extends Child{
    //由于就进原则，子类又就不用父类的了
    int num1 = 30; //字父类出现同名的变量是再讲课中，实际上可以直接继承父类的num1；

     //孙子类公共方法
     public void grandChildFun() {
        System.out.println("我是孙子类里面得方法-grandChildFun(); num1 = " + num1); //num1 = 30
    }
}


// 父类里面的构造方法！
// 我是孙子类里面得方法-grandChildFun(); num1 = 30
// 我是子类里面得方法-childFun()
// 我是父类里面得方法-parentFun()