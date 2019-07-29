package Day1;

// 方法重载 overload 案例
class Demo_Overload {
    public static void main(String[] args) {
        //1.重载：方法名称相同。参数列表格式/类型不同(顺序不同),并且返回类型值无关
        System.out.println("重载案例1："+sum(5,9));  //重载案例1：14.0
        System.out.println("重载案例2："+sum(5,9,12));  //重载案例2：26
        System.out.println("重载案例3："+sum(6,5.3,7.7)); //重载案例3：19.0

        System.out.println("#### 重载案例4 ####"); 
        System.out.println(isEqual(1,6));
        System.out.println(isEqual(6.1,6.1));
    }

    //(1) add方法求两个参数的和
    //注意返回的类型：
    public static double sum(int a,int b)
    {
        return (a + b);
    }

    //(2) add方法求三个整型参数的和
    public static int sum(int a, int b, int c)
    {
        return a + b + c;
    }

    //(3) add方法求三个浮点数参数这和
    //注意设置参数列表类型
    public static double sum(int a, double b, double c)
    {
        return a + b + c;
    }

    //案例4:比较两个整数/浮点数是否相等
    public static boolean isEqual(int a, int b)
    {
        return (a==b)?true:false;
    }
    public static boolean isEqual(double a, double b)
    {
        return (a==b)?true:false;
    }
}

// #### 重载案例4 ####
// false
// true