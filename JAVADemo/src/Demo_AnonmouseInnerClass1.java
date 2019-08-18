class Demo_AnonmouseInnerClass1 {
    public static void main(String[] args){
    //方式1：由于show方法是静态
    Outer.method().show();

    //方式2:强制转换
    Inter i = Outer.method();
    i.show();
    }
}

//匿名内部类要实现的接口
interface Inter {
    void show();
}

//外部类
class Outer {
    public static Inter method() {
        //注意这里返回的是一个匿名内部类，将重写接口方法
        return new Inter(){
            public void show() {
                System.out.println("匿名内部类的面试题!");
            }
        };
    }
}