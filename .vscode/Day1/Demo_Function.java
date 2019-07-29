package Day1;

import java.util.Scanner;
// JAVA函数(方法案例)
class Demo_Function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("5 + 12 = " +sum(5,12)); //调用方法

        System.out.print("请输入显示多少个斐波那契：");
        int count = sc.nextInt();
        sc.close();
        System.out.println("显示"+count+"斐波那契数列：");
        fibonacci(count);


        //递归 -> 汉诺塔
        char a ='A',b='B',c='C';
        hanio(3,a,b,c);
        //递归 => 斐波那契
        System.out.println("第"+count+"个斐波那契数值为："+fibo(10));
        System.out.println("第5个人的年龄为："+age(5));
    }
    //1.方法需要 明确参数列表以及返回值类型
    public static int sum(int x, int y)
    {
        return x + y; 
    }

    //2.斐波那契
    public static void fibonacci(int count)
    {
        int a = 0;
        int b = 1;
        for(int i = 0; i < count; i++)
        {
            int temp = a;   //坑
            a = b;
            b += temp;
            System.out.print(a+"\t");
        }
        return ; //返回值类型是void,return可以忽略系统也会默认加上return ;
    }

    //3.函数递归 汉诺塔
    public static void hanio(int n,char a,char b,char c){
        if(n==1)
            System.out.println("移动"+n+"号盘子从"+a+"到"+c);
        else{
            hanio(n-1,a,c,b);//把上面n-1个盘子从a借助b搬到c
            System.out.println("移动"+n+"号盘子从"+a+"到"+c);//紧接着直接把n搬动c
            hanio(n-1,b,a,c);//再把b上的n-1个盘子借助a搬到c
        }
    }

    //4.函数递归 斐波那契
    public static int fibo(int i)
    {
        if(i == 1 || i == 2 )
        {
            return 1;
        }else{
            return (fibo(i-1)+fibo(i-2));
        }
    }
    
    //5.函数递归 吃年龄问题
    public static int age(int person)
    {
        if (person == 1)
        {
            return 10;
        }else{
           return age(person-1) + 2;
        }
    }

}
//###########################
// 5 + 12 = 17
// 请输入显示多少个斐波那契：10
// 显示10斐波那契数列：
// 1       1       2       3       5       8       13      21      34      55      移动1号盘子从A到C
// 移动2号盘子从A到B
// 移动1号盘子从C到B
// 移动3号盘子从A到C
// 移动1号盘子从B到A
// 移动2号盘子从B到C
// 移动1号盘子从A到C
// 第10个斐波那契数值为：55
// 第5个人的年龄为：18