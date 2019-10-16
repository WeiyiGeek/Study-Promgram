public class Fibonacci {
    public static void main(String[] args) {
        //实例1.斐波那契数列数组实现
        System.out.println("数组方式:"+fibonacciArray(20));

        //实例2.递归实现斐波那契数列
        System.out.println("递归方式:"+fibonacciRecursion(20));
    }
    //实例1
    public static int fibonacciArray(int count) {
        int[] arr = new int[count];
        arr[0] = 1;
        arr[1] = 1;
        if (count == 1 || count == 2) {
            return arr[1];
        } else {
            for (int i = 2; i < count; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[count - 1];
        }
    }

    //实例2
    public static int fibonacciRecursion(int count)
    {
        if (count == 1 || count == 2){
            return 1;
        }else{
            return fibonacciRecursion(count - 1) + fibonacciRecursion(count - 2);
        }
    }
}

/***
 * 执行结果
 javac -encoding utf-8 Fibonacci.java
 E:\githubProject\Study-Promgram\Data-Algorithm\02SimpleAlgorithrm>java Fibonacci
 数组方式:6765
 递归方式:6765
 * */