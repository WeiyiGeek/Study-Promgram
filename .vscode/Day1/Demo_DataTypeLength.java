package Day1;

// 数据类型 长度
class Demo_DataTypeLength {
    public static void main(String[] args) {
        //数据类型的长度
        // byte  
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);  
        System.out.println("包装类：java.lang.Byte");  
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE+"\n");
        
        //short
        System.out.println("基本类型：short 二进制位数" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");  
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);  
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE+"\n");
        
         //int  
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  
        System.out.println("包装类：java.lang.Integer");  
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);  
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);  
        System.out.println();  
  
        // long  
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);  
        System.out.println("包装类：java.lang.Long");  
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);  
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);  
        System.out.println();  
  
        // float  
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);  
        System.out.println("包装类：java.lang.Float");  
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);  
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);  
        System.out.println();  
  
        // double  
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);  
        System.out.println("包装类：java.lang.Double");  
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);  
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);  
        System.out.println();  
  
        // char  
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);  
        System.out.println("包装类：java.lang.Character");  
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台  
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE);  
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台  
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE);  
    }
}

//################### 执行结果 ##################
// 基本类型：byte 二进制位数：8
// 包装类：java.lang.Byte
// 最小值：Byte.MIN_VALUE=-128
// 最大值：Byte.MAX_VALUE=127

// 基本类型：short 二进制位数16
// 包装类：java.lang.Short
// 最小值：Short.MIN_VALUE=-32768
// 最大值：Short.MAX_VALUE=32767

// 基本类型：int 二进制位数：32
// 包装类：java.lang.Integer
// 最小值：Integer.MIN_VALUE=-2147483648
// 最大值：Integer.MAX_VALUE=2147483647

// 基本类型：long 二进制位数：64
// 包装类：java.lang.Long
// 最小值：Long.MIN_VALUE=-9223372036854775808
// 最大值：Long.MAX_VALUE=9223372036854775807

// 基本类型：float 二进制位数：32
// 包装类：java.lang.Float
// 最小值：Float.MIN_VALUE=1.4E-45
// 最大值：Float.MAX_VALUE=3.4028235E38

// 基本类型：double 二进制位数：64
// 包装类：java.lang.Double
// 最小值：Double.MIN_VALUE=4.9E-324
// 最大值：Double.MAX_VALUE=1.7976931348623157E308

// 基本类型：char 二进制位数：16
// 包装类：java.lang.Character
// 最小值：Character.MIN_VALUE=0
// 最大值：Character.MAX_VALUE=65535