// 静态变量/方法 非静态变量/方法
class Demo_StaticVariable {
    public static void main(String[] args) {
        //案例1.非静态成员方法
        Base1 b1 = new Base1();
        b1.print();

        //案例2.静态成员方法
        Base1.print2();

   }
}

class Base1 {
    int id = 1024;
    static int score = 78;
    
    //非静态成员方法,即可以访问静态的成员也可以访问非静态的成员
    public void print() {
        System.out.println("非静态方法："+id);
        System.out.println(score);
    }

    //静态成员方法不能访问非静态的,错误：无法从静态上下文中引用非静态
    public static void print2() {
        //System.out.println("非静态方法："+this.id); //会执行错误,由于静态方法/变量 再创建对象前都已经被创建 所以这里无法使用this
        System.out.println("静态方法："+score); //不能输出调用id的值
    }
}