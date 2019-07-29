//选择语句案例：
import java.util.Scanner;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;;
class Demo_SelectStatement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入您选择的序号(0-2):");
        int list = sc.nextInt();
        System.out.print("请输入成绩:");
        int score = sc.nextInt();
        sc.close();

        /**
         * IF语句：
         * a.比较表达式无论简单还是复制,结果必须是boolean类型;
         * b.if语句控制的语句体如果是一条语句大括号可以省略(与其他编程语言一致);
         * c.一般来说有左大括号就没有分号,有分号就没有左大括号(代码if语句结束);
         **/
        if(list == 0){
            System.out.println("0.您输入序号是："+list);
        }else if(list == 1){
            System.out.println("1.您输入序号是："+list);
        }else if(list == 2){
            System.out.println("2.您输入序号是："+list);
        }else{
            System.out.println("3.您输入序号有误!");
        };

        if(list % 2 == 0)
            System.out.println("少年,您发现了新大陆!if没有{}");

        /**
         * SWITCH语句：
         * a.表达式可以接收byte,short,char,int类型的数据,且引用数据类型还可以接收枚举(JDK1.5)，String字符串(JDK1.7)
         * b.执行流程：先计算表达式的值然后在和case后面的匹配，如果有就执行对应的case语句,否则执行default控制语句
         * c.case后面只能是常量,不能是变量或者表达式，
         * d.switch语句遇到break就结束(不加break可能导致case穿透),遇到continue就继续执行下一个case语句
         * e.switch语句总是从上执行到下,不论default发在哪里
         **/    
        switch(score)
        {
            case 90:
                System.out.println("评分为优");
                break;
            case 80:
                System.out.println("评分为良");
                break;
            case 70:
                System.out.println("评分为中等");
                break;
            case 60:
                System.out.println("评分为良");
                break;
            default:
                System.out.println("不及格");
                break;  //最后一个break可以省略
        }
        
        //switch 注意点
        int x = 1;
        int y = 1;
        switch(x){
            default:
                y++; //2
            case 2:
                y++; //3
            case 3:
                y++; //4
        }
        System.out.println(y);   //4
            
    }
}

//########### 执行结果 ##########
// 请输入您选择的序号(0-2):3
// 请输入成绩:90
// 3.您输入序号有误!
// 评分为优
// 4