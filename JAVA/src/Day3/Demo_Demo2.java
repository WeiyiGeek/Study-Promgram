//使用继承学生与老师案例
class Demo_Demo2 {
    public static void main(String[] args) {
        //1.实例
        Teacher tea = new Teacher("Weiyi",25);
        tea.eat();
        tea.action();
        System.out.println("------------------------");
        Studentss stu = new Studentss("Geek", 18);
        stu.eat();
        stu.action();
    }
}

//学生与老师共有类
class Pub {
    String name;
    int age;

    //父类构造方法
    public Pub(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Pub 类得有参构造方法");
    }

    //公共方法
    public void eat() {
        System.out.println("共有类吃饭方法");
    }
    //override 重写方法
    public void action() {
        System.out.println("将要被子类重写方法");
    }
}

//老师继承Pub
class Teacher extends Pub {
    public Teacher(String name,int age)
    {
        super(name,age);
        System.out.println("Teacher 类得有参构造方法");
    }

    //重写父类中行为方法
    public void action() {
        System.out.println(super.name+" 【正在讲课！】");
    }
}

//学生继承Pub
class Studentss extends Pub {
    public Studentss(String name, int age) {
        super(name,age);
        System.out.println("Student 类得有参构造方法");
    }

    //override 行为方法
    public void action() {
        System.out.println(super.name+"【正在学习！】");
    }
}

//########### 执行结果 ###############
// Pub 类得有参构造方法
// Teacher 类得有参构造方法
// 共有类吃饭方法
// Weiyi 【正在讲课！】
// ------------------------
// Pub 类得有参构造方法
// Student 类得有参构造方法
// 共有类吃饭方法
// Geek【正在学习！】

