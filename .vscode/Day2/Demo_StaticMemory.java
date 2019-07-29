package Day2;

//static关键字对象内存图
class Demo_StaticMemory {
    public static void main(String[] args) {
         //案例0：类名可以直接调用静态属性或者静态方法
         System.out.println("Person.country = "+ Person.country);

        //案例1.
        Person p1 = new Person("WeiyiGeek", "001");
        p1.country = "重庆";
        p1.Info();

        Person p2 = new Person("唯一", "002");
        p2.Info();

        //案例2：类名可以直接调用静态属性或者静态方法
        System.out.println("Person.country = "+ Person.country);
    }
}
/** Person 类 */
class Person {
    String name;  //公共成员变量
    private String id;  //私有成员变量
    static String country = "未知城镇";  //静态成员变量 (公共对象共享)

    //构造方法（有参）
    public Person(String name,String id)
    {
        System.out.println("######进入构造方法！##########");
        this.name = name;
        this.id = id;
    }
    public void Info(){
        System.out.println("个人信息:\n姓名:"+this.name+"\tid:"+this.id+"\t城市:"+country);
    }
}