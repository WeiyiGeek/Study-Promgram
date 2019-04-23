// 运算操作符 （使用）
class Demo_OperationalCharacter {
    public static void main(String[] args) {
        /**#算法运算符*/
        //0. 整数与小数相除
        System.out.println( 10 / 3.0); //3.3333333333333335

        //1. % 符号
        System.out.println(-3 % 5);  //左边|-3| < |5| 则返回 -3
        System.out.println(-3 % 3); //左右两边绝对值一样返回 0
        System.out.println(-13 % 3); //余数操作至和左边值有关，-1 （正就是正/负就是负）
        System.out.println(13 % 3);  //余数操作至和左边值有关 1

        //2. 自加/自减
        int a = 0;
        System.out.println(a++);  //0 先赋值在++
        System.out.println(++a);  //2 先++再赋值
        //第二题
        int x = 1;
        int y = (x++)+(++x)+(x*10); //1 + 3 + 30
        System.out.println(y);      //34

        //3. 面试题（那一句话回报错）
        byte b = 10;
        b++; //默认在底层进行转换 b = (char)(b+1) 所以不会报错
        //b = b + 1;  //会产生错误需要进行强制类型转换由于byte和int计算，通过隐型需要将byte转换为int
        System.out.println(b); //11


        /*#赋值运算符 ：把右边的常量值赋值给左边的变量,左边必须是变量;*/
        //4.面试题：
        //short s = 1;s = s + 1; //当short与int进行运算时候，会将提升为int类型返回两个int相加后的结果
        short s = 1;s += 1; //不会报错 底层进行自动转换处理 s = (short)(s+1) 
        System.out.println(s); //2


        /*#关系运算符 */
        System.out.println(4 == 3); //false


        /*#逻辑运算符  
         5.&& 与 & 的区别：
            1）效果一样 
            2)&&类似于C有短路求值效果; 左边false，则右边不执行； 
         6.|| 与 |的区别：
            1）效果一样
            2）||也存在短路求值效率；左边为true，则右边不执行；
        */
        int a1 = 10;
        int b1 = 20;
        int c1 = 30;
        System.out.println(a1 > b1 ^ b1 < c1); //true（ ^ 逻辑异或 （true|false）则为真 ,其他都为假）
        System.out.println(a1 < b1 ^ b1 < c1); //false  (true|true) 则为假
        //7.a1 先赋值在++ 这时 a1 = 10 != 3 为假,由于短路求值的原因 ++b1是不被执行的；(结果还是false| a/b 返回 11，20)
        System.out.println((a1++ == 3) && (++b1 == 4));  
        //6.a1 先++在赋值 这时 a1 = 12 == 12 为真，由于短路求值的原因 b1++是不被执行的；（结果为true | a/b返回 12，20）
        System.out.println((++a1 == 12) || (b1++ == 4));  
        System.out.println(a1); //11
        System.out.println(b1); //20
        
        
        /*#为运算符 : 
            ~ ：按位取反 3 = -（3+1）
            << : 向左移动最高位丢弃，右边填0补齐（左移，向左移动几位就是乘以2的几次幂）
            >>> : 无符号右移动，无论最高位是0还是1，左边补齐0
         */  
        System.out.println(6 & 3); // 0110 
                                   // 0011 = 0010 = 2
        System.out.println(6 | 3); // 0111 = 7 
        System.out.println(6 ^ 3); // 0101 = 5
        //7.按位取反
        // 0000 0011 3的原码/反码/补码
        // 1111 1100 对3按位取反
        // 0000 0001  
        // 1111 1011 反码 = 补码 - 1
        // 1000 0100 原码
        System.out.println(~3);  // -4
        //8.^位异或运算符的特定：一个数据对另一个数据位异或两次，该数不变(常常使用在对称加密中)
        System.out.println(5 ^ 10 ^ 5); // 10
        //利用：交换两个数且只有两个变量 (还有一种 x = x + y的方法有弊端可能会超过int取值类型范围)
        int change1 = 5;
        int change2 = 6;
        change1 ^= change2;  // 5 ^ 6 
        change2 ^= change1;  // 6 ^ 5 ^ 6 = 5 
        change1 ^= change2;  // 5 ^ 6 ^ 5 = 6
        System.out.println(change1); //6
        System.out.println(change2); //5

        //9. << 与 >>> 移位运算 (运算效率最高，对二进制位进行操作)
        System.out.println(12 << 1); // 12 * (2 ^ 1) =  24
        System.out.println(24 >> 2); // 24 / (2 ^ 2) = 6
        System.out.println(24 >>> 2); // 6 无符号移动
        System.out.println(-24 >>> 2); // 1073741818 无符号移动
        // 10000000 00000000 00000000 00011000 = -24 （原码）
        // 00100000 00000000 00000000 00000110 > 向右移动2位  （最高位可以不管了）
        // 00011111 11111111 11111111 11111001 > 反码
        // 00011111 11111111 11111111 11111010 > 补码 = 1073741818


        /***
         * #三元运算符
         * (关系表达式)？表达式1 ： 表达式2
         */
        int three = (change1 > change2)? 1:0;
        System.out.println(three); //1
        //获取三个值里面的最大值
        int max = (a1 > b1) ? a1:b1; 
        max = (max > c1) ? max:c1;
        System.out.println(max);  //30
    }
}