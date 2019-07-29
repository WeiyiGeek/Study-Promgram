//类声明实例化调用案例
//测试类：Demo_Class
//基本类：Students

class Demo_Class {
    public static void main(String[] args) {
        //类的实例化=>对象
        Students stu = new Students();
        stu.age = 13;         //调用属性并且赋值
        stu.name = "Weiyigeek";
        stu.sex = '女';
        stu.sleep();         //调用方法

        //########## 执行结果 #############
        // 姓名：Weiyigeek ,年龄：13 ,性别：女动作：正在睡觉
    }
}
/**
 * 学生类：Students
 */
 class Students {
    //属性
    String name;
    char sex = 'N';
    int age;
    //方法
    public void study()
    {
        System.out.println(this.name+"正在学习！"+this.age + this.sex);
    }
    public void sleep()
    {
        System.out.println("姓名："+this.name+" ,年龄："+this.age+" ,性别："+this.sex+"动作：正在睡觉");
    }
}




// phone.brand = "MI";
// phone.price = 19;   //可以用null把原来的值覆盖掉，但是会存在空指针异常：
// phone.call();

// /**
//  * 手机类:PhoneInfo
//  */
// class PhoneInfo {
//     String brand;
//     int price;

//     public void call(){
//         System.out.println("在价值"+this.price+"元,"+this.brand+"品牌手机,能打5个小时电话");
//     }
//     public void play()
//     {
//         System.out.println("手机玩游戏非常nice!");
//     }
// }