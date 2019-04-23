// 数据类型转换案例
class Demo_DataTypeConversion {
    public static void main(String[] args) {
        //1.隐式转换
        byte b = 3;
        int i = 4;
        i += b; // 这里的b将自动转换成为int类型(注意点)
        System.out.println(i); //7

        //2.强制转换
        byte b1 = 3;
        int i1 = 4;
        b1 = (byte)(i1 + b1);
        System.out.println(b1); //7

        //3.如果值不该该类型得取值范围内（向下强转）将会损失精度
        /***
         * 0000000 00000000 00000000 10000010 = 130二进制
         * 经过byte强制类型转换(去掉前面的3个字节)
         * 10000010  = -126的补码
         * 10000001 = -126的反码
         * 11111110 = -126的原码
         */
        byte b2 = (byte)(126 + 4); 
        System.out.println(b2); //-126

        //4.面试题
        /***
         * 1) byte与byte(或short,char)进行运算的时候会提升为int,两个类型相加的结果也是int类型
         * 2) bt1与bt2是两个变量,变量妞的值是变化的,在编译的时候无法判断里面具体的值,有可能会超出 byte的取值
         **/
        byte bt1 = 3;
        byte bt2 = 4;
        //byte bt3 = bt1 + bt2;  //输入bt3会进行报错
        

        //5.对比面试题
        byte bt4 = 3 + 4; //java编译器有常量的优化机制 (且固定在byte类型范围内)
        System.out.println(bt4);  //7


        //6.long与float转换
        float f1 = 12.34f;
        long l1 = 123456;
        float f2 = l1; //隐型转换 
        long l2 = (long)f1;    //强制转换 
        System.out.println(f2);  //123456.0
        System.out.println(l2);  //12


        //实际案例1:
		char charword = 'A';     //ASCII 65 
		int ch = charword + 1;   // 隐形转换
		System.out.println(ch);  // 65 + 1 = 66
		System.out.println("\'A\'+1 = "+ charword + 1);   //字符串+整形 或者 字符 == 自动转换成字符串形式
		
        //实际案例2:
		ch = 97;
		char chr = (char)ch;  //将整形转换成为字符类型
		System.out.println((char)48+ch);  //自动转换成为整形进行相加
		System.out.print(chr+"\n");
		
        //实际案例3:
        System.out.println((int)12.2132f);  //强制转换 (小数直接虐去)
        System.out.println((float)12);
        System.out.println((double)ch);
    }
}


//######### 执行结果 ######
// 66
// 'A'+1 = A1
// 145
// a
// 12
// 12.0
// 97.0