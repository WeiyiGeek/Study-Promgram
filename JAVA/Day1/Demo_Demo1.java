// 控制流程案例
class Demo_Demo1 {
    public static void main(String[] args) {
        //* 1.九九乘法表 */
        for(int i = 1; i <= 9; i++)  //控制行数
        {
            for(int j = 1; j <= i; j++) //列数
            {
                System.out.print(j+"*"+i+"="+(i*j)+"\t");
            }
            System.out.println("");
        }

        //* 2. 控制跳转语句标号 | mark 标记*/
        outer: for(int x = 1; x < 10; x++)
        {
            System.out.println("外循环：x = "+x);
            inner: for(int y = 1; y < 10; y++)
            {
                System.out.print("内循环：y = "+y +"\t");
                if(x * y == 4)
                {
                    System.out.println("以跳出多重循环");
                    break outer;  //直接跳出多重循环 break 标号
                }
            }
        }

        //3.面试题 （下面http只是一个标号，后面是一个注释所有可以正确执行）
        http://www.baidu.com
        System.out.println("我也是可以正确执行得");
    }
}

// ##########################
// 外循环：x = 1
// 内循环：y = 1   内循环：y = 2   内循环：y = 3   内循环：y = 4   以跳出多重循环
// 我也是可以正确执行得