// 键盘输入案例
import java.util.Scanner; //导入包
class Demo_Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  //#实例化Scanner类eclipse控制器输入输出类型
        System.out.print("请输入一个整数a: ");
        int x = sc.nextInt();   //将键盘输入的值存储进入到x中 （整形）
        System.out.print("请输入一个整数b: ");
        int x1 = sc.nextInt();
        System.out.print("请输入您的名字：");
        String n = sc.next(); //字符串类型
        System.out.println("名字为"+n+" ,a + b = "+(x+x1));
        sc.close();  //释放内存
    }
}
//########### 执行案例 ###############
// 请输入一个整数a: 110
// 请输入一个整数b:120
// 请输入您的名字：WeiyiGeek
// 名字为WeiyiGeek ,a + b = 230