package Day2;

//引用数据类型与基本数据类型调用的区别
class Demo_ClassQuote {
    public static void main(String[] args) {
        print(10); //调用局部方法（即基本数据类型当作形式参数）

        Student s = new Student(); //创建对象并将对象地址赋值给s
        print(s); //这里使用了方法的重载
    }

    //1.传入基本数据类型作为形式参数(传入的是值)
    public static void print(int x) 
    {
        System.out.println(x);
    }
    //2.传入引用数据类型作为形式参数 （给的是地址值）
    public static void print(Student stu)
    {
        stu.name = "WeiyiGeek";
        stu.speak();
    }
}

/** 
 * 创建一个学生类
*/
class Student {
    String name;
    public void speak() {
        System.out.println(name+"正在台上讲话!");
    }
}

// 10
// WeiyiGeek正在台上讲话!