package Day2;

// 对象内存分析案例
class Demo_Classmemory {
    public static void main(String[] args) {
        //3个引用两个内存图
        Car c1 = new Car();  //实例化对象c1
        c1.color = "red";
        c1.run();  //red
        c1 = null; //将c1对象设置为空指针(使之不指向原来的地址)
        
        Car c2 = new Car(); //实例化对象c1
        c2.color = "Black";
        c2.run(); //Black
      
        Car c3 = c2; //将c3对象指向c2的地址指针，如果c2 = null; c3.run()将会出空指针异常
        c3.run(); //Black
    }   
}

class Car {
    String color;
    public void run() {
        System.out.println(color);
    }
}