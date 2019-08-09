import java.math.BigDecimal;

class Demo_String {
    public static void main(String[] args) {
        /**
         * 1.数字类型转换成字符串型
         * 2.字符串型转换成各种数字类型
         * 3.扩展大数类型与字符串之间的转换 import java.math.BigDecimal;
         */

        //方法1：整形 -> 字符串
        double num1 = 1234.1234567;
        String snum1 = String.valueOf(num1);
        System.out.println("(1)整型 num1 采用string转换 成为字符串：" + snum1);
        System.out.println("(2)整型 num1 输出 成为字符串：" + num1);

        
        //方法2：字符 -> 整形(强制)
        String s = "64"; 
        byte b = Byte.parseByte( s );       //byte 类型
        short t = Short.parseShort( s );    //short 类型
        int i = Integer.parseInt( s );      //int 类型
        long l = Long.parseLong( s );       //Long int 类型
        Float f = Float.parseFloat( s );    //float 类型
        Double d = Double.parseDouble( s ); //double 类型
        System.out.println("(3)字符串 s = " + s);
        System.out.println(b + " - " + t + " - " + i + " - " + l + " - " + f + " - " + d);


        //方法3：大数类型与字符串之间的转换扩展
        String doubleStr = "44444.55555";
        BigDecimal bignum = new BigDecimal(doubleStr); //String类型转成bigdecimal类型生成bignum对象
        String str = bignum.toString();                //实现bigdecimal类型转成String类型：
        BigDecimal bd = bignum.setScale(2, BigDecimal.ROUND_HALF_UP);   //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入) 
        System.out.println("str 的大数据类型值是： " + str + "  提取str的小数点后两位的值：" + bd);   //str 的值是： 44444.55555   //44444.56
    }
}
