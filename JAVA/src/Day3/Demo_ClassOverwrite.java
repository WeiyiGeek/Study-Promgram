// 继承中方法的重写
class Demo_ClassOverwrite {
    public static void main(String[] args) {
        //注意：子类重写父类方法的时候最好声明一模一样
        IOS8 ios = new IOS8();
        ios.call();
        ios.siriSpeak();
        IOS7.print();
    }
}

//父类IOS7
class IOS7 {
    //公共方法
    public void call() {
        System.out.println("使用 Phone 打电话!");
    }
    //私有方法
    private void play() {
        System.out.println("使用 Phone 打玩游戏! - 私有方法不能被重写!");
    }
    //需要重写的父类方法
    public void siriSpeak() {
        System.out.println("Speak English!");
        this.play();  //调用私有方法

    }
    //静态方法只能覆盖静态其实不算重写,多态的时候详细讲解
    public static void print() {
        System.out.println("使用 Phone 打印文章! -静态方法只能覆盖静态其实不算重写,多态的时候详细讲解");
    }
}

//子类IOS8
class IOS8 extends IOS7 {
    //子类方法与父类方法定义一致（或注意定义关键字一般是一致的）
    public void siriSpeak() {
        System.out.println("Speak Chinese!中文");
        super.siriSpeak();  //除了构造方法有规则父类需要写入到第一句，其他方法没有这个讲究；
    }
}

// 使用 Phone 打电话!
// Speak Chinese!中文
// Speak English!
// 使用 Phone 打玩游戏! - 私有方法不能被重写!
// 使用 Phone 打印文章! -静态方法只能覆盖静态其实不算重写,多态的时候详细讲解