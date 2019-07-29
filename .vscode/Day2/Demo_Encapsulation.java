// 对象封装与private关键字
class Demo_Encapsulation {
    public static void main(String[] args) {
        //实例化
        Encaps en = new Encaps();
        en.name = "WeiyiGEEK";
        en.setID(500102123);  //设置私有属性
        System.out.println("用户ID值："+en.getID()); //获取私有属性
        en.getInfo();
    }
}

class Encaps {
    String name;   //公共成员变量
    private long ID;  //私有成员变量

    //获取私有的成员变量
    public long getID() {
        return ID;
    }
    //设置私有的成员变量
    public void setID(long value)
    {
        ID = value;
    }
    //公共方法
    public void getInfo()
    {
        System.out.println(name + " ： " + ID);
    }
}   

// 用户ID值：500102123
// WeiyiGEEK ： 500102123